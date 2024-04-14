package tn.esprit.coexist.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import tn.esprit.coexist.entity.Booking;
import tn.esprit.coexist.entity.Carpooling;
import tn.esprit.coexist.repository.BookingRepository;
import tn.esprit.coexist.repository.CarpoolingRepository;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import java.util.List;

@Service
@AllArgsConstructor
public class BookingServiceImp implements BookingService{
CarpoolingRepository carpoolingRepository;
BookingRepository bookingRepository;


    @Override
    public Booking addBooking(Booking booking, Integer carpoolingID) {
        Carpooling carpooling = carpoolingRepository.findById(carpoolingID)
                .orElseThrow(() -> new IllegalArgumentException("Invalid carpooling ID"));

        // Calculate the delay in milliseconds until one hour after departure time
        LocalDateTime departureTime = carpooling.getDepartureTime();
        LocalDateTime emailSendTime = departureTime.plusHours(1);
        long delayInMillis = Duration.between(LocalDateTime.now(), emailSendTime).toMillis();

        // Schedule email sending task
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.schedule(() -> sendDelateCarpoolingEmail(), delayInMillis, TimeUnit.MILLISECONDS);

        // Decrease available seats
        int nb = booking.getNb();
        int updatedAvailableSeats = carpooling.getAvailableSeats() - nb;
        if (updatedAvailableSeats < 0) {
            throw new IllegalStateException("No available seats for this carpooling");
        }
        carpooling.setAvailableSeats(updatedAvailableSeats);
        carpoolingRepository.save(carpooling);

        // Assign the carpooling to the booking
        booking.setCarpooling(carpooling);
        return bookingRepository.save(booking);
    }

    @Override
    public void deleteBooking(Integer bookingId) {
        bookingRepository.deleteById(bookingId);}


    @Override
    public List<Booking> getALLBooking() {
        return bookingRepository.findAll();
    }
    @Autowired
    private JavaMailSender javaMailSender;
    @Override
    public void sendDelateCarpoolingEmail() {
        SimpleMailMessage message = new SimpleMailMessage();
        String Newligne = System.getProperty("line.separator");
        String url = "http://localhost:4200/addCarpooling";
        message.setFrom("srayen60@gmail.com");
        message.setTo("ayadi.jasser@esprit.tn");
        message.setSubject("carpooling delated!");
        message.setText("Hi,\n\n\n" +
                "Apologies for misunderstanding. If you meant to say \"deleted\" instead of \"delayed,\" you can announce it as follows:\n" +
                "\n" +
                "Subject: Carpooling Update: Cancellation\n" +
                "\n" +
                "Dear [Carpool Participants],\n" +
                "\n" +
                "I hope this message finds you well. Unfortunately, I must inform you that one of carpoolings arrangement  has been canceled.\n"
                +
                " we are unable to proceed with the planned carpooling.\n" +
                "\n" +
                "Please make alternative arrangements for your transportation needs on that day.\n" +
                "\n" +
                "I apologize for any inconvenience this may cause and appreciate your understanding.\n" +
                "\n" +
                "Thank you for your cooperation.\n \nBest regards,\nThe [COEXIST] Team\");" + Newligne +url);
        javaMailSender.send(message);
    }
}




package tn.esprit.coexist.entity;

import jakarta.persistence.*;
import lombok.*;


import java.util.List;

@Entity
@Data

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private  String username;
    private  String password;
    private  String email;
    private  Long phoneNumber;
    private  String Address;
    private  String image;
    private  Integer rate;

    private  Boolean enable;
@ManyToOne
private  Role role;
@OneToMany(mappedBy ="user" ,cascade = CascadeType.ALL)
private List<Carpooling>carpoolingList;
@OneToOne
private Preference preference;
     @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Product>products;
@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
private List<Event>events;
//@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
//List<EventBooking>eventBookings;
@OneToMany(mappedBy = "user" , cascade = CascadeType.ALL)
private List<Comment> comments;
@OneToMany(cascade = CascadeType.ALL)
private List<Subject>subjects;
@OneToMany(mappedBy = "user" , cascade = CascadeType.ALL)
private List<React>reactList;
@ManyToMany
private   List<Chatroom>chatrooms;
@OneToMany(cascade = CascadeType.ALL)
private   List<Message>messages;
@OneToMany(cascade = CascadeType.ALL)
private   List<CollocationBooking>collocationBookings;
@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
private List<AnnoncementCollocation>annoncementCollocations;
















}

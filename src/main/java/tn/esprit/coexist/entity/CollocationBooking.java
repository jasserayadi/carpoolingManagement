package tn.esprit.coexist.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data
public class CollocationBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCollocationBooking;
    private Date startDate;
    private Date endDate;
    @Enumerated(EnumType.STRING)
    private PersonType personType;
    @OneToMany(mappedBy = "collocationBooking",cascade = CascadeType.ALL)
    private List<CollocationFeedback>CollocationFeedbacks;
}

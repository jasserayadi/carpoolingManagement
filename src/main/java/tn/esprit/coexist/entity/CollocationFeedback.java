package tn.esprit.coexist.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class CollocationFeedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer feedId;
    private String note;
    @ManyToOne
    private CollocationBooking collocationBooking;
}

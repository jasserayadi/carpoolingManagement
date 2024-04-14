package tn.esprit.coexist.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Picture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer pictureId;
    private  String url;
    @ManyToOne
    private AnnoncementCollocation annoncementCollocation;
}

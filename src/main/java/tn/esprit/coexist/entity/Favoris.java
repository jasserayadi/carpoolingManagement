package tn.esprit.coexist.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Entity
@Data
public class Favoris {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer favId;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<AnnoncementCollocation> annoncementCollocationList;





}

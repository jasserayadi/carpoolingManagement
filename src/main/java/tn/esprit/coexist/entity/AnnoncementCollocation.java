package tn.esprit.coexist.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class AnnoncementCollocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer annoncementCollocationId;
    private String cotype;
    private Integer homeSize;
    private Integer numPerso;
    private String equipement;
    private String address;
    private float pricePerPerson;
    @Enumerated(EnumType.STRING)
    private HouseType houseType;
    @OneToMany(mappedBy = "annoncementCollocation",cascade = CascadeType.ALL)
    private List<Picture>pictures;
    @ManyToOne
    private User user;}

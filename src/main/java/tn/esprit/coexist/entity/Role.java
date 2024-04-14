package tn.esprit.coexist.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data

public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUser;
    @Enumerated(EnumType.STRING)
    private  RoleName roleName;
    @OneToMany(mappedBy = "role",cascade = CascadeType.ALL )
    private List<User> users;

}

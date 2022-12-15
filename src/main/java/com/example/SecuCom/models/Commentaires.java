package com.example.SecuCom.models;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Commentaires")
@NoArgsConstructor
@Getter
@Setter
public class Commentaires {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idcom;
    private String contenucom;
    @ManyToOne
    private User user;
    @ManyToOne
    private Regions regions;


}

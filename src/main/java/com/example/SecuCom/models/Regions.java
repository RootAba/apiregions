package com.example.SecuCom.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Regions")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Regions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idregion;
    private  String coderegions,nomRegion,superficie,langue,domaine,image;


    @ManyToOne
    private  Pays pays;

    @ManyToOne
    private  Population population;

    @JsonIgnore
    @OneToMany(mappedBy = "regions", cascade = CascadeType.ALL)
    List<Sitetouristique> sitetouristiques = new ArrayList<>();


    @JsonIgnore
    @OneToMany(mappedBy = "regions", cascade = CascadeType.ALL)
    List<Commentaires> commentaires = new ArrayList<>();
}

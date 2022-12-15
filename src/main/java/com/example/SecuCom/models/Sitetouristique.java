package com.example.SecuCom.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "Sitetouristique")
@NoArgsConstructor
@Getter
@Setter
public class Sitetouristique {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idsite;
    private String nomsite,descriptionsite,imagesite;

    @ManyToOne
    private Regions regions;


}

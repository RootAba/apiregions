package com.example.SecuCom.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Pays")
@NoArgsConstructor

public class Pays {
    public Long getIdPays() {
        return idPays;
    }

    public void setIdPays(Long idPays) {
        this.idPays = idPays;
    }

    public String getNomPays() {
        return nomPays;
    }

    public void setNomPays(String nomPays) {
        this.nomPays = nomPays;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPays;
    private  String nomPays;
}

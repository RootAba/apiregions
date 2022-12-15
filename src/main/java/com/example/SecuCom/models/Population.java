package com.example.SecuCom.models;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Population")
@NoArgsConstructor
public class Population {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long idPop;
    private String chiffrePop;

    public long getIdPop() {
        return idPop;
    }

    public void setIdPop(long idPop) {
        this.idPop = idPop;
    }

    public String getChiffrePop() {
        return chiffrePop;
    }

    public void setChiffrePop(String chiffrePop) {
        this.chiffrePop = chiffrePop;
    }

    public Long getAnnee() {
        return annee;
    }

    public void setAnnee(Long annee) {
        this.annee = annee;
    }

    private Long annee;
}

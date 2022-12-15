package com.example.SecuCom.service;


import com.example.SecuCom.models.Population;

import java.util.List;

public interface PopServInter {


    Population ajouterPopulation(Population population);

    List<Population> affichagePopu();

    //Methode de modif
    Population modifierPopu(Long idPop,Population population);

    String DeletePopu(Long idPop);
    Population popById(long id);
}

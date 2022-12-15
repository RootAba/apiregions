package com.example.SecuCom.service;


import com.example.SecuCom.models.Pays;

import java.util.List;

public interface PaysServInter {

    Pays ajouterPays(Pays pays);

    List<Pays> affichagePays();

    //Methode de modif
    Pays modifierPays(Long idPays,Pays pays);

    String DeletePays(Long idPays);


}

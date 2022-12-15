package com.example.SecuCom.service;

import com.example.SecuCom.models.Regions;
import com.example.SecuCom.models.Sitetouristique;

import java.util.List;

public interface SitetouristiqueInterface {

     Sitetouristique CreerSite(Sitetouristique sitetouristique);

     //Affichage de toutes les sites
     List<Sitetouristique> afficherSite();

    //Methode de modif
    Sitetouristique modifierSite(Sitetouristique sitetouristique);

    String Delete(Long idsite);

    //Site par id region
    List<Sitetouristique> siteParRegion(Long idregion);
}

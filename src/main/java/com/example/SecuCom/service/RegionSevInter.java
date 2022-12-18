package com.example.SecuCom.service;


import com.example.SecuCom.models.Regions;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public interface RegionSevInter {
    //methode permettant d'ajouter des données dans bd
    Regions AjoutRegion(Regions regions);

    //Affichage de toutes les regions on va creer une liste
    List<Regions> affichageRegions();

    //Methode de modif
    Regions modifierRegion(Long idRegions,Regions regions);

    String Delete(Long idRegion);

    Optional<Regions> RegionParId(@PathVariable Long idregion);


}

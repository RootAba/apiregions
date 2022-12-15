package com.example.SecuCom.controllers;


import com.example.SecuCom.models.Regions;
import com.example.SecuCom.models.Sitetouristique;
import com.example.SecuCom.serviceImplementation.SaveImage;
import com.example.SecuCom.serviceImplementation.SitetouristiqueServImplement;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/site")

@Api(value = "hello", description = "Toutes les opérations concernant la table Sites touristiques")
public class SiteTouristiqueController {
    @Autowired
    private SitetouristiqueServImplement sitetouristiqueServImplement;

    @ApiOperation(value = "Ajout de site touristique en tenant compte de la region ")
    @PostMapping("/creation")
    public String CreationDeSite(
            @RequestParam(value = "data") String sitetour,
                                 @RequestParam(value = "file", required = false) MultipartFile file) throws JsonProcessingException{
        Sitetouristique site = null;
        try {
            site = new JsonMapper().readValue(sitetour, Sitetouristique.class);
            System.out.println(site);
        } catch (Exception e) {
            System.out.println(site);
        }
        try {
            site.setImagesite(SaveImage.save("site", file, site.getImagesite()));

            //  :::::::::::::: creation de site touristique : :::::::::
        } catch (Exception e) {
            // TODO: handle exception
            return "erreur lors de l'importation del'image";
        }
        sitetouristiqueServImplement.CreerSite(site);
        return "operation effectuer";
    }


    @ApiOperation(value = "modifier de site touristique en tenant compte de la region ")
    @PostMapping("/modifSite")
    public String ModifierSite(@RequestParam(value = "data") String sitetour) {
        Sitetouristique site = null;
        try {
            site = new JsonMapper().readValue(sitetour, Sitetouristique.class);
            System.out.println(site);
        } catch (Exception e) {

        }
        try {
            sitetouristiqueServImplement.modifierSite(site);
        } catch (Exception e) {
            System.out.println("erreur lors du modif");
        }
        return "Operation effectuer avec succes";
    }


    @ApiOperation(value = "Afficher de site touristique en tenant compte de la region ")
    @PostMapping("/afficher")
    public List<Sitetouristique> AfficherToutesSites(){

        return sitetouristiqueServImplement.afficherSite() ;
    }

    @ApiOperation(value = "Supprimer de site touristique en tenant compte de la region ")
    @DeleteMapping("/supprimersite")
    public String DeleteSite(@PathVariable long idsite){
        sitetouristiqueServImplement.Delete(idsite);
        return "operation effectuer";
    }

    @ApiOperation(value = "Afficher de site touristique d'une region donnée ")
    @DeleteMapping("/affichersiteregion")
    public List<Sitetouristique> AfficherSiteRegion(@PathVariable long idregion){
        return sitetouristiqueServImplement.siteParRegion(idregion);
    }


}

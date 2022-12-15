package com.example.SecuCom.controllers;



import com.example.SecuCom.models.Pays;
import com.example.SecuCom.models.Population;
import com.example.SecuCom.models.Regions;
import com.example.SecuCom.serviceImplementation.PaysServImplement;
import com.example.SecuCom.serviceImplementation.PopServImplement;
import com.example.SecuCom.serviceImplementation.RegionServImplement;
import com.example.SecuCom.serviceImplementation.SaveImage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/regions")

@Api(value = "hello", description = "Toutes les opérations concernant la table Région")
public class RegionController {
@Autowired
private RegionServImplement reSeImpt;
    @Autowired
    private PaysServImplement paysSeImpt;
    @Autowired
    private PopServImplement popServImplement;
    @ApiOperation(value = "Ajout de region en tenant compte du pays et de la population")
    @PostMapping("/creation")

    public  String CreationRegion(@RequestParam(value = "data") String reg,
                                  @RequestParam(value = "population") String population,
                            //      @RequestParam(value = "user") String userVenant,
                                  @RequestParam(value = "file", required = false) MultipartFile file) throws JsonProcessingException {
        Regions regions = null;
        Population population1=null;

        try {
            regions = new JsonMapper().readValue(reg, Regions.class);
            System.out.println(regions);
           // utilisateurs = new JsonMapper().readValue(userVenant, Utilisateur.class);
        } catch (Exception e) {
            System.out.println(regions);
        }

        //       Enregistrer image
        try {
            regions.setImage(SaveImage.save("regions", file, regions.getNomRegion()));
        } catch (Exception e) {
            // TODO: handle exception
            return "erreur lors de l'importation del'image";
        }
        Pays pays =regions.getPays();
        if(pays ==null){
            return "pays n'existe pas";
        }
        else{
            paysSeImpt.ajouterPays(regions.getPays());
            population1 = new JsonMapper().readValue(population, Population.class);
            popServImplement.ajouterPopulation(population1);
            reSeImpt.AjoutRegion(regions);
        }
        return "ajouter avec succes";
    }

    /*
    public Regions creation(@RequestBody Regions region, Population population){

        Pays pays =region.getPays();
      //  if(pays==null){
            paysSeImpt.ajouterPays(region.getPays());
            popServImplement.ajouterPopulation(population);
     //   }
        return  reSeImpt.AjoutRegion(region);
}*/

    @ApiOperation(value = "Affichage de la liste des régions avec Pays")
    @GetMapping("/afficher")
public List<Regions> afficher(){

        return  reSeImpt.affichageRegions();
}
    @ApiOperation(value = "Modification  d'une  region en tenant compte du pays et de la population")
@PutMapping("/modifier/{idRegion}")
public Regions modifer(@PathVariable Long idRegion,@RequestBody Regions regions){
    return  reSeImpt.modifierRegion(idRegion,regions);
}
    @ApiOperation(value = "Suppression d'une région")
@DeleteMapping("/supprimer/{idRegion}")
public String supprimer(@PathVariable Long idRegion){
    return  reSeImpt.Delete(idRegion);
}


}

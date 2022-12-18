package com.example.SecuCom.controllers;


import com.example.SecuCom.models.Commentaires;
import com.example.SecuCom.models.Regions;
import com.example.SecuCom.serviceImplementation.CommentaireImplementation;
import com.fasterxml.jackson.databind.json.JsonMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commentaires")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600,allowCredentials = "true")
@Api(value = "hello", description = "Toutes les opérations concernant la table Commentaires")
public class CommentairesController {

    @Autowired
    private CommentaireImplementation commentaireImplementation;


    @ApiOperation(value = "Ajout de commentaires")
    @PostMapping("/ajoutcommentaire")
    public String ajoutCommentaire(@RequestParam(value = "data") String comm){

        Commentaires commentaires = null;

        try {
            commentaires = new JsonMapper().readValue(comm, Commentaires.class);
            System.out.println(commentaires);
            // utilisateurs = new JsonMapper().readValue(userVenant, Utilisateur.class);
        } catch (Exception e) {
            System.out.println("erreru lors de l'ajout de commentaires"+commentaires);
        }
        try {
            commentaireImplementation.CreerCommentaire(commentaires);
        }
        catch (Exception e){
            System.out.println("erreru lors de l'ajout de commentaires"+commentaires);
        }

        return  "Operation effectuer avec succes";
    }

    @ApiOperation(value = "Affichage des commentaires")
    @GetMapping("/affichercommentaire")
    public List<Commentaires> AffichageCommentaire(){

        return commentaireImplementation.afficherToutComm();
    }

    @ApiOperation(value = "Affichage des commentaires par regions")
    @GetMapping("/affichercommentaireRegion/{idregion}")
    public List<Commentaires> AffichageCommentaireRegion(@PathVariable long idregion){

        return commentaireImplementation.AffichageCommParRegion(idregion);
    }

}

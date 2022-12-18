package com.example.SecuCom.serviceImplementation;


import com.example.SecuCom.models.Commentaires;
import com.example.SecuCom.models.Regions;
import com.example.SecuCom.repository.CommentaireRepository;
import com.example.SecuCom.repository.RegionRepository;
import com.example.SecuCom.service.CommentaireInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CommentaireImplementation implements CommentaireInterface {

    private CommentaireRepository commentaireRepository;
    private RegionRepository regionRepository;

    @Override
    public Commentaires CreerCommentaire(Commentaires commentaires) {
        return commentaireRepository.save(commentaires);
    }

    @Override
    public List<Commentaires> afficherToutComm() {
        return commentaireRepository.findAll();
    }

    @Override
    public List<Commentaires> AffichageCommParRegion(Long idregion) {

        Regions region = regionRepository.findById(idregion).get();

        List<Commentaires> commentaireAjouter = new ArrayList<>();
        List<Commentaires> toutscomm = commentaireRepository.findAll();

        for (Commentaires c:toutscomm){
            try{
                if(c.getRegions().getIdregion().equals(region.getIdregion())){
                    commentaireAjouter.add(c);
                }
            } catch (Exception e){

            }
        }

        return commentaireAjouter;
    }
}

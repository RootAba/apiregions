package com.example.SecuCom.serviceImplementation;


import com.example.SecuCom.models.Pays;
import com.example.SecuCom.repository.PaysRepository;
import com.example.SecuCom.service.PaysServInter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PaysServImplement implements PaysServInter {

    private PaysRepository pr;
    @Override
    public Pays ajouterPays(Pays pays) {
        return pr.save(pays);
    }

    @Override
    public List<Pays> affichagePays() {
        return pr.findAll();
    }

    @Override
    public Pays modifierPays(Long idPays, Pays pays) {
      return   pr.findById(idPays).map(
                p->{
                    p.setNomPays(pays.getNomPays());
                    return pr.save(p);
                }
        ).orElseThrow(() -> new RuntimeException("Pays non trouvé"));

    }

    @Override
    public String DeletePays(Long idPays) {
        pr.deleteById(idPays);
        return "Pays Supprimer avec succes";
    }
}

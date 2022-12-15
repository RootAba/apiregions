package com.example.SecuCom.serviceImplementation;

import com.example.SecuCom.models.Sitetouristique;
import com.example.SecuCom.repository.SitetouristiqueRepo;
import com.example.SecuCom.service.SitetouristiqueInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class SitetouristiqueServImplement implements SitetouristiqueInterface {


  private SitetouristiqueRepo sitetouristiqueRepo;
    @Override
    public Sitetouristique CreerSite(Sitetouristique sitetouristique) {
        return sitetouristiqueRepo.save(sitetouristique);
    }

    @Override
    public List<Sitetouristique> afficherSite() {
        return sitetouristiqueRepo.findAll();
    }

    @Override
    public Sitetouristique modifierSite( Sitetouristique sitetouristique) {
        return sitetouristiqueRepo.save(sitetouristique);
    }

    @Override
    public String Delete(Long idsite) {
        sitetouristiqueRepo.deleteById(idsite);
        return "Supprimer avec succes";
    }

    @Override
    public List<Sitetouristique> siteParRegion(Long idregion) {

        return sitetouristiqueRepo.findAll();
    }
}

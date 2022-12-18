package com.example.SecuCom.serviceImplementation;

import com.example.SecuCom.models.Commentaires;
import com.example.SecuCom.models.Regions;
import com.example.SecuCom.models.Sitetouristique;
import com.example.SecuCom.repository.RegionRepository;
import com.example.SecuCom.repository.SitetouristiqueRepo;
import com.example.SecuCom.service.SitetouristiqueInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class SitetouristiqueServImplement implements SitetouristiqueInterface {


  private SitetouristiqueRepo sitetouristiqueRepo;
  private RegionRepository regionRepository;
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

        Regions region = regionRepository.findById(idregion).get();
        System.out.println("cvbn,;"+region.getNomRegion());

        List<Sitetouristique> newsite = new ArrayList<>();
        List<Sitetouristique> toutsite = sitetouristiqueRepo.findAll();

        for (Sitetouristique s:toutsite){
            try{
                if(s.getRegions().getIdregion().equals(region.getIdregion())){
                    newsite.add(s);
                }
            } catch (Exception e){

            }
        }

        return newsite;
    }
}

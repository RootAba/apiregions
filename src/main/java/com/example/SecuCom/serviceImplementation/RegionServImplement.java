package com.example.SecuCom.serviceImplementation;


import com.example.SecuCom.models.Regions;
import com.example.SecuCom.repository.RegionRepository;
import com.example.SecuCom.service.RegionSevInter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RegionServImplement implements RegionSevInter {

    private RegionRepository rr;
    @Override
    public Regions AjoutRegion(Regions regions) {
        return rr.save(regions);
    }



    @Override
    public List<Regions> affichageRegions() {
        return rr.findAll();
    }

    @Override
    public Regions modifierRegion(Long idRegions, Regions regions) {

        return rr.findById(idRegions).map(
                p->{
                    p.setCoderegions(regions.getCoderegions());
                    p.setNomRegion(regions.getNomRegion());
                    p.setSuperficie(regions.getSuperficie());
                    p.setDomaine(regions.getDomaine());
                    p.setLangue(regions.getLangue());

                  return rr.save(p);
        }
        ).orElseThrow(() -> new RuntimeException("Region non trouvé"));

    }

    @Override
    public String Delete(Long idRegion) {
        rr.deleteById(idRegion);
        return "Personne delete avec succes";
    }

    @Override
    public Optional<Regions> RegionParId(Long idregion) {
        return rr.findById(idregion);
    }
}

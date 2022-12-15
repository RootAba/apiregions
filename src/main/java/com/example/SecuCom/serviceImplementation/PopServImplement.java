package com.example.SecuCom.serviceImplementation;


import com.example.SecuCom.models.Population;
import com.example.SecuCom.repository.PopRepository;
import com.example.SecuCom.service.PopServInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PopServImplement implements PopServInter {
    @Autowired
    private PopRepository popRep;
    @Override
    public Population ajouterPopulation(Population population) {
        return popRep.save(population);
    }

    @Override
    public List<Population> affichagePopu() {
        return popRep.findAll();
    }

    @Override
    public Population modifierPopu(Long idPop, Population population) {
        return popRep.findById(idPop).map(
                p->{
                    p.setChiffrePop(population.getChiffrePop());
                    p.setAnnee(population.getAnnee());
                    return popRep.save(p);
                }
        ).orElseThrow(() -> new RuntimeException("Population non trouvé"));
    }

    @Override
    public String DeletePopu(Long idPop) {
        popRep.deleteById(idPop);
        return "Population supprimer avec succes";
    }

    @Override
    public Population popById(long id) {
        return popRep.getById(id);
    }
}

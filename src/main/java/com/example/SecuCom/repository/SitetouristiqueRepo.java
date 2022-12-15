package com.example.SecuCom.repository;

import com.example.SecuCom.models.Sitetouristique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface SitetouristiqueRepo extends JpaRepository<Sitetouristique,Long> {
/*
   @Query(value = "select * from sitetouristique where sitetouristique.region_idregion = :idregion ")
    public List<Sitetouristique> siteparRegion(@PathVariable long idregion);*/
}

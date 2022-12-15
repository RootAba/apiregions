package com.example.SecuCom.repository;


import com.example.SecuCom.models.Population;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PopRepository extends JpaRepository<Population,Long> {
}

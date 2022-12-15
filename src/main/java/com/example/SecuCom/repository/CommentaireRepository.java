package com.example.SecuCom.repository;

import com.example.SecuCom.models.Commentaires;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CommentaireRepository extends JpaRepository<Commentaires,Long> {
}

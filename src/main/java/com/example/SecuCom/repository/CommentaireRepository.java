package com.example.SecuCom.repository;

import com.example.SecuCom.models.Commentaires;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@Repository
public interface CommentaireRepository extends JpaRepository<Commentaires,Long> {


}

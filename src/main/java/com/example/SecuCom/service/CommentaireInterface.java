package com.example.SecuCom.service;

import com.example.SecuCom.models.Commentaires;
import com.example.SecuCom.models.Sitetouristique;

import java.util.List;

public interface CommentaireInterface {


    Commentaires CreerCommentaire(Commentaires commentaires);


    List<Commentaires> afficherToutComm();

}

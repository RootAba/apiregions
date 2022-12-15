package com.example.SecuCom.serviceImplementation;


import com.example.SecuCom.models.Commentaires;
import com.example.SecuCom.repository.CommentaireRepository;
import com.example.SecuCom.service.CommentaireInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CommentaireImplementation implements CommentaireInterface {

    private CommentaireRepository commentaireRepository;

    @Override
    public Commentaires CreerCommentaire(Commentaires commentaires) {
        return commentaireRepository.save(commentaires);
    }

    @Override
    public List<Commentaires> afficherToutComm() {
        return commentaireRepository.findAll();
    }
}

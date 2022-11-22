package br.com.zago.linguagensapi.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import br.com.zago.linguagensapi.model.Linguagem;

public interface LinguagemRepository extends MongoRepository<Linguagem, String> {
    
    @Query("{title:'?0'}")
    Linguagem findItemByName(String title);
    List<Linguagem> findByOrderByVotosDesc();
}

package br.com.zago.linguagensapi.service;

import java.util.List;
import org.springframework.stereotype.Service;

import br.com.zago.linguagensapi.model.Linguagem;

@Service
public interface LinguagemService {
    
    public Linguagem votar(String nomeLinguagem) throws Exception;
    public Linguagem atualizarLinguagem(Linguagem linguagem) throws Exception;
    public Linguagem cadastrarLinguagem(Linguagem linguagem);
    public List<Linguagem> obterLinguagens();
    public void deletarLinguagem(String id);
    public void atualizarRanking() throws Exception;
    public Linguagem findById(String id);
}

package br.com.zago.linguagensapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zago.linguagensapi.model.Linguagem;
import br.com.zago.linguagensapi.repository.LinguagemRepository;

@Service
public class LinguagemServiceImpl implements LinguagemService{

    @Autowired
    private LinguagemRepository repositorio;
    
    /* (non-Javadoc)
     * @see br.com.zago.linguagensapi.service.LinguagemService#votar(java.lang.String)
     */
    @Override
    public Linguagem votar(String nomeLinguagem) throws Exception {
        Linguagem lingVotada = repositorio.findItemByName(nomeLinguagem.toUpperCase());
        if (lingVotada!= null) {
            lingVotada.receberVoto();
            this.atualizarLinguagem(lingVotada);
            this.atualizarRanking();
            return lingVotada;
        } else {
            throw new Exception("Linguagem não encontrada");
        }
        
    }

    @Override
    public Linguagem atualizarLinguagem(Linguagem linguagem) throws Exception {
        return repositorio.save(linguagem);
    }

    @Override
    public Linguagem cadastrarLinguagem(Linguagem linguagem) {
        return repositorio.save(linguagem);
    }

    @Override
    public List<Linguagem> obterLinguagens() {
        return repositorio.findAll();
    }

    @Override
    public void deletarLinguagem(String id) {
        try {
            repositorio.deleteById(id);
        } catch (Exception e) {
            throw e;
        }
        
    }

    public void atualizarRanking() throws Exception{
        List<Linguagem> lings = repositorio.findByOrderByVotosDesc();
        int ranking = 1;
        for (Linguagem linguagem : lings) {
            linguagem.setRanking(ranking);
            atualizarLinguagem(linguagem);
            ranking += 1;
        }        
    }

    @Override
    public Linguagem findById(String id) {
        return repositorio.findById(id).get();
    }
    
}

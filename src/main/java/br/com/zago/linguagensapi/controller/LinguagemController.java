package br.com.zago.linguagensapi.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.zago.linguagensapi.model.ApiMessage;
import br.com.zago.linguagensapi.model.Linguagem;
import br.com.zago.linguagensapi.service.LinguagemService;

@RestController
public class LinguagemController {
    
    @Autowired
    private LinguagemService service;
    
    /**
     * @return
     */
    @GetMapping("/linguagens")
    public ResponseEntity<?> obterLinguagens() {
        List<Linguagem> listRetorno = service.obterLinguagens();
        if (listRetorno.equals(null)) {
            return new ResponseEntity<ApiMessage>(new ApiMessage("Não há linguagens cadastradas"), HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<List<Linguagem>>(listRetorno, HttpStatus.OK);
        }
    }

    @GetMapping("/linguagens/{title}")
    public ResponseEntity<?> votar(@PathVariable("title") String title) {
        try {
            Linguagem lingRetorno = service.votar(title);
            return new ResponseEntity<Linguagem>(lingRetorno, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<ApiMessage>(new ApiMessage(e.getMessage()), HttpStatus.NOT_FOUND);
        }
    }

    /**
     * @param linguagem
     * @return
     */
    @PostMapping("/linguagens")
    public ResponseEntity<?> cadastrarLinguagem(@RequestBody Linguagem linguagem) {
        Linguagem language = service.cadastrarLinguagem(linguagem);
        return new ResponseEntity<Linguagem>(language, HttpStatus.CREATED);
    }


    /**
     * @param id
     * @param linguagem
     * @return
     */
    @PutMapping("/linguagens/{id}")
    public ResponseEntity<?> updateLinguagem(@PathVariable("id") String id, @RequestBody Linguagem linguagem) {
        Linguagem ling = service.findById(id);
        if (ling != null) {
            Linguagem lingToSave = ling;
            lingToSave.setImage(linguagem.getImage() != null? linguagem.getImage() : lingToSave.getImage());
            lingToSave.setRanking(linguagem.getRanking() > 0? linguagem.getRanking() : lingToSave.getRanking());
            lingToSave.setTitle(linguagem.getTitle() != null? linguagem.getTitle().toUpperCase() : lingToSave.getTitle().toUpperCase());
            try {
                service.atualizarLinguagem(lingToSave);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return new ResponseEntity<Linguagem>(lingToSave, HttpStatus.OK);
        } else {
            return new ResponseEntity<ApiMessage>(new ApiMessage("Não há nenhuma Linguagem com esse ID"), HttpStatus.NOT_FOUND);
        }    
    }

    /**
     * @param id
     * @return mensagem de sucesso em caso de deleção ou mensagem da exceção caso contrário
     */
    @DeleteMapping("linguagens/{id}")
    public ResponseEntity<?> deleteLanguagemById(@PathVariable("id") String id) {
        try {
            service.deletarLinguagem(id);
            return new ResponseEntity<ApiMessage>(new ApiMessage("Linguagem apagada com sucesso"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("linguagens/{id}")
    public ResponseEntity<?> findLanguagemById(@PathVariable("id") String id) {
        try {
            Linguagem lingRetorno = service.findById(id);
            return new ResponseEntity<Linguagem>(lingRetorno, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}

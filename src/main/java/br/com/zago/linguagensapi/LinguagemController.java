package br.com.zago.linguagensapi;

import java.util.List;
import java.util.Optional;

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

@RestController
public class LinguagemController {
    
    @Autowired
    private LinguagemRepository repositorio;
    
    /*private List<Linguagem> linguagens = List.of(
        new Linguagem("Java", "https://raw.githubusercontent.com/abrahamcalf/programming-languages-logos/master/src/java/java_256x256.png", 1),
        new Linguagem("PHP", "https://camo.githubusercontent.com/0bfae1cd94ba02e04e473181296d77a62fcba7df0b8ee281a660c75825868676/68747470733a2f2f63646e2e6a7364656c6976722e6e65742f6e706d2f4070726f6772616d6d696e672d6c616e6775616765732d6c6f676f732f70687040302e302e302f7068705f323536783235362e706e67", 2)
    );*/

    /**
     * @return
     */
    @GetMapping("/linguagens")
    public ResponseEntity<?> obterLinguagens() {
        List<Linguagem> listRetorno = repositorio.findAll();
        if (listRetorno.equals(null)) {
            return new ResponseEntity<ApiMessage>(new ApiMessage("Não há linguagens cadastradas"), HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<List<Linguagem>>(listRetorno, HttpStatus.OK);
        }
    }

    /**
     * @param linguagem
     * @return
     */
    @PostMapping("/linguagens")
    public ResponseEntity<?> cadastrarLinguagem(@RequestBody Linguagem linguagem) {
        Linguagem language = repositorio.save(linguagem);
        return new ResponseEntity<Linguagem>(language, HttpStatus.CREATED);
    }


    /**
     * @param id
     * @param linguagem
     * @return
     */
    @PutMapping("/linguagens/{id}")
    public ResponseEntity<?> updateLinguagem(@PathVariable("id") String id, @RequestBody Linguagem linguagem) {
        Optional<Linguagem> ling = repositorio.findById(id);
        if (ling.isPresent()) {
            Linguagem lingToSave = ling.get();
            lingToSave.setImage(linguagem.getImage() != null? linguagem.getImage() : lingToSave.getImage());
            lingToSave.setRanking(linguagem.getRanking() > 0? linguagem.getRanking() : lingToSave.getRanking());
            lingToSave.setTitle(linguagem.getTitle() != null? linguagem.getTitle() : lingToSave.getTitle());
            repositorio.save(lingToSave);
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
            repositorio.deleteById(id);
            return new ResponseEntity<ApiMessage>(new ApiMessage("Linguagem apagada com sucesso"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}

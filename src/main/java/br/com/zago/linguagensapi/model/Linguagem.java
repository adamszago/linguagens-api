package br.com.zago.linguagensapi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "principaisLinguagens")
public class Linguagem {
    
    @Id
    private String id;
    private String title;
    private String image;
    private int ranking;
    private long votos;
    
    public Linguagem(){

    }
    
    public Linguagem(String title, String image) {
        this.title = title.toUpperCase();
        this.image = image;
        this.ranking = 0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }
    
    public Long getVotos() {
        return votos;
    }

    public void receberVoto() {
        this.votos += 1;
    }    
    
}

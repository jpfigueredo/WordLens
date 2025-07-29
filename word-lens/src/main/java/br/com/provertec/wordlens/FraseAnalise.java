package br.com.provertec.wordlens;

import javax.persistence.*;
import java.util.Map;

@Entity
public class FraseAnalise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String frase;

    @ElementCollection
    @CollectionTable(name = "palavra_contagem", joinColumns = @JoinColumn(name = "frase_id"))
    @MapKeyColumn(name = "palavra")
    @Column(name = "contagem")
    private Map<String, Integer> contagens;

    public FraseAnalise() {
    }

    public FraseAnalise(String frase, Map<String, Integer> contagens) {
        this.frase = frase;
        this.contagens = contagens;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrase() {
        return frase;
    }

    public void setFrase(String frase) {
        this.frase = frase;
    }

    public Map<String, Integer> getContagens() {
        return contagens;
    }

    public void setContagens(Map<String, Integer> contagens) {
        this.contagens = contagens;
    }
}
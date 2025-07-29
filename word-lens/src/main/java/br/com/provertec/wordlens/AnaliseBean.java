package br.com.provertec.wordlens;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.LinkedHashMap;
import java.util.Map;

@Named("analiseBean")
@RequestScoped
public class AnaliseBean {
    private String frase;
    private final Map<String,Integer> contagens = new LinkedHashMap<>();

    public void analisar(){
        contagens.clear();
        if(frase == null || frase.trim().isEmpty()) return;
        String[] palavras = frase.toLowerCase().split("\\W+");
        for(String p : palavras){
            contagens.put(p, contagens.containsKey(p) ? contagens.get(p)+1 : 1);
        }
    }

    public String getFrase() { return frase; }
    public void setFrase(String frase) { this.frase = frase; }
    public Map<String,Integer> getContagens() { return contagens; }
}

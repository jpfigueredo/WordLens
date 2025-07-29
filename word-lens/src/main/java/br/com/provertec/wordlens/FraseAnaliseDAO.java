package br.com.provertec.wordlens;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class FraseAnaliseDAO {
    @PersistenceContext
    private EntityManager em;

    public void salvar(FraseAnalise fa) {
        em.persist(fa);
    }
}
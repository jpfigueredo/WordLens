package br.com.provertec.wordlens;


import io.github.cdiunit.AdditionalClasses;
import io.github.cdiunit.CdiRunner;
import io.github.cdiunit.InRequestScope;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import java.util.Map;

import static org.junit.Assert.assertEquals;

@RunWith(CdiRunner.class)
@AdditionalClasses(AnaliseBean.class)
@InRequestScope
public class AnaliseBeanTest {

    @Inject
    private AnaliseBean analiseBean;

    @Test
    public void testContagemSimples() {
        analiseBean.setFrase("Hello world hello");
        analiseBean.analisar();
        Map<String,Integer> mapa = analiseBean.getContagens();
        assertEquals(2, mapa.size());
        assertEquals(Integer.valueOf(2), mapa.get("hello"));
        assertEquals(Integer.valueOf(1), mapa.get("world"));
    }
}

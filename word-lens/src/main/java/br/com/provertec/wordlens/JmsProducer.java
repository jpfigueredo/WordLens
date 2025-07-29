package br.com.provertec.wordlens;

import javax.annotation.Resource;
import javax.jms.*;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class JmsProducer {
    @Resource(lookup = "java:/jms/queue/FraseQueue")
    private Queue queue;

    @Resource(lookup = "java:/ConnectionFactory")
    private ConnectionFactory cf;

    public void enviarFrase(String frase) throws JMSException {
        try (JMSContext context = cf.createContext()) {
            context.createProducer().send(queue, frase);
        }
    }
}
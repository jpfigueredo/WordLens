package br.com.provertec.wordlens;

import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(activationConfig = {
        @javax.ejb.ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
        @javax.ejb.ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/jms/queue/FraseQueue")
})
public class FraseMDB implements MessageListener {
    @Override
    public void onMessage(Message message) {
        if (message instanceof TextMessage) {
            // processar frase recebida
        }
    }
}
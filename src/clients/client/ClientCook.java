package clients.client;

import UniversalRegistry.URegistry;
import protocol.Donnee;
import protocol.Service;
import services.data.DonneeCook;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * Created by user on 25/05/16.
 */
public class ClientCook implements MessageListener, Serializable {
    private String pseudo;

    public ClientCook(String pseudo) {
        this.pseudo = pseudo;
    }

    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        try {
            System.out.println(pseudo + " received " + textMessage.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public void startClient() {
        try {
            URegistry reg = (URegistry) Naming.lookup("rmi://localhost/registry");
            Service s = (Service) reg.get("ServiceCook");
            System.out.println(s.getInfo());
            s.suscribe(this);
            s.publish(pseudo, "Bonjour. Je vous déconseille le cuisinier François Martin. Sa cuisine était trop salée.");
            DonneeCook d = (DonneeCook) reg.get("DonneeCook");
            System.out.println(pseudo + " lit la recette: " + d);
            //s.closeConnection();
        } catch (MalformedURLException | RemoteException | NotBoundException | ClassCastException e) {
            e.printStackTrace();
        }
    }
}
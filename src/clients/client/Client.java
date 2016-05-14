package clients.client;

import UniversalRegistry.URegistry;
import protocol.Donnee;
import protocol.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client implements MessageListener, Serializable {
    private String consumerName;
    public Client(String consumerName) {
        this.consumerName = consumerName;
    }

    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        try {
            System.out.println(consumerName + " received " + textMessage.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public void startClient(){
        try {
            URegistry reg= (URegistry) Naming.lookup("rmi://localhost/registry");
            Service s= (Service)reg.get("Service");
            System.out.println(s.getInfo());
            s.iniConnection();
            s.suscribe(this);
            s.publish("Hello!!");
            Donnee d = (Donnee)reg.get("Donnee");
            System.out.println(d);
        } catch (MalformedURLException | RemoteException | NotBoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

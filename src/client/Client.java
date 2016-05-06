package client;

import UniversalRegistry.URegistry;
import data.Donnee;
import data.DonneeImpl;
import data.Service;
import data.ServiceImpl;

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
            reg.addCodebase("/home/user/IdeaProjects/UniversalRegistryExample/out/production/UniversalRegistryExample");
            Service s= new ServiceImpl();
            reg.rebind("Service", s);
            ServiceImpl s1= (ServiceImpl)reg.get("Service");
            System.out.println(s.getInfo());
            s1.iniConnection();
            s1.suscribe(this);
            s1.publish("Hello!!");
            Donnee d= new DonneeImpl("Bob", "White");
            reg.rebind("Donnee", d);
            DonneeImpl d1= (DonneeImpl)reg.get("Donnee");
            System.out.println(d1);
        } catch (MalformedURLException | RemoteException | NotBoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}

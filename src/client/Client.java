package client;

import UniversalRegistry.URegistry;
import data.Service;
import data.ServiceImpl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.security.Provider;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        try {
            URegistry reg= (URegistry) Naming.lookup("rmi://localhost/registry");
            Service s= new ServiceImpl();
            reg.rebind("Service", s);
            ServiceImpl s1= (ServiceImpl)reg.get("Service");
            s.getInfo();
            /*reg.iniConnection();
            reg.suscribe("Bob");
            reg.publish("Coucou!!");
            reg.suscribe("Marie");
            reg.publish("Hello!!");
            reg.closeConnection();*/
            /*TopicConnection connection= reg.suscribe();
            TopicSession topicSession = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
            TopicSubscriber topicSubscriber = topicSession.createSubscriber(connection);
            topicConn.start();*/
        } catch (MalformedURLException | RemoteException | NotBoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

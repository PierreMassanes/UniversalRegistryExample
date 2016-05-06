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

public class Main {
    public static void main(String[] args) {
        Client c= new Client("Client1");
        c.startClient();
    }
}

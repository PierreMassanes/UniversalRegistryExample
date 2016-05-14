package services;

import UniversalRegistry.URegistry;
import services.data.DonneeImpl;
import services.data.ServiceImpl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * Created by user on 13/05/16.
 */
public class MainService {
    public static void main(String[] args) {
        try {
            URegistry reg= (URegistry) Naming.lookup("rmi://localhost/registry");

            System.out.println("Register a service named Service");
            ServiceImpl si = new ServiceImpl();
            reg.rebind("Service", si);

            System.out.println("Register a Donnee named Bob");
            DonneeImpl di = new DonneeImpl("Bob", "White");
            reg.rebind("Donnee", di);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }
}

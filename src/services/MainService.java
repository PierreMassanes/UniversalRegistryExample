package services;

import UniversalRegistry.URegistry;
import services.data.DonneeCook;
import services.data.DonneeImpl;
import services.data.ServiceCook;
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

            System.out.println("Register a service named ServiceCook");
            ServiceCook si = new ServiceCook();
            si.iniConnection();
            reg.rebind("ServiceCook", si);

            System.out.println("Register a Donnee (recette)");
            DonneeCook di = new DonneeCook("Mélanger les oeufs, la farine et sel.");
            reg.rebind("DonneeCook", di);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }
}

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

            //On teste les méthodes sur les clés de notre RMI Registry:
            DonneeCook d2 = new DonneeCook("Mélanger la moutarde, la farine et sel.");
            reg.rebind("Recette1", d2);
            DonneeCook d3 = new DonneeCook("Mélanger la mayonaise, la farine et sel.");
            reg.rebind("Recette1", d3);
            DonneeCook d4 = new DonneeCook("Mélanger le chocolat, la farine et sel.");
            reg.rebind("Recette2", d4);
            DonneeCook d5 = new DonneeCook("Mélanger le miel, la farine et sel.");
            reg.rebind("Recette3", d5);
            DonneeCook d6 = new DonneeCook("Mélanger le miel, la farine et sucre.");
            reg.rebind("Recette3", d6);
            System.out.println(reg.getLastKeys(2)); //Recette2 et Recette3
            reg.get("Recette1");
            reg.get("Recette1");
            reg.get("Recette3");
            reg.get("Recette1");
            reg.get("Recette2");
            reg.get("Recette2");
            System.out.println(reg.getPopularKey(6).get(0));//Recette1: la plus demandée
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }
}

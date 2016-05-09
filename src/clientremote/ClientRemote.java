package clientremote;

import UniversalRegistry.URegistry;
import data.IClientRemote;
import data.ServiceClient;
import data.ServiceClientImpl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by user on 09/05/16.
 */
public class ClientRemote extends UnicastRemoteObject implements IClientRemote {
    protected ClientRemote() throws RemoteException {
    }

    @Override
    public void sayHello() throws RemoteException {
        System.out.println("Hello I'm a remote client !");
    }

    public static void main(String[] args) {
        try {
            IClientRemote client = new ClientRemote();

            URegistry reg= (URegistry) Naming.lookup("rmi://localhost/registry");
            reg.addCodebase("/home/user/IdeaProjects/UniversalRegistryExample/out/production/UniversalRegistryExample");
            ServiceClient serviceClient = new ServiceClientImpl();
            reg.rebind("serviceclient", serviceClient);
            ServiceClientImpl scimpl = (ServiceClientImpl) reg.get("serviceclient");

            scimpl.callMeBack(client);

            scimpl.accesService();


        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }
}

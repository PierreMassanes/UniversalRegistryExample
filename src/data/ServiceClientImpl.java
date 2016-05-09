package data;

import javax.jms.MessageListener;
import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by user on 09/05/16.
 */
public class ServiceClientImpl implements ServiceClient, Serializable {
    IClientRemote clientRemote;

    @Override
    public boolean callMeBack(Remote clientAccess) throws RemoteException {
        clientRemote = (IClientRemote)clientAccess;
        return true;
    }

    @Override
    public String getInfo() throws RemoteException {
        return null;
    }

    @Override
    public ReponseService accesService() throws RemoteException {
        if(clientRemote != null){
            clientRemote.sayHello();
        }
        return null;
    }

    @Override
    public void iniConnection() throws RemoteException {

    }

    @Override
    public void suscribe(MessageListener listener) throws RemoteException {

    }

    @Override
    public void closeConnection() throws RemoteException {

    }

    @Override
    public void publish(String content) throws RemoteException {

    }
}

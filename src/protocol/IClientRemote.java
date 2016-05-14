package protocol;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by user on 09/05/16.
 */
public interface IClientRemote extends Remote {
    void sayHello() throws RemoteException;
}

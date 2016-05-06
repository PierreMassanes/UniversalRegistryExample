package data;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by user on 05/05/16.
 */
public interface Donnee extends Remote {
    String toString();
}

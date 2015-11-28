package by.bsuir.firmserver.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteCommand <T> extends Remote {
    T execute(T... args) throws RemoteException;
}

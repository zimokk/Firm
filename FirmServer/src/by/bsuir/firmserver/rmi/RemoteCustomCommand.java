package by.bsuir.firmserver.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteCustomCommand extends Remote{
    public<T> Object execute(T... args) throws RemoteException;
}

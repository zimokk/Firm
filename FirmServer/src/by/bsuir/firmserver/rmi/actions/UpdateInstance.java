package by.bsuir.firmserver.rmi.actions;

import by.bsuir.firmserver.dao.GenericDao;
import by.bsuir.firmserver.rmi.RemoteCommand;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UpdateInstance<T> extends UnicastRemoteObject implements RemoteCommand <T>, Serializable {

    GenericDao MySqlClassDao;

    public UpdateInstance(GenericDao MySqlClassDao) throws RemoteException {
        this.MySqlClassDao = MySqlClassDao;
    }
    
    @Override
    public T execute(T... args) throws RemoteException {
        try {
            T temp = (T)args[0];
            if(temp != null){
                MySqlClassDao.update(temp);
                System.out.println("updated: " + temp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UpdateInstance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}

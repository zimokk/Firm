package by.bsuir.firmserver.rmi.actions;

import by.bsuir.firmserver.dao.GenericDao;
import by.bsuir.firmserver.rmi.RemoteCommand;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DeleteInstance<T> extends UnicastRemoteObject implements RemoteCommand <T>, Serializable  {

    GenericDao MySqlClassDao;

    public DeleteInstance(GenericDao MySqlClassDao) throws RemoteException {
        super();
        this.MySqlClassDao = MySqlClassDao;
    }
    
    @Override
    public T execute(T... args) throws RemoteException {
        try {
            MySqlClassDao.delete((T) args[0]);
            System.out.println("deleted: " + (T) args[0]);
        } catch (SQLException ex) {
            Logger.getLogger(DeleteInstance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}

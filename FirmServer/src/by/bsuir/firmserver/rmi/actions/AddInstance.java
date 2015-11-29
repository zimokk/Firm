package by.bsuir.firmserver.rmi.actions;

import by.bsuir.firmserver.dao.GenericDao;
import by.bsuir.firmserver.rmi.RemoteCommand;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AddInstance<T> extends UnicastRemoteObject implements RemoteCommand <T>, Serializable {

    GenericDao MySqlClassDao;

    public AddInstance(GenericDao MySqlClassDao) throws RemoteException {
        super();
        this.MySqlClassDao = MySqlClassDao;
    }
    
    @Override
    public T execute(T... args) throws RemoteException {
        try {
            T temp = (T)args[0];
            if(temp != null){
                MySqlClassDao.persist(temp);
                System.out.println("added: " + temp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AddInstance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}

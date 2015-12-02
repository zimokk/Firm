package by.bsuir.firmserver.rmi.actions;

import by.bsuir.firmserver.dao.GenericDao;
import by.bsuir.firmserver.rmi.RemoteCommand;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GetList <T> extends UnicastRemoteObject implements RemoteCommand <T>, Serializable {

    GenericDao MySqlClassDao;

    public GetList(GenericDao MySqlClassDao) throws RemoteException {
        super();
        this.MySqlClassDao = MySqlClassDao;
    }
    
    @Override
    public T execute(T... args) throws RemoteException {
        try {
            if(!MySqlClassDao.getAll().isEmpty()){
                MySqlClassDao.getAll().get(0).getClass().getCanonicalName();
            }
            System.out.println("Get all(" + MySqlClassDao.getAll().get(0).getClass().getName()
                    + ") : count-"+ MySqlClassDao.getAll().size());
            return (T) MySqlClassDao.getAll();
        } catch (SQLException ex) {
            Logger.getLogger(GetList.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}

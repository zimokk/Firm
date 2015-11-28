package by.bsuir.firmserver.rmi.actions.firmcommands;

import by.bsuir.firmserver.dao.GenericDao;
import by.bsuir.firmserver.rmi.RemoteCustomCommand;
import by.bsuir.firmserver.subjectarea.Perfomance;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GetFirmPerfomance extends UnicastRemoteObject implements RemoteCustomCommand, Serializable  {

    GenericDao MySqlClassDao;
    
    @Override
    public <T> Object execute(T... args) throws RemoteException {
        Perfomance tempPerfomance = null;
        try {
            String firmTitle = (String) args[0];
            tempPerfomance = (Perfomance) MySqlClassDao.read(firmTitle);
        } catch (SQLException | NullPointerException ex) {
            Logger.getLogger(GetFirmPerfomance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tempPerfomance;
    }

    public GetFirmPerfomance(GenericDao MySqlClassDao) throws RemoteException {
        super();
        this.MySqlClassDao = MySqlClassDao;
    }
    
}

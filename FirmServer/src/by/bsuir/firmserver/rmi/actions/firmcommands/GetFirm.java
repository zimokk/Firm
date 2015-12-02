package by.bsuir.firmserver.rmi.actions.firmcommands;

import by.bsuir.firmserver.dao.GenericDao;
import by.bsuir.firmserver.rmi.RemoteCustomCommand;
import by.bsuir.firmserver.subjectarea.classes.Firm;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GetFirm extends UnicastRemoteObject implements RemoteCustomCommand , Serializable {

    private GenericDao MySqlClassDao;
    
    public GetFirm(GenericDao MySqlClassDao) throws RemoteException {
        super();
        this.MySqlClassDao = MySqlClassDao;
    }

    @Override
    public <T> Object execute(T... args) throws RemoteException {
        try {
            String firmTitle = (String) args[0];
            List<Firm> firms = MySqlClassDao.getAll();
            for(Firm firm:firms){
                if(firm.getTitle().equals(firmTitle)){
                    return firm;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(GetFirm.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}

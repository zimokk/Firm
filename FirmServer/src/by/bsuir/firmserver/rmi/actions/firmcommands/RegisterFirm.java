package by.bsuir.firmserver.rmi.actions.firmcommands;

import by.bsuir.firmserver.dao.DaoFactory;
import by.bsuir.firmserver.dao.GenericDao;
import by.bsuir.firmserver.rmi.RemoteValidatedCommand;
import by.bsuir.firmserver.subjectarea.classes.Firm;
import by.bsuir.firmserver.subjectarea.classes.User;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RegisterFirm extends UnicastRemoteObject implements RemoteValidatedCommand, Serializable   {

    DaoFactory daoFactory;
    
    public RegisterFirm(DaoFactory daoFactory) throws RemoteException {
        super();
        this.daoFactory = daoFactory;
    }

    
    @Override
    public <T> boolean execute(T... args) throws RemoteException {
        String login = (String) args[0];
        Firm firm = (Firm) args[1];
        if(validate(firm)){
            try {
                int userId = 0;
                List<User> users = daoFactory.getUserDao(daoFactory.getConnection()).getAll();
                for(User user: users){
                    if(login.equals(user.getLogin())){
                        userId = user.getId();
                    }
                }
                firm.setUser_id(userId);
                GenericDao userDao = daoFactory.getFirmDao(daoFactory.getConnection());
                if(userDao.persist(firm)!= null)
                    return true;
            } catch (SQLException ex) {
                Logger.getLogger(RegisterFirm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    @Override
    public <T> boolean validate(T... args) throws RemoteException {
        try {
            Firm validatedFirm = (Firm) args[0];
            List<Firm> firms = daoFactory.getFirmDao(daoFactory.getConnection()).getAll();
            for(Firm firm : firms){
                if(firm.getTitle().equals(validatedFirm.getTitle())){
                    return false;
                }
            }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(RegisterFirm.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
}

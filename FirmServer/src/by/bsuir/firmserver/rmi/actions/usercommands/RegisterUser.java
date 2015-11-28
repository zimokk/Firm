package by.bsuir.firmserver.rmi.actions.usercommands;

import by.bsuir.firmserver.dao.GenericDao;
import by.bsuir.firmserver.rmi.RemoteValidatedCommand;
import by.bsuir.firmserver.subjectarea.User;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RegisterUser extends UnicastRemoteObject implements RemoteValidatedCommand, Serializable  {

    private GenericDao MySqlClassDao;
    
    public RegisterUser(GenericDao MySqlClassDao) throws RemoteException {
        super();
        this.MySqlClassDao = MySqlClassDao;
    }
    
    
    @Override
    public <T> boolean execute(T... args)  throws RemoteException {
        if(validate(args)){
            try {
                User tempUser = new User((String)args[0],(String)args[1]);
                MySqlClassDao.persist(tempUser);
            } catch (SQLException ex) {
                Logger.getLogger(RegisterUser.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("User registered: " + (T)args[0]);
        }
        else
            return false;
        return true;
    }

    @Override
    public <T> boolean validate(T... args) throws RemoteException{
        try {
            String login = (String) args[0];
            String password1 = (String) args[1];
            String password2 = (String) args[2];
            for(Object item :MySqlClassDao.getAll()){
                if(((User)item).getLogin() == null ? login == null : ((User)item).getLogin().equals(login)){
                    return false;
                }
            }
            if(!password1.equals(password2)){
                return false;
            }
            if(login.equals(password1)){
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegisterUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
}

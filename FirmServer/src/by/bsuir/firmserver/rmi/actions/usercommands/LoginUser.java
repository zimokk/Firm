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

public class LoginUser extends UnicastRemoteObject implements RemoteValidatedCommand, Serializable  {

    private GenericDao MySqlClassDao;
    
    public LoginUser(GenericDao MySqlClassDao) throws RemoteException{
        super();
        this.MySqlClassDao = MySqlClassDao;
    }

    @Override
    public <T> boolean execute(T... args) throws RemoteException {
        String login = (String) args[0];
        String password = (String) args[1];
        if(validate(args)){
            try {
                for(Object item :MySqlClassDao.getAll()){
                    if(((User)item).getLogin().equals(login) && ((User)item).getPassword().equals(password)){
                        System.out.println("User enter: " + login);
                        return true;
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(LoginUser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    @Override
    public <T> boolean validate(T... args) throws RemoteException {
        String login = (String) args[0];
        String password = (String) args[1];
        return !login.equals(" ") || !password.equals(" ");
    }
    
}

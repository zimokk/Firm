package by.bsuir.firmserver.rmi.actions.admincommands;

import by.bsuir.firmserver.dao.GenericDao;
import by.bsuir.firmserver.rmi.RemoteCustomCommand;
import by.bsuir.firmserver.subjectarea.classes.User;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DeleteUser extends UnicastRemoteObject implements RemoteCustomCommand, Serializable  {

    GenericDao MySqlClassDao;
    public DeleteUser(GenericDao MySqlClassDao) throws RemoteException {
        super();
        this.MySqlClassDao = MySqlClassDao;
    }

    @Override
    public <T> Object execute(T... args) throws RemoteException {
        try {
            String login = (String) args[0];
            List<User> users = MySqlClassDao.getAll();
            User deletedUser = null;
            for(User user: users){
                if(user.getLogin().equals(login)){
                    deletedUser = user;
                    break;
                }
            }
            MySqlClassDao.delete(deletedUser);
        } catch (SQLException ex) {
            Logger.getLogger(DeleteUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }  
}

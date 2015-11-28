package by.bsuir.firmserver.rmi.actions.firmcommands;

import by.bsuir.firmserver.dao.DaoFactory;
import by.bsuir.firmserver.rmi.RemoteCustomCommand;
import by.bsuir.firmserver.subjectarea.Firm;
import by.bsuir.firmserver.subjectarea.User;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GetUserFirms extends UnicastRemoteObject implements RemoteCustomCommand, Serializable {
    
    DaoFactory daoFactory;
    
    public GetUserFirms(DaoFactory daoFactory) throws RemoteException {
        super();
        this.daoFactory = daoFactory;
    }

    @Override
    public <T> List<Firm> execute(T... args) throws RemoteException {
        List<Firm> firms = null;
        try {
            String userLogin = (String)args[0];
            firms = daoFactory.getFirmDao(daoFactory.getConnection()).getAll();
            List<User> users = daoFactory.getUserDao(daoFactory.getConnection()).getAll();
            System.out.println("Selecting firms for user: " + userLogin);
            int userId = 0;
            for(User user:users){
                if(user.getLogin().equals(userLogin)){
                    userId = user.getId();
                    break;
                }
            }
            for(int i = firms.size()-1; i >= 0; i--){
                if(firms.get(i).getUser_id() != userId){
                    firms.remove(i);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(GetUserFirms.class.getName()).log(Level.SEVERE, null, ex);
        }
        return firms;
    }

    
    
}

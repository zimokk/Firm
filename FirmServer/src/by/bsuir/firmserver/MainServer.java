package by.bsuir.firmserver;

import by.bsuir.firmserver.dao.DaoFactory;
import by.bsuir.firmserver.dao.GenericDao;
import by.bsuir.firmserver.dao.classes.MySqlDaoFactory;
import by.bsuir.firmserver.rmi.Announcement;
import by.bsuir.firmserver.rmi.actions.AddInstance;
import by.bsuir.firmserver.rmi.actions.DeleteInstance;
import by.bsuir.firmserver.rmi.actions.GetList;
import by.bsuir.firmserver.rmi.actions.usercommands.RegisterUser;
import by.bsuir.firmserver.rmi.actions.UpdateInstance;
import by.bsuir.firmserver.rmi.actions.admincommands.DeleteUser;
import by.bsuir.firmserver.rmi.actions.firmcommands.GetFirm;
import by.bsuir.firmserver.rmi.actions.firmcommands.GetFirmPerfomance;
import by.bsuir.firmserver.rmi.actions.firmcommands.GetUserFirms;
import by.bsuir.firmserver.rmi.actions.firmcommands.RegisterFirm;
import by.bsuir.firmserver.rmi.actions.rewievcommands.GetFirmReviews;
import by.bsuir.firmserver.rmi.actions.rewievcommands.GetFirmReviewsValues;
import by.bsuir.firmserver.rmi.actions.usercommands.LoginUser;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainServer {
    
    public static void main(String[] args) {
        try {
            
            DaoFactory daoFactory = new MySqlDaoFactory();
            
            GenericDao firmDao = daoFactory.getFirmDao(daoFactory.getConnection());
            GenericDao userDao = daoFactory.getUserDao(daoFactory.getConnection());
            GenericDao reviewDao = daoFactory.getReviewDao(daoFactory.getConnection());
            GenericDao perfonamceDao = daoFactory.getPerfomanceDao(daoFactory.getConnection());
            
            Registry registry = LocateRegistry.createRegistry(Announcement.HOST_PORT);
            
            System.out.println("Server started at: "+Announcement.HOST_PORT);
            
            registry.rebind(Announcement.GET_FIRMS, new GetList<>(firmDao));
            registry.rebind(Announcement.ADD_FIRM, new AddInstance<>(firmDao));
            registry.rebind(Announcement.DELETE_FIRM, new DeleteInstance<>(firmDao));
            registry.rebind(Announcement.UPDATE_FIRM, new UpdateInstance<>(firmDao));
            
            registry.rebind(Announcement.GET_USERS, new GetList<>(userDao));
            registry.rebind(Announcement.ADD_USER, new AddInstance<>(userDao));
            registry.rebind(Announcement.DELETE_USER, new DeleteInstance<>(userDao));
            registry.rebind(Announcement.UPDATE_USER, new UpdateInstance<>(userDao));
            
            registry.rebind(Announcement.GET_REVIEWS, new GetList<>(reviewDao));
            registry.rebind(Announcement.ADD_REVIEW, new AddInstance<>(reviewDao));
            registry.rebind(Announcement.DELETE_REVIEW, new DeleteInstance<>(reviewDao));
            registry.rebind(Announcement.UPDATE_REVIEW, new UpdateInstance<>(reviewDao));
            
            registry.rebind(Announcement.GET_PERFOMANCES, new GetList<>(perfonamceDao));
            registry.rebind(Announcement.ADD_PERFOMANCE, new AddInstance<>(perfonamceDao));
            registry.rebind(Announcement.DELETE_PERFOMANCE, new DeleteInstance<>(perfonamceDao));
            registry.rebind(Announcement.UPDATE_PERFOMANCE, new UpdateInstance<>(perfonamceDao));
            
            registry.rebind(Announcement.REGISTER_USER, new RegisterUser(userDao));
            registry.rebind(Announcement.LOGIN_USER, new LoginUser(userDao));
            
            registry.rebind(Announcement.DELETE_USER_LOGIN, new DeleteUser(userDao));
            
            registry.rebind(Announcement.GET_USER_FIRM, new GetUserFirms(daoFactory));
            registry.rebind(Announcement.GET_FIRM_PERFOMANCE, new GetFirmPerfomance(perfonamceDao));
            
            registry.rebind(Announcement.REGISTER_FIRM, new RegisterFirm(daoFactory));
                        
            registry.rebind(Announcement.GET_FIRM_REVIEWS_VALUES, new GetFirmReviewsValues(daoFactory));
            registry.rebind(Announcement.GET_FIRM_REVIEWS, new GetFirmReviews(daoFactory));
            registry.rebind(Announcement.GET_FIRM, new GetFirm(firmDao));
            
        } catch (SQLException | NullPointerException | RemoteException ex) {
            Logger.getLogger(MainServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

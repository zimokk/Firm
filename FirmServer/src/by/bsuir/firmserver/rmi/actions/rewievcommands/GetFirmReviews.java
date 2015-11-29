package by.bsuir.firmserver.rmi.actions.rewievcommands;

import by.bsuir.firmserver.dao.DaoFactory;
import by.bsuir.firmserver.dao.GenericDao;
import by.bsuir.firmserver.rmi.RemoteCustomCommand;
import by.bsuir.firmserver.subjectarea.ReviewsManager;
import by.bsuir.firmserver.subjectarea.classes.Perfomance;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GetFirmReviews extends UnicastRemoteObject implements RemoteCustomCommand, Serializable   {

    DaoFactory daoFactory;
    
    public GetFirmReviews(DaoFactory daoFactory) throws RemoteException {
        super();
        this.daoFactory = daoFactory;
    }

    @Override
    public <T> Object execute(T... args) throws RemoteException {
        double[] coefs = null;
        try {
            String firmTitle = (String) args[0];
            Perfomance tempPerfomance = (Perfomance) daoFactory.getPerfomanceDao(daoFactory.getConnection()).read(firmTitle);
            GenericDao reviewDao = daoFactory.getReviewDao(daoFactory.getConnection());
            ReviewsManager reviewsManager = new ReviewsManager(reviewDao,tempPerfomance);
            coefs = reviewsManager.calculateCoefs();
        } catch (SQLException ex) {
            Logger.getLogger(GetFirmReviews.class.getName()).log(Level.SEVERE, null, ex);
        }
        return coefs;
    } 
}

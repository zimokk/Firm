package by.bsuir.firmserver.rmi.actions.rewievcommands;

import by.bsuir.firmserver.dao.DaoFactory;
import by.bsuir.firmserver.dao.GenericDao;
import by.bsuir.firmserver.rmi.RemoteCustomCommand;
import by.bsuir.firmserver.subjectarea.ReviewsManager;
import by.bsuir.firmserver.subjectarea.classes.Perfomance;
import by.bsuir.firmserver.subjectarea.classes.Review;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.List;
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
        List<Review> reviews = null;
        try {
            String firmTitle = (String) args[0];
            GenericDao reviewDao = daoFactory.getReviewDao(daoFactory.getConnection());
            reviews = reviewDao.getAll();
            for(int i = reviews.size()-1; i >= 0; i--){
                if(reviews.get(i).getFirm_title().equals(firmTitle)){
                    reviews.remove(i);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(GetFirmReviews.class.getName()).log(Level.SEVERE, null, ex);
        }
        return reviews;
    } 
}

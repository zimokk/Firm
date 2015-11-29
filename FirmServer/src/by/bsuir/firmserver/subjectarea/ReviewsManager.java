package by.bsuir.firmserver.subjectarea;

import by.bsuir.firmserver.dao.GenericDao;
import by.bsuir.firmserver.subjectarea.classes.Perfomance;
import by.bsuir.firmserver.subjectarea.classes.Review;
import by.bsuir.firmserver.subjectarea.coefcalculators.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReviewsManager {
    
    private final GenericDao mySqlClassDao;
    private final Perfomance perfomance;
    
    public ReviewsManager(GenericDao mySqlClassDao, Perfomance perfomance) {
        this.mySqlClassDao = mySqlClassDao;
        this.perfomance = perfomance;
    }
    
    public double[] calculateCoefs(){
        try {
            if(perfomance != null){
                if(mySqlClassDao.read(perfomance.getFirm_title()) != null){
                    return updateReviews();
                }
                else{
                    return generateReviews();
                }
            }
        } catch (SQLException | NullPointerException ex) {
            Logger.getLogger(ReviewsManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    private double[] updateReviews(){
        double[] coefMas = new double[10];
        coefMas[0] = updateReview(new Coef1Calculator(perfomance));
        coefMas[1] = updateReview(new Coef2Calculator(perfomance));
        coefMas[2] = updateReview(new Coef3Calculator(perfomance));
        coefMas[3] = updateReview(new Coef4Calculator(perfomance));
        coefMas[4] = updateReview(new Coef5Calculator(perfomance));
        coefMas[5] = updateReview(new Coef6Calculator(perfomance));
        coefMas[6] = updateReview(new Coef7Calculator(perfomance));
        coefMas[7] = updateReview(new Coef8Calculator(perfomance));
        return coefMas;
    }
    
    private double updateReview(GenericCalculator calculator){
        String firmTitle = perfomance.getFirm_title();
        Review review = new Review(firmTitle,calculator.getName(),calculator.calculateCoef(),
                ""+calculator.getStandart(),calculator.getReason(),calculator.getSuggestion());
        System.out.println("review updated: " + review.toString());
        try {
            mySqlClassDao.update(review);
        } catch (SQLException ex) {
            Logger.getLogger(ReviewsManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return review.getValue();
    }
    
    private double[] generateReviews(){
        double[] coefMas = new double[10];
        coefMas[0] = generateReview(new Coef1Calculator(perfomance));
        coefMas[1] = generateReview(new Coef2Calculator(perfomance));
        coefMas[2] = generateReview(new Coef3Calculator(perfomance));
        coefMas[3] = generateReview(new Coef4Calculator(perfomance));
        coefMas[4] = generateReview(new Coef5Calculator(perfomance));
        coefMas[5] = generateReview(new Coef6Calculator(perfomance));
        coefMas[6] = generateReview(new Coef7Calculator(perfomance));
        coefMas[7] = generateReview(new Coef8Calculator(perfomance));
        return coefMas;
    }
    
    private double generateReview(GenericCalculator calculator){
        String firmTitle = perfomance.getFirm_title();
        Review review = new Review(firmTitle,calculator.getName(),calculator.calculateCoef(),
                ""+calculator.getStandart(),calculator.getReason(),calculator.getSuggestion());
        saveReview(review);
        return review.getValue();
    }
    
    private void saveReview(Review review){
        try {
            System.out.println("review added: " + review.toString());
            mySqlClassDao.persist(review);
        } catch (SQLException ex) {
            Logger.getLogger(ReviewsManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

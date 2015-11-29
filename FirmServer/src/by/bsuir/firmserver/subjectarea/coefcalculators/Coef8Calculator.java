package by.bsuir.firmserver.subjectarea.coefcalculators;

import by.bsuir.firmserver.subjectarea.CoefCalculator;
import by.bsuir.firmserver.subjectarea.classes.Perfomance;

public class Coef8Calculator extends CoefCalculator{

    private final Perfomance firmPerfomance;
    
    public Coef8Calculator(Perfomance firmPerfomance) {
        super("Норма чистой прибыли", 0);
        this.firmPerfomance = firmPerfomance;
    }

    @Override
    public double calculateCoef() {
        if(firmPerfomance.getIncome() > 0 || firmPerfomance.getProfit() > 0){
            int koef100 = (int) (100*firmPerfomance.getProfit()/firmPerfomance.getIncome());
            return ((double)koef100)/100;
        }
        return 0;
    }

    @Override
    public String getReason() {
        if(firmPerfomance.getIncome() <= 0 || firmPerfomance.getProfit() <= 0){
            return "Значение коэффициента не рассчитывается";
        }
        else{
            return "";
        }
    }

    @Override
    public String getSuggestion() {
        if(firmPerfomance.getIncome() <= 0 || firmPerfomance.getProfit() <= 0){
            return "Требуется увеличить прибыль фирмы";
        }
        return "";
    }
    
}

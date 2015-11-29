package by.bsuir.firmserver.subjectarea.coefcalculators;

import by.bsuir.firmserver.subjectarea.CoefCalculator;
import by.bsuir.firmserver.subjectarea.classes.Perfomance;

public class Coef5Calculator extends CoefCalculator{
    
    private final Perfomance firmPerfomance;
    
    public Coef5Calculator(Perfomance firmPerfomance) {
        super("Коэффициент соотношения мобильных и иммобилизованных активов", 1);
        this.firmPerfomance = firmPerfomance;
    }

    @Override
    public double calculateCoef() {
        if(firmPerfomance.getFixed_assets() != 0){
            int koef100 = (int) (100*firmPerfomance.getCurrent_assets()/firmPerfomance.getFixed_assets());
            return ((double)koef100)/100;
        }
        return 0;
    }

    @Override
    public String getReason() {
        if(this.calculateCoef() == 0){
            return "Заполните показатели активов фирмы";
        }
        return "";
    }

    @Override
    public String getSuggestion() {
        return "";
    }
    
}

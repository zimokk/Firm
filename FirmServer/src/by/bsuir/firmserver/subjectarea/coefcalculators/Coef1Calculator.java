package by.bsuir.firmserver.subjectarea.coefcalculators;

import by.bsuir.firmserver.subjectarea.CoefCalculator;
import by.bsuir.firmserver.subjectarea.classes.Perfomance;

public class Coef1Calculator extends CoefCalculator{
    private final Perfomance firmPerfomance;
    
    public Coef1Calculator(Perfomance firmPerfomance) {
        super("Коэффициент автономии", 0.6);
        this.firmPerfomance = firmPerfomance;
    }
    
    @Override
    public double calculateCoef() {
        if(firmPerfomance.getAssets() != 0){
            int koef100 = (int) (firmPerfomance.getEquity()/firmPerfomance.getAssets()*100);
            return ((double)koef100)/100;
        }
        return 0;
    }

    @Override
    public String getReason() {
        if(firmPerfomance.getAssets() == 0){
            return "Заполните показатели активов компании";
        }
        else{
            double difference = this.calculateCoef() - super.getStandart();
            if(difference > 0.1 || difference < -0.1){
                return "Недостаточен объём собственного капитала";
            }
            else{
                return "Фирма обладает достаточной незавичимостью от внешнего капитала";
            }
        }
    }

    @Override
    public String getSuggestion() {
        double difference = this.calculateCoef() - super.getStandart();
        if(difference > 0.1 || difference < -0.1){
            if(calculateCoef() == 0){
                return "";
            }
            return "Требуется уменьшить зависимость фирмы от внешнего капитала путем "
                    + "увеличения собственных средств/снижения объема производства";
        }
        else{
            return "";
        }
    }
}

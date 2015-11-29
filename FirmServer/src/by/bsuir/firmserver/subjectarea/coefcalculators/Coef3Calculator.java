package by.bsuir.firmserver.subjectarea.coefcalculators;

import by.bsuir.firmserver.subjectarea.CoefCalculator;
import by.bsuir.firmserver.subjectarea.classes.Perfomance;

public class Coef3Calculator extends CoefCalculator {

    private final Perfomance firmPerfomance;
    
    public Coef3Calculator(Perfomance firmPerfomance) {
        super("Коэффициент соотношения заемных и собственных средств", 0.7);
        this.firmPerfomance = firmPerfomance;
    }
    
    @Override
    public double calculateCoef() {
        if(firmPerfomance.getOwned_assets() != 0){
            int koef100 = (int) (100*firmPerfomance.getBorrowed_capital()/firmPerfomance.getAssets());
            return ((double)koef100)/100;
        }
        else
            return 0;
    }

    @Override
    public String getReason() {
        if(this.calculateCoef() == 0){
            return "Заполните показатели активов фирмы";
        }
        else if(this.calculateCoef() > super.getStandart()){
            return "Заёмный капитал значительно превышает активы комнапии";
        }
        else{
            return "Соотношение собственного и заемного капитала оптимально";
        }
    }

    @Override
    public String getSuggestion() {
        if(calculateCoef() == 0){
            return "";
        }
        else{
            double difference = calculateCoef() - super.getStandart();
            if(difference > 0){
                return "Требуется увеличение активов компании";
            }
            else{
                return "";
            }
        }
    }
    
}

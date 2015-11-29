package by.bsuir.firmserver.subjectarea.coefcalculators;

import by.bsuir.firmserver.subjectarea.CoefCalculator;
import by.bsuir.firmserver.subjectarea.classes.Perfomance;

public class Coef4Calculator extends CoefCalculator{

    private final Perfomance firmPerfomance;
    
    public Coef4Calculator(Perfomance firmPerfomance) {
        super("Коэффициент маневренности собственных оборотных средств", 0.35);
        this.firmPerfomance = firmPerfomance;
    }
    @Override
    public double calculateCoef() {
        if(firmPerfomance.getEquity()!= 0){
            int koef100 = (int) (100*firmPerfomance.getOwned_assets()/firmPerfomance.getEquity());
            return ((double)koef100)/100;
        }
        return 0;
    }

    @Override
    public String getReason() {
        if(this.calculateCoef() != 0){
            double difference = this.calculateCoef()-super.getStandart();
            if(difference > -0.15 || difference < 0.15){
                return "Объём собственных источников финансирования недостаточен";
            }
            else{
                return "Фирма облаает достаточной манёвренностью собственных средств";
            }
        }
        return "Заполните показатели оборотных средств фирмы";
    }

    @Override
    public String getSuggestion() {
        if(this.calculateCoef() != 0){
            double difference = this.calculateCoef()-super.getStandart();
            if(difference > 0.15){
                return "Требуется сократить процент собственных средств в оборотном капитале";
            }
            else if(difference < -0.15){
                return "Требуется увеличить процент собственных средств в оборотном капитале";
            }
        }
        return "";
    }
}

package by.bsuir.firmserver.subjectarea.coefcalculators;

import by.bsuir.firmserver.subjectarea.CoefCalculator;
import by.bsuir.firmserver.subjectarea.classes.Perfomance;

public class Coef2Calculator extends CoefCalculator{
    
    private final Perfomance firmPerfomance;

    public Coef2Calculator(Perfomance firmPerfomance) {
        super("Коэффициент финансовой зависимости",0.5);
        this.firmPerfomance = firmPerfomance;
    }
    
    @Override
    public double calculateCoef() {
        if(firmPerfomance.getAssets() != 0){
            int koef100 = (int) (100*firmPerfomance.getDuties()/firmPerfomance.getAssets());
            return ((double)koef100)/100;
        }
        else{
            return 0;
        }
    }

    @Override
    public String getReason() {
        double difference = this.calculateCoef() - super.getStandart();
        if(this.calculateCoef() == 0){
            return "Заполните показатели активов фирмы";
        }
        else if(difference > -0.1){
            return "Объём обязательств фирмы слишком велик";
        }
        else{
            return "Фирма финансово независима";
        }
    }

    @Override
    public String getSuggestion() {
        double difference = this.calculateCoef() - super.getStandart();
        if(difference > -0.1){
            return "Требуется уменьшить объём задолженности фирмы";
        }
        else if(difference < 0.1){
            return "Существует возможность увеличения объёма внешнего капитала"
                    + " при сохранении мобильности фирмы";
        }
        if(calculateCoef() == 0){
            return "";
        }
        return "";
    }
    
}

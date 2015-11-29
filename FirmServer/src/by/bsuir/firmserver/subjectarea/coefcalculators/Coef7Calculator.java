package by.bsuir.firmserver.subjectarea.coefcalculators;

import by.bsuir.firmserver.subjectarea.CoefCalculator;
import by.bsuir.firmserver.subjectarea.classes.Perfomance;

public class Coef7Calculator extends CoefCalculator{

    private final Perfomance firmPerfomance;
    
    public Coef7Calculator(Perfomance firmPerfomance) {
        super("Текущая ликвидность", 2);
        this.firmPerfomance = firmPerfomance;
    }

    @Override
    public double calculateCoef() {
        if(firmPerfomance.getShort_term_duties() != 0){
            int koef100 = (int) (100*firmPerfomance.getCurrent_assets()/firmPerfomance.getShort_term_duties());
            return ((double)koef100)/100;
        }
        return 0;
    }

    @Override
    public String getReason() {
        if(firmPerfomance.getShort_term_duties() == 0){
            return "Заполните показатели краткосрочных обязательств фирмы";
        }
        else{
            double difference = this.calculateCoef() - super.getStandart();
            if(difference < -1){
                return "Фирма не в состоянии оплачивать текущие счета";
            }
            else if(difference > 1){
                return "Структура капитала фирмы нерациональна";
            }
            else{
                return "Платёжеспособность фирмы в норме";
            }
        }
    }

    @Override
    public String getSuggestion() {
        if(firmPerfomance.getShort_term_duties() == 0){
            return "";
        }
        else{
            double difference = this.calculateCoef() - super.getStandart();
            if(difference < -1){
                return "Требуется сократить объём задолженности";
            }
            else if(difference > 1){
                return "Требуется реорганизация структуры капитала фирмы";
            }
            else{
                return "";
            }
        }
    }
    
}

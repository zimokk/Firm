package by.bsuir.firmserver.subjectarea.coefcalculators;

import by.bsuir.firmserver.subjectarea.CoefCalculator;
import by.bsuir.firmserver.subjectarea.classes.Perfomance;

public class Coef6Calculator extends CoefCalculator{

    private final Perfomance firmPerfomance;
    
    public Coef6Calculator(Perfomance firmPerfomance) {
        super("Коэффициент обеспеченности оборотного капитала собственными источниками финансирования", 0.1);
        this.firmPerfomance = firmPerfomance;
    }

    @Override
    public double calculateCoef() {
        if(firmPerfomance.getCurrent_assets() != 0){
            int koef100 = (int) (100*(firmPerfomance.getEquity()-firmPerfomance.getFixed_assets())/
                        firmPerfomance.getCurrent_assets());
            return ((double)koef100)/100;
        }
        return 0;
    }

    @Override
    public String getReason() {
        if(firmPerfomance.getCurrent_assets() == 0){
            return  "Заполните данные об оборотных активах фирмы";
        }
        else if( this.calculateCoef() < 0.1){
            return "Предприятие не обеспечено собственными источниками финансирования";
        }
        else{
            return "Предприятие обеспечено собственными источниками финансирования";
        }
    }

    @Override
    public String getSuggestion() {
        if(firmPerfomance.getCurrent_assets() != 0 && this.calculateCoef() < 0.1){
            return "Требуется увеличить объём собственных источников финансирования";
        }
        return "";
    }
    
}

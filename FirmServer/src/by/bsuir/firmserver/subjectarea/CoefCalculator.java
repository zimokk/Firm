package by.bsuir.firmserver.subjectarea;

public abstract class CoefCalculator implements GenericCalculator {
    private String name;
    private double standart;
    public double getStandart(){
        return this.standart;
    }
    @Override
    public String getName(){
        return this.name;
    }
    public CoefCalculator(String name, double standart) {
        this.name = name;
        this.standart = standart;
    }
}

package by.bsuir.firmserver.subjectarea;

import java.io.Serializable;

public class Perfomance implements Serializable {
    private String firm_title;
    private double income;
    private double costs;
    private double profit;
    private double fixed_assets;
    private double current_assets;
    private double owned_assets;
    private double long_term_duties;
    private double short_term_duties;
    private double borrowed_capital;
    private double equity;

    public Perfomance(String firm_title, double income, double costs, double profit, double fixed_assets, double current_assets, double owned_assets, double long_term_duties, double short_term_duties, double borrowed_capital, double equity) {
        this.firm_title = firm_title;
        this.income = income;
        this.costs = costs;
        this.profit = profit;
        this.fixed_assets = fixed_assets;
        this.current_assets = current_assets;
        this.owned_assets = owned_assets;
        this.long_term_duties = long_term_duties;
        this.short_term_duties = short_term_duties;
        this.borrowed_capital = borrowed_capital;
        this.equity = equity;
    }

    public double getCurrent_assets() {
        return current_assets;
    }

    public void setCurrent_assets(double current_assets) {
        this.current_assets = current_assets;
    }

    public String getFirm_title() {
        return firm_title;
    }

    public void setFirm_title(String firm_title) {
        this.firm_title = firm_title;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public double getCosts() {
        return costs;
    }

    public void setCosts(double costs) {
        this.costs = costs;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public double getFixed_assets() {
        return fixed_assets;
    }

    public void setFixed_assets(double fixed_assets) {
        this.fixed_assets = fixed_assets;
    }

    public double getOwned_assets() {
        return owned_assets;
    }

    public void setOwned_assets(double owned_assets) {
        this.owned_assets = owned_assets;
    }

    public double getLong_term_duties() {
        return long_term_duties;
    }

    public void setLong_term_duties(double long_term_duties) {
        this.long_term_duties = long_term_duties;
    }

    public double getShort_term_duties() {
        return short_term_duties;
    }

    public void setShort_term_duties(double short_term_duties) {
        this.short_term_duties = short_term_duties;
    }

    public double getBorrowed_capital() {
        return borrowed_capital;
    }

    public void setBorrowed_capital(double borrowed_capital) {
        this.borrowed_capital = borrowed_capital;
    }

    public double getEquity() {
        return equity;
    }

    public void setEquity(double equity) {
        this.equity = equity;
    }

    @Override
    public String toString() {
        return "Perfomance{" + "firm_title=" + firm_title + ", income=" + income + ", costs=" + costs + ", profit=" + profit + ", fixed_assets=" + fixed_assets + ", current_assets=" + current_assets + ", owned_assets=" + owned_assets + ", long_term_duties=" + long_term_duties + ", short_term_duties=" + short_term_duties + ", borrowed_capital=" + borrowed_capital + ", equity=" + equity + '}';
    }
    
    
    
}

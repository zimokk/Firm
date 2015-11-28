package by.bsuir.firmserver.subjectarea;

import java.io.Serializable;

public class Review implements Serializable{
    private String firm_title;
    private String name;
    private double value;
    private String standart;
    private String reason;
    private String suggestion;

    public Review(String firm_title, String name, double value, String standart, String reason, String suggestion) {
        this.firm_title = firm_title;
        this.name = name;
        this.value = value;
        this.standart = standart;
        this.reason = reason;
        this.suggestion = suggestion;
    }

    public String getFirm_title() {
        return firm_title;
    }

    public void setFirm_title(String firm_title) {
        this.firm_title = firm_title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getStandart() {
        return standart;
    }

    public void setStandart(String standart) {
        this.standart = standart;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion;
    }
    
}

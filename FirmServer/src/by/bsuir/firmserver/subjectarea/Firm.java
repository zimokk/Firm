package by.bsuir.firmserver.subjectarea;

import java.io.Serializable;
import java.util.Date;

public class Firm implements Serializable{
    private String title;
    private int user_id;
    private Date registration_date;
    private String adress;
    private String structure;
    
    private String old_title;

    public Firm(String title, Date registration_date, int user_id , String adress, String structure) {
        this.title = title;
        this.user_id = user_id;
        this.registration_date = new Date();
        if(registration_date != null){
            this.registration_date = registration_date;
        }
        this.adress = adress;
        this.structure = structure;
        this.old_title = null;
    }
    
    public String getTitle() {
        return title;
    }

    public String getOld_title() {
        return old_title;
    }

    public int getUser_id() {
        return user_id;
    }

    public Date getRegistration_date() {
        return registration_date;
    }

    public String getAdress() {
        return adress;
    }

    public String getStructure() {
        return structure;
    }
    
    public void setTitle(String title) {
        if(this.title != null)
            this.old_title = this.title;
        this.title = title;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setRegistration_date(Date registration_date) {
        this.registration_date = registration_date;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    @Override
    public String toString() {
        return "Firm{" + "title=" + title + ", user_id=" + user_id + ", registration_date=" + registration_date + ", adress=" + adress + ", structure=" + structure + '}';
    }

    
}

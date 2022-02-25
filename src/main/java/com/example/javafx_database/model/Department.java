package com.example.javafx_database.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Date;

public class Department {

    private StringProperty Dname;
    private StringProperty Mgr_ssn;
    private ObjectProperty<Date> Start_date;

    public Department(String dname,
                      String mgr_ssn,
                      Date start_date){

        Dname = new SimpleStringProperty(dname);
        Mgr_ssn = new SimpleStringProperty(mgr_ssn);
        Start_date = new SimpleObjectProperty<Date>(start_date);

    }

    public String getDname() {
        return Dname.get();
    }

    public StringProperty dnameProperty() {
        return Dname;
    }

    public void setDname(String dname) {
        this.Dname.set(dname);
    }

    public String getMgr_ssn() {
        return Mgr_ssn.get();
    }

    public StringProperty mgr_ssnProperty() {
        return Mgr_ssn;
    }

    public void setMgr_ssn(String mgr_ssn) {
        this.Mgr_ssn.set(mgr_ssn);
    }

    public Date getStart_date() {
        return Start_date.get();
    }

    public ObjectProperty<Date> start_dateProperty() {
        return Start_date;
    }

    public void setStart_date(Date start_date) {
        this.Start_date.set(start_date);
    }
}

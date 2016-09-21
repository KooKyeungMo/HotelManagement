package project.model;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by java on 2016-09-21.
 */

public class rortlfWhghl {
    private SimpleStringProperty remno2;
    private SimpleStringProperty remname2;
    private SimpleStringProperty Acreage2;
    private SimpleStringProperty floor2;
    private SimpleStringProperty person2;
    private SimpleStringProperty lowson2;
    private SimpleStringProperty highson2;
    private SimpleStringProperty regdate2;

    public rortlfWhghl(String remno2, String remname2, String acreage2, String floor2, String person2, String lowson2, String highson2, String regdate2) {
        this.remno2 = new SimpleStringProperty(remno2);
        this.remname2 = new SimpleStringProperty(remname2);
        this.Acreage2 = new SimpleStringProperty(acreage2);
        this.floor2 = new SimpleStringProperty(floor2);
        this.person2 = new SimpleStringProperty(person2);
        this.lowson2 = new SimpleStringProperty(lowson2);
        this.highson2 = new SimpleStringProperty(highson2);
        this.regdate2 = new SimpleStringProperty(regdate2);
    }

    public String getRemno2() {
        return remno2.get();
    }

    public SimpleStringProperty remno2Property() {
        return remno2;
    }

    public void setRemno2(String remno2) {
        this.remno2.set(remno2);
    }

    public String getRemname2() {
        return remname2.get();
    }

    public SimpleStringProperty remname2Property() {
        return remname2;
    }

    public void setRemname2(String remname2) {
        this.remname2.set(remname2);
    }

    public String getAcreage2() {
        return Acreage2.get();
    }

    public SimpleStringProperty acreage2Property() {
        return Acreage2;
    }

    public void setAcreage2(String acreage2) {
        this.Acreage2.set(acreage2);
    }

    public String getFloor2() {
        return floor2.get();
    }

    public SimpleStringProperty floor2Property() {
        return floor2;
    }

    public void setFloor2(String floor2) {
        this.floor2.set(floor2);
    }

    public String getPerson2() {
        return person2.get();
    }

    public SimpleStringProperty person2Property() {
        return person2;
    }

    public void setPerson2(String person2) {
        this.person2.set(person2);
    }

    public String getLowson2() {
        return lowson2.get();
    }

    public SimpleStringProperty lowson2Property() {
        return lowson2;
    }

    public void setLowson2(String lowson2) {
        this.lowson2.set(lowson2);
    }

    public String getHighson2() {
        return highson2.get();
    }

    public SimpleStringProperty highson2Property() {
        return highson2;
    }

    public void setHighson2(String highson2) {
        this.highson2.set(highson2);
    }

    public String getRegdate2() {
        return regdate2.get();
    }

    public SimpleStringProperty regdate2Property() {
        return regdate2;
    }

    public void setRegdate2(String regdate2) {
        this.regdate2.set(regdate2);
    }
}

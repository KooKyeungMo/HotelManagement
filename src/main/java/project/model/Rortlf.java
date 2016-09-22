package project.model;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by java on 2016-09-21.
 */

public class Rortlf {
    private SimpleStringProperty remno1;
    private SimpleStringProperty remname1;
    private SimpleStringProperty Acreage1;
    private SimpleStringProperty floor1;
    private SimpleStringProperty person1;
    private SimpleStringProperty lowson1;
    private SimpleStringProperty highson1;
    private SimpleStringProperty regdate1;

    public Rortlf(String remno1, String remname1, String acreage1, String floor1, String person1, String lowson1, String highson1, String regdate1) {
        this.remno1 = new SimpleStringProperty(remno1);
        this.remname1 = new SimpleStringProperty(remname1);
        this.Acreage1 = new SimpleStringProperty(acreage1);
        this.floor1 = new SimpleStringProperty(floor1);
        this.person1 = new SimpleStringProperty(person1);
        this.lowson1 = new SimpleStringProperty(lowson1);
        this.highson1 = new SimpleStringProperty(highson1);
        this.regdate1 = new SimpleStringProperty(regdate1);
    }

    public String getRemno1() {
        return remno1.get();
    }

    public SimpleStringProperty remno1Property() {
        return remno1;
    }

    public void setRemno1(String remno1) {
        this.remno1.set(remno1);
    }

    public String getRemname1() {
        return remname1.get();
    }

    public SimpleStringProperty remname1Property() {
        return remname1;
    }

    public void setRemname1(String remname1) {
        this.remname1.set(remname1);
    }

    public String getAcreage1() {
        return Acreage1.get();
    }

    public SimpleStringProperty acreage1Property() {
        return Acreage1;
    }

    public void setAcreage1(String acreage1) {
        this.Acreage1.set(acreage1);
    }

    public String getFloor1() {
        return floor1.get();
    }

    public SimpleStringProperty floor1Property() {
        return floor1;
    }

    public void setFloor1(String floor1) {
        this.floor1.set(floor1);
    }

    public String getPerson1() {
        return person1.get();
    }

    public SimpleStringProperty person1Property() {
        return person1;
    }

    public void setPerson1(String person1) {
        this.person1.set(person1);
    }

    public String getLowson1() {
        return lowson1.get();
    }

    public SimpleStringProperty lowson1Property() {
        return lowson1;
    }

    public void setLowson1(String lowson1) {
        this.lowson1.set(lowson1);
    }

    public String getHighson1() {
        return highson1.get();
    }

    public SimpleStringProperty highson1Property() {
        return highson1;
    }

    public void setHighson1(String highson1) {
        this.highson1.set(highson1);
    }

    public String getRegdate1() {
        return regdate1.get();
    }

    public SimpleStringProperty regdate1Property() {
        return regdate1;
    }

    public void setRegdate1(String regdate1) {
        this.regdate1.set(regdate1);
    }
}
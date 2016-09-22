package project.model;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by java on 2016-09-21.
 */
public class dldydgusghkd {
    private SimpleStringProperty cno2;
    private SimpleStringProperty name2;
    private SimpleStringProperty resno1;
    private SimpleStringProperty room1;
    private SimpleStringProperty howPerson2;
    private SimpleStringProperty payMent2;

    public dldydgusghkd(String cno2, String name2, String resno1, String room1, String howPerson2, String payMent2) {
        this.cno2 = new SimpleStringProperty(cno2);
        this.name2 = new SimpleStringProperty(name2);
        this.resno1 = new SimpleStringProperty(resno1);
        this.room1 = new SimpleStringProperty(room1);
        this.howPerson2 = new SimpleStringProperty(howPerson2);
        this.payMent2 = new SimpleStringProperty(payMent2);
    }

    public String getCno2() {
        return cno2.get();
    }

    public SimpleStringProperty cno2Property() {
        return cno2;
    }

    public void setCno2(String cno2) {
        this.cno2.set(cno2);
    }

    public String getName2() {
        return name2.get();
    }

    public SimpleStringProperty name2Property() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2.set(name2);
    }

    public String getResno1() {
        return resno1.get();
    }

    public SimpleStringProperty resno1Property() {
        return resno1;
    }

    public void setResno1(String resno1) {
        this.resno1.set(resno1);
    }

    public String getRoom1() {
        return room1.get();
    }

    public SimpleStringProperty room1Property() {
        return room1;
    }

    public void setRoom1(String room1) {
        this.room1.set(room1);
    }

    public String getHowPerson2() {
        return howPerson2.get();
    }

    public SimpleStringProperty howPerson2Property() {
        return howPerson2;
    }

    public void setHowPerson2(String howPerson2) {
        this.howPerson2.set(howPerson2);
    }

    public String getPayMent2() {
        return payMent2.get();
    }

    public SimpleStringProperty payMent2Property() {
        return payMent2;
    }

    public void setPayMent2(String payMent2) {
        this.payMent2.set(payMent2);
    }
}

package project.Model;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by java on 2016-09-21.
 */
public class rhror {
    private SimpleStringProperty cno;
    private SimpleStringProperty name;
    private SimpleStringProperty cid;
    private SimpleStringProperty birthday;
    private SimpleStringProperty email;
    private SimpleStringProperty phoneno;
    private SimpleStringProperty regdate;


    public rhror(String cno, String name, String cid, String birthday, String email, String phoneno, String regdate) {
        this.cno = new SimpleStringProperty(cno);
        this.name = new SimpleStringProperty(name);
        this.cid = new SimpleStringProperty(cid);
        this.birthday = new SimpleStringProperty(birthday);
        this.phoneno = new SimpleStringProperty(phoneno);
        this.email = new SimpleStringProperty(email);
        this.regdate = new SimpleStringProperty(regdate);
    }

    public String getCno() {
        return cno.get();
    }

    public SimpleStringProperty cnoProperty() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno.set(cno);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getCid() {
        return cid.get();
    }

    public SimpleStringProperty cidProperty() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid.set(cid);
    }

    public String getBirthday() {
        return birthday.get();
    }

    public SimpleStringProperty birthdayProperty() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday.set(birthday);
    }

    public String getEmail() {
        return email.get();
    }

    public SimpleStringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getPhoneno() {
        return phoneno.get();
    }

    public SimpleStringProperty phonenoProperty() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno.set(phoneno);
    }

    public String getRegdate() {
        return regdate.get();
    }

    public SimpleStringProperty regdateProperty() {
        return regdate;
    }

    public void setRegdate(String regdate) {
        this.regdate.set(regdate);
    }
}
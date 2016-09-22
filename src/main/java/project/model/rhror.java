package project.model;

import javafx.beans.property.SimpleStringProperty;


/**
 * Created by java on 2016-09-20.
 * @desc TableView에 사용할 모델 클래스
 *        고객 데이터를 저장하는 클래스
 *        javafx beans 규약에 따라 작성
 *        자료형:SimpleXXXProperty
 *        생성자와 setter/getter 메서드 작성 *
 */
public class rhror {
    private SimpleStringProperty no;
    private SimpleStringProperty name;
    private SimpleStringProperty cid;
    private SimpleStringProperty birthday;
    private SimpleStringProperty email;
    private SimpleStringProperty phoneno;
    private SimpleStringProperty cregdate;


    public rhror(String cno, String cname, String cusid, String birthday, String email, String pnum, String regdate) {
        this.no = new SimpleStringProperty(cno);
        this.name = new SimpleStringProperty(cname);
        this.cid = new SimpleStringProperty(cusid);
        this.birthday = new SimpleStringProperty(birthday);
        this.phoneno = new SimpleStringProperty(pnum);
        this.email = new SimpleStringProperty(email);
        this.cregdate = new SimpleStringProperty(regdate);
    }

    public String getNo() {
        return no.get();
    }

    public SimpleStringProperty noProperty() {
        return no;
    }

    public void setNo(String no) {
        this.no.set(no);
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

    public String getCregdate() {
        return cregdate.get();
    }

    public SimpleStringProperty cregdateProperty() {
        return cregdate;
    }

    public void setCregdate(String cregdate) {
        this.cregdate.set(cregdate);
    }
}
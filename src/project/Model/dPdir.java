package project.Model;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by java on 2016-09-21.
 */
public class dPdir {
    private SimpleStringProperty resno;
    private SimpleStringProperty resname;
    private SimpleStringProperty resroom;
    private SimpleStringProperty checkIn;
    private SimpleStringProperty checkOut;
    private SimpleStringProperty payMent;
    private SimpleStringProperty damDang;

    public dPdir(String resno, String resname, String resroom, String checkIn, String checkOut, String payMent, String damDang){
        this.resno = new SimpleStringProperty(resno);
        this.resname = new SimpleStringProperty(resname);
        this.resroom = new SimpleStringProperty(resroom);
        this.checkIn = new SimpleStringProperty(checkIn);
        this.checkOut = new SimpleStringProperty(checkOut);
        this.payMent = new SimpleStringProperty(payMent);
        this.damDang = new SimpleStringProperty(damDang);
    }
    public String getResno() {
        return resno.get();
    }

    public SimpleStringProperty resnoProperty() {
        return resno;
    }

    public void setResno(String resno) {
        this.resno.set(resno);
    }

    public String getResname() {
        return resname.get();
    }

    public SimpleStringProperty resnameProperty() {
        return resname;
    }

    public void setResname(String resname) {
        this.resname.set(resname);
    }

    public String getResroom() {
        return resroom.get();
    }

    public SimpleStringProperty resroomProperty() {
        return resroom;
    }

    public void setResroom(String resroom) {
        this.resroom.set(resroom);
    }

    public String getCheckIn() {
        return checkIn.get();
    }

    public SimpleStringProperty checkInProperty() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn.set(checkIn);
    }

    public String getCheckOut() {
        return checkOut.get();
    }

    public SimpleStringProperty checkOutProperty() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut.set(checkOut);
    }

    public String getPayMent() {
        return payMent.get();
    }

    public SimpleStringProperty payMentProperty() {
        return payMent;
    }

    public void setPayMent(String payMent) {
        this.payMent.set(payMent);
    }

    public String getDamDang() {
        return damDang.get();
    }

    public SimpleStringProperty damDangProperty() {
        return damDang;
    }

    public void setDamDang(String damDang) {
        this.damDang.set(damDang);
    }
}


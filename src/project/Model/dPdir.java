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
    private SimpleStringProperty remname;
    private SimpleStringProperty remroom;
    private SimpleStringProperty person;
    private SimpleStringProperty Acreage;
    private SimpleStringProperty roomPay;
    private SimpleStringProperty damDang2;

    public dPdir(String resno, String resname, String resroom, String checkIn, String checkOut, String payMent, String damDang,
    String remname, String remroom, String person, String Acreage, String roomPay, String damDang2){
        this.resno = new SimpleStringProperty(resno);
        this.resname = new SimpleStringProperty(resname);
        this.resroom = new SimpleStringProperty(resroom);
        this.checkIn = new SimpleStringProperty(checkIn);
        this.checkOut = new SimpleStringProperty(checkOut);
        this.payMent = new SimpleStringProperty(payMent);
        this.damDang = new SimpleStringProperty(damDang);
        this.remname = new SimpleStringProperty(remname);
        this.remroom = new SimpleStringProperty(remroom);
        this.person = new SimpleStringProperty(person);
        this.Acreage = new SimpleStringProperty(Acreage);
        this.roomPay = new SimpleStringProperty(roomPay);
        this.damDang2 = new SimpleStringProperty(damDang2);
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

    public String getRemname() {
        return remname.get();
    }

    public SimpleStringProperty remnameProperty() {
        return remname;
    }

    public void setRemname(String remname) {
        this.remname.set(remname);
    }

    public String getRemroom() {
        return remroom.get();
    }

    public SimpleStringProperty remroomProperty() {
        return remroom;
    }

    public void setRemroom(String remroom) {
        this.remroom.set(remroom);
    }

    public String getPerson() {
        return person.get();
    }

    public SimpleStringProperty personProperty() {
        return person;
    }

    public void setPerson(String person) {
        this.person.set(person);
    }

    public String getAcreage() {
        return Acreage.get();
    }

    public SimpleStringProperty acreageProperty() {
        return Acreage;
    }

    public void setAcreage(String acreage) {
        this.Acreage.set(acreage);
    }

    public String getRoomPay() {
        return roomPay.get();
    }

    public SimpleStringProperty roomPayProperty() {
        return roomPay;
    }

    public void setRoomPay(String roomPay) {
        this.roomPay.set(roomPay);
    }

    public String getDamDang2() {
        return damDang2.get();
    }

    public SimpleStringProperty damDang2Property() {
        return damDang2;
    }

    public void setDamDang2(String damDang2) {
        this.damDang2.set(damDang2);
    }
}


package project.Model;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by java on 2016-09-21.
 */
public class dPdir2 {


    private SimpleStringProperty remname;
    private SimpleStringProperty remroom;
    private SimpleStringProperty person;
    private SimpleStringProperty Acreage;
    private SimpleStringProperty roomPay;
    private SimpleStringProperty damDang2;

    public dPdir2(String remname, String remroom, String person, String Acreage, String roomPay, String damDang2) {
        this.remname = new SimpleStringProperty(remname);
        this.remroom = new SimpleStringProperty(remroom);
        this.person = new SimpleStringProperty(person);
        this.Acreage = new SimpleStringProperty(Acreage);
        this.roomPay = new SimpleStringProperty(roomPay);
        this.damDang2 = new SimpleStringProperty(damDang2);
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

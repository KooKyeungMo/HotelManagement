package project.model;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by java on 2016-09-21.
 */
public class akdlfflwl {
    private SimpleStringProperty con1;
    private SimpleStringProperty name1;
    private SimpleStringProperty level;
    private SimpleStringProperty mileage;
    private SimpleStringProperty available;
    private SimpleStringProperty expire;
    private SimpleStringProperty expiredate;

    public akdlfflwl(String con1, String name1, String level, String mileage, String available, String expire, String expiredate) {
        this.con1 = new SimpleStringProperty(con1);
        this.name1 = new SimpleStringProperty(name1);
        this.level = new SimpleStringProperty(level);
        this.mileage = new SimpleStringProperty(mileage);
        this.available = new SimpleStringProperty(available);
        this.expire = new SimpleStringProperty(expire);
        this.expiredate = new SimpleStringProperty(expiredate);
    }

    public String getCon1() {
        return con1.get();
    }

    public SimpleStringProperty con1Property() {
        return con1;
    }

    public void setCon1(String con1) {
        this.con1.set(con1);
    }

    public String getName1() {
        return name1.get();
    }

    public SimpleStringProperty name1Property() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1.set(name1);
    }

    public String getLevel() {
        return level.get();
    }

    public SimpleStringProperty levelProperty() {
        return level;
    }

    public void setLevel(String level) {
        this.level.set(level);
    }

    public String getMileage() {
        return mileage.get();
    }

    public SimpleStringProperty mileageProperty() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage.set(mileage);
    }

    public String getAvailable() {
        return available.get();
    }

    public SimpleStringProperty availableProperty() {
        return available;
    }

    public void setAvailable(String available) {
        this.available.set(available);
    }

    public String getExpire() {
        return expire.get();
    }

    public SimpleStringProperty expireProperty() {
        return expire;
    }

    public void setExpire(String expire) {
        this.expire.set(expire);
    }

    public String getExpiredate() {
        return expiredate.get();
    }

    public SimpleStringProperty expiredateProperty() {
        return expiredate;
    }

    public void setExpiredate(String expiredate) {
        this.expiredate.set(expiredate);
    }
}

package project.model;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by java on 2016-09-21.
 */
public class rptlvks {
    private SimpleStringProperty bdno;
    private SimpleStringProperty bdtitle;
    private SimpleStringProperty bdname;
    private SimpleStringProperty bddate;
    private SimpleStringProperty bdread;

    public rptlvks(String bdno, String bdtitle, String bdname, String bddate, String bdread){
        this.bdno = new SimpleStringProperty(bdno);
        this.bdtitle = new SimpleStringProperty(bdtitle);
        this.bdname = new SimpleStringProperty(bdname);
        this.bddate = new SimpleStringProperty(bddate);
        this.bdread = new SimpleStringProperty(bdread);
    }

    public String getBdno() {
        return bdno.get();
    }

    public SimpleStringProperty bdnoProperty() {
        return bdno;
    }

    public void setBdno(String bdno) {
        this.bdno.set(bdno);
    }

    public String getBdtitle() {
        return bdtitle.get();
    }

    public SimpleStringProperty bdtitleProperty() {
        return bdtitle;
    }

    public void setBdtitle(String bdtitle) {
        this.bdtitle.set(bdtitle);
    }

    public String getBdname() {
        return bdname.get();
    }

    public SimpleStringProperty bdnameProperty() {
        return bdname;
    }

    public void setBdname(String bdname) {
        this.bdname.set(bdname);
    }

    public String getBddate() {
        return bddate.get();
    }

    public SimpleStringProperty bddateProperty() {
        return bddate;
    }

    public void setBddate(String bddate) {
        this.bddate.set(bddate);
    }

    public String getBdread() {
        return bdread.get();
    }

    public SimpleStringProperty bdreadProperty() {
        return bdread;
    }

    public void setBdread(String bdread) {
        this.bdread.set(bdread);
    }
}

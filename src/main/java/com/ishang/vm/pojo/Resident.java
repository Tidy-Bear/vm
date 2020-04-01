package com.ishang.vm.pojo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "resident")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class Resident {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    String name;
    String uname;
    String naplace;
    String birplace;
    String edudegree;
    String address1;
    String emplace;
    Date whenincity;
    String whereincity;
    Date whenin;
    String wherein;
    String occupation;
    String arstatus;
    String marstatus;
    String height;
    String religion;
    Date birthdate;
    String natived;
    String sex;
    String reholder;
    String photo;
    String idnum;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getNaplace() {
        return naplace;
    }

    public void setNaplace(String naplace) {
        this.naplace = naplace;
    }

    public String getBirplace() {
        return birplace;
    }

    public void setBirplace(String birplace) {
        this.birplace = birplace;
    }

    public String getEdudegree() {
        return edudegree;
    }

    public void setEdudegree(String edudegree) {
        this.edudegree = edudegree;
    }

    public String getEmplace() {
        return emplace;
    }

    public void setEmplace(String emplace) {
        this.emplace = emplace;
    }

    public Date getWhenincity() {
        return whenincity;
    }

    public void setWhenincity(Date whenincity) {
        this.whenincity = whenincity;
    }

    public Date getWhenin() {
        return whenin;
    }

    public void setWhenin(Date whenin) {
        this.whenin = whenin;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getWhereincity() {
        return whereincity;
    }

    public void setWhereincity(String whereincity) {
        this.whereincity = whereincity;
    }

    public String getWherein() {
        return wherein;
    }

    public void setWherein(String wherein) {
        this.wherein = wherein;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getArstatus() {
        return arstatus;
    }

    public void setArstatus(String arstatus) {
        this.arstatus = arstatus;
    }

    public String getMarstatus() {
        return marstatus;
    }

    public void setMarstatus(String marstatus) {
        this.marstatus = marstatus;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getNatived() {
        return natived;
    }

    public void setNatived(String natived) {
        this.natived = natived;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getReholder() {
        return reholder;
    }

    public void setReholder(String reholder) {
        this.reholder = reholder;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getIdnum() {
        return idnum;
    }

    public void setIdnum(String idnum) {
        this.idnum = idnum;
    }
    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

}

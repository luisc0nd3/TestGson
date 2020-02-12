package org.acme.rest.json.dto;

import java.util.Date;

public class CustomerDTO {
    private String uuid;
    private String name;
    private String lname;
    private String slname;
    private String email;
    private String phone;
    private Date bdate;
    private String gender;

    public CustomerDTO(String uuid, String name, String lname, String slname, String email, String phone, Date bdate,
                       String gender) {
        this.uuid = uuid;
        this.name = name;
        this.lname = lname;
        this.slname = slname;
        this.email = email;
        this.phone = phone;
        this.bdate = bdate;
        this.gender = gender;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getSlname() {
        return slname;
    }

    public void setSlname(String slname) {
        this.slname = slname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBdate() {
        return bdate;
    }

    public void setBdate(Date bdate) {
        this.bdate = bdate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" + "\n" +
                "  uuid='" + uuid + '\'' + "\n" +
                ", name='" + name + '\'' + "\n" +
                ", lname='" + lname + '\'' + "\n" +
                ", slname='" + slname + '\'' + "\n" +
                ", email='" + email + '\'' + "\n" +
                ", phone='" + phone + '\'' + "\n" +
                ", bdate=" + bdate + "\n" +
                ", gender='" + gender + '\'' + "\n" +
                '}';
    }
}

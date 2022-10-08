package org.olaoye.com.domian;

import org.olaoye.com.domian.enums.GENDER;

public abstract class User {
    private String name;
    private GENDER gender;
    private String phoneNumber;
    private String address;
    public User(String name, GENDER gender, String phoneNumber, String address){
        this.address=address;
        this.name=name;
        this.gender=gender;
        this.phoneNumber=phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GENDER getGender() {
        return gender;
    }

    public void setGender(GENDER gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

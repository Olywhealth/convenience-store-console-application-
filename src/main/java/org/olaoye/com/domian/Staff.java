package org.olaoye.com.domian;

import org.olaoye.com.domian.enums.GENDER;
import org.olaoye.com.domian.enums.POSITION;

public class Staff extends User{
    private int id;
    private POSITION position;
    private int officeNumber;
    private int deskNumber;

    //creating constructor for manager
    public Staff(String name, GENDER gender, String phoneNumber, String address, int id, int officeNumber, POSITION position){
        super(name,gender,phoneNumber,address);
        this.id = id;
        this.officeNumber = officeNumber;
        this.position = position;
    }
    //creating constructor for cashier
    public Staff(String name, GENDER gender, String phoneNumber, String address, int id,POSITION position, int deskNumber){
        super(name,gender,phoneNumber,address);
        this.position = position;
        this.id = id;
        this.deskNumber = deskNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public POSITION getPosition() {
        return position;
    }

    public void setPosition(POSITION position) {
        this.position = position;
    }

    public int getOfficeNumber() {
        return officeNumber;
    }

    public void setOfficeNumber(int officeNumber) {
        this.officeNumber = officeNumber;
    }

    public int getDeskNumber() {
        return deskNumber;
    }

    public void setDeskNumber(int deskNumber) {
        this.deskNumber = deskNumber;
    }
}

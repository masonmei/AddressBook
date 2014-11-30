package org.personal.mason.addressbook.app.model;

import java.io.Serializable;

public class Address implements Serializable {
    private String streetAndNumber;
    private String zipCode;
    private String city;

    public Address(String streetAndNumber, String zipCode, String city) {
        this.streetAndNumber = streetAndNumber;
        this.zipCode = zipCode;
        this.city = city;
    }

    public String getStreetAndNumber() {
        return streetAndNumber;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCity() {
        return city;
    }
}
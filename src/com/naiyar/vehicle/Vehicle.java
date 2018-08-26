package com.naiyar.vehicle;

/**
 * Created by vikasnaiyar on 16/08/18.
 */
public class Vehicle {

    private String registrationNumber;

    private Color color;

    private Manufacturer manufacturer;


    public Vehicle(String registrationNumber, Color color, Manufacturer manufacturer) {
        this.color = color;
        this.registrationNumber = registrationNumber;
        this.manufacturer = manufacturer;
    }


    public String getRegistrationNumber() {
        return registrationNumber;
    }

    /*@Override
    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        }

        if(obj instanceof  Vehicle) {

            Vehicle that = (Vehicle) obj;

            return  (this.registrationNumber == that.registrationNumber);
                   // && (this.color = that.color ) && this.manufacturer == that.manufacturer;
        }


        return false;
    }*/


}

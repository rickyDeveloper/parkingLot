package com.naiyar.parkingslot;

/**
 * Created by vikasnaiyar on 16/08/18.
 */
public class MyPayParkingSlot implements ParkingSlot {

    private  int floorNumber;

    private  int slotNumber;

    public MyPayParkingSlot(int floorNumber, int slotNumber) {
        this.floorNumber = floorNumber;
        this.slotNumber = slotNumber;
    }

    @Override
    public int getFloorNumber() {
        return floorNumber;
    }

    @Override
    public int getSlotNumbber() {
        return slotNumber;
    }

    @Override
    public boolean equals(Object object) {

        if(object == null) {
            return  false;
        }

        MyPayParkingSlot that = null;
        if(object instanceof MyPayParkingSlot) {
            that = (MyPayParkingSlot) object;
        } else {
            return  false;
        }

        return this.floorNumber == that.floorNumber && this.slotNumber == that.slotNumber;
    }

    @Override
    public int hashCode() {
        int primeMultiplier = 31;
        return ((primeMultiplier * this.floorNumber)%71) * this.slotNumber;
    }
}

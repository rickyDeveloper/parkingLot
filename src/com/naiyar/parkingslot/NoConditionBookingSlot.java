package com.naiyar.parkingslot;

/**
 * Created by vikasnaiyar on 26/08/18.
 */
public class NoConditionBookingSlot extends BookingSlot {

    @Override
    public boolean equals(Object object) {
        if(object == null) {
            return false;
        }

        if(object instanceof NoConditionBookingSlot) {
            return true;
        }

        return  false;
    }

    @Override
    public int hashCode() {
        return 31;
    }
}

package com.naiyar.parking.mgr;

import com.naiyar.parkingslot.BookingSlot;
import com.naiyar.parkingslot.ParkingSlot;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by vikasnaiyar on 27/08/18.
 */
public abstract class BookingMgr {

    protected Map<Integer, Map<ParkingSlot, Set<BookingSlot>>> parkingSlotByFloor;

    protected BookingMgr() {
        parkingSlotByFloor = new HashMap<>();
    }

    public abstract ParkingSlot getParkingSlot(BookingSlot bookingSlot);

    public boolean addParkingSlot(ParkingSlot parkingSlot, BookingSlot bookingSlot) {
        if(parkingSlot == null) {
            return  false;
        }

        if(parkingSlotByFloor.containsKey(parkingSlot.getFloorNumber())) {

            Map<ParkingSlot, Set<BookingSlot>> slots = parkingSlotByFloor.get(parkingSlot.getFloorNumber());

            if(slots.containsKey(parkingSlot)) {
                slots.get(parkingSlot).add(bookingSlot);
            } else {
                Set<BookingSlot> bookingSlots = new HashSet<>();
                bookingSlots.add(bookingSlot);
                slots.put(parkingSlot,bookingSlots);
            }

        } else {

            Map<ParkingSlot, Set<BookingSlot>> slots = new HashMap<>();
            Set<BookingSlot> bookingSlots = new HashSet<>();
            bookingSlots.add(bookingSlot);
            slots.put(parkingSlot, bookingSlots);

            parkingSlotByFloor.put(parkingSlot.getFloorNumber(), slots);
        }

        return true;
    }
}

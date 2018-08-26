package com.naiyar.parking.mgr;

import com.naiyar.Main;
import com.naiyar.parkingslot.BookingSlot;
import com.naiyar.parkingslot.ParkingSlot;

import java.util.*;

/**
 * Created by vikasnaiyar on 16/08/18.
 */
public class RoundRobinParkingMgr extends BookingMgr {

    protected Integer nextFloor = 0;

    public RoundRobinParkingMgr() {
    }

    @Override
    public ParkingSlot getParkingSlot(BookingSlot bookingSlot) {

        Map<ParkingSlot, Set<BookingSlot>> slots = parkingSlotByFloor.get(nextFloor);

        Iterator<ParkingSlot> it = slots.keySet().iterator();

        ParkingSlot slot = null;

        while (it.hasNext()) {
            ParkingSlot temp = it.next();
            slot = temp;
            break;
        }

        // Remove from slots list
        if(slot != null) {
            slots.remove(slot);
        }

        nextFloor = ++nextFloor % parkingSlotByFloor.keySet().size();

        return slot;
    }

}

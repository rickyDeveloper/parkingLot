package com.naiyar.parking.mgr;

import com.naiyar.parkingslot.BookingSlot;
import com.naiyar.parkingslot.ParkingSlot;
import com.naiyar.parkingslot.TimeBasedBookingSlot;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by vikasnaiyar on 26/08/18.
 */
public class TimeBasedRoundRobinParkingMgr extends RoundRobinParkingMgr {

    @Override
    public ParkingSlot getParkingSlot(BookingSlot bookingSlot) {

        ParkingSlot slot = null;

        int totalFloors = parkingSlotByFloor.keySet().size();

        int totalAttempts = 0;

        while(totalAttempts <= totalFloors && slot == null) {

            ++totalAttempts;

            Map<ParkingSlot, Set<BookingSlot>> slots = parkingSlotByFloor.get(nextFloor);

            Iterator<Map.Entry<ParkingSlot, Set<BookingSlot>>> it = slots.entrySet().iterator();

            while (it.hasNext()) {
                Map.Entry<ParkingSlot, Set<BookingSlot>> entry = it.next();
                Iterator<BookingSlot> bookingSlotsIterator = entry.getValue().iterator();

                boolean foundSuitableSlot = true;

                while (bookingSlotsIterator.hasNext()) {
                    BookingSlot alredyTakenBookingSlot = bookingSlotsIterator.next();
                    if(alredyTakenBookingSlot instanceof TimeBasedBookingSlot) {
                        TimeBasedBookingSlot timeBasedBookingSlot = (TimeBasedBookingSlot) alredyTakenBookingSlot;
                        foundSuitableSlot = timeBasedBookingSlot.areExclusive((TimeBasedBookingSlot)bookingSlot);
                    }
                }

                if(foundSuitableSlot) {
                    entry.getValue().add(bookingSlot);
                    slot = entry.getKey();
                    break;
                }
            }

            nextFloor = ++nextFloor % parkingSlotByFloor.keySet().size();
        }

        return slot;

    }
}

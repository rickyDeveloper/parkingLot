package com.naiyar;

import com.naiyar.parkingslot.BookingSlot;
import com.naiyar.parkingslot.ParkingSlot;
import com.naiyar.vehicle.Vehicle;

/**
 * Created by vikasnaiyar on 16/08/18.
 */
public interface ParkingSystem {

    ParkingSlot parkVehicle(Vehicle vehicle, BookingSlot bookingSlot);

    ParkingSlot unparkVehicle(Vehicle vehicle, BookingSlot bookingSlot);

    ParkingSlot searchVehicle(String registrationNumber);

}

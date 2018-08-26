package com.naiyar.parking.search;

import com.naiyar.parkingslot.ParkingSlot;

/**
 * Created by vikasnaiyar on 16/08/18.
 */
public interface SearchService {

    ParkingSlot searchVehicle(String registrationNumber);

    ParkingSlot addVehicle(String registrationNumber, ParkingSlot parkingSlot);

    boolean removeVehicle(String registrationNumber);

}

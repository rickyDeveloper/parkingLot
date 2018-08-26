package com.naiyar.parking.search;

import com.naiyar.parkingslot.ParkingSlot;

import java.util.Map;

/**
 * Created by vikasnaiyar on 16/08/18.
 */
public class ParkingSearchService implements SearchService{

    private Map<String, ParkingSlot> parkingSlotCache;

    public ParkingSearchService(Map<String, ParkingSlot> parkingSlotCache) {
        this.parkingSlotCache = parkingSlotCache;
    }

    @Override
    public ParkingSlot searchVehicle(String registrationNumber) {
        return parkingSlotCache.get(registrationNumber);
    }

    @Override
    public ParkingSlot addVehicle(String registrationNumber, ParkingSlot parkingSlot) {
        parkingSlotCache.put(registrationNumber, parkingSlot);
        return parkingSlot;
    }

    @Override
    public boolean removeVehicle(String registrationNumber) {
        parkingSlotCache.remove(registrationNumber);
        return true;
    }

}

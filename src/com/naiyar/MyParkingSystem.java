package com.naiyar;


import com.naiyar.parking.mgr.BookingMgr;
import com.naiyar.parkingslot.BookingSlot;
import com.naiyar.parkingslot.ParkingSlot;
import com.naiyar.parking.search.SearchService;
import com.naiyar.vehicle.Vehicle;

/**
 * Created by vikasnaiyar on 16/08/18.
 */
public class MyParkingSystem implements ParkingSystem {

    private SearchService searchService;

    private BookingMgr parkingBookingMgr;

    public MyParkingSystem(BookingMgr parkingBookingMgr, SearchService searchService) {
       this.parkingBookingMgr = parkingBookingMgr;
       this.searchService = searchService;
    }

    @Override
    public ParkingSlot parkVehicle(Vehicle vehicle, BookingSlot bookingSlot) {
        ParkingSlot parkingSlot = parkingBookingMgr.getParkingSlot(bookingSlot);

        if(parkingSlot != null) {
            System.out.println("Parking slot available");
            searchService.addVehicle(vehicle.getRegistrationNumber(), parkingSlot);
        } else {
            System.out.println("Parking slot not available");
        }

        return parkingSlot;
    }

    @Override
    public ParkingSlot unparkVehicle(Vehicle vehicle, BookingSlot bookingSlot) {
        ParkingSlot parkingSlot = searchService.searchVehicle(vehicle.getRegistrationNumber());

        if(parkingSlot != null) {
            searchService.removeVehicle(vehicle.getRegistrationNumber());
            parkingBookingMgr.addParkingSlot(parkingSlot,bookingSlot);
        }

        return parkingSlot;
    }

    @Override
    public ParkingSlot searchVehicle(String registrationNumber) {
        return searchService.searchVehicle(registrationNumber);
    }

}

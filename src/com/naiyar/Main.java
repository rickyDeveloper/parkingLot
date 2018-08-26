package com.naiyar;

import com.naiyar.parking.mgr.BookingMgr;
import com.naiyar.parking.mgr.RoundRobinParkingMgr;
import com.naiyar.parking.mgr.TimeBasedRoundRobinParkingMgr;
import com.naiyar.parking.search.ParkingSearchService;
import com.naiyar.parking.search.SearchService;
import com.naiyar.parkingslot.NoConditionBookingSlot;
import com.naiyar.parkingslot.MyPayParkingSlot;
import com.naiyar.parkingslot.ParkingSlot;
import com.naiyar.parkingslot.TimeBasedBookingSlot;
import com.naiyar.vehicle.Color;
import com.naiyar.vehicle.Manufacturer;
import com.naiyar.vehicle.Vehicle;

import java.util.*;

/**
 * Created by vikasnaiyar on 16/08/18.
 */
public class Main {

    public static void main(String[] args) {

        // Create sample Vehicles
        Vehicle vehicle1 = new Vehicle("A", Color.BLACK, Manufacturer.AUDI);
        Vehicle vehicle2 = new Vehicle("B", Color.BLUE, Manufacturer.MARUTI);
        Vehicle vehicle3 = new Vehicle("C", Color.RED, Manufacturer.BMW);
        Vehicle vehicle4 = new Vehicle("D", Color.BLUE, Manufacturer.MARUTI);
        Vehicle vehicle5 = new Vehicle("E", Color.RED, Manufacturer.BMW);

        BookingMgr parkingBookingMgr = new RoundRobinParkingMgr();
        parkingBookingMgr.addParkingSlot(new MyPayParkingSlot(0, 1), new NoConditionBookingSlot());
        parkingBookingMgr.addParkingSlot(new MyPayParkingSlot(0, 2), new NoConditionBookingSlot());
        parkingBookingMgr.addParkingSlot(new MyPayParkingSlot(1, 1), new NoConditionBookingSlot());
        parkingBookingMgr.addParkingSlot(new MyPayParkingSlot(1, 2), new NoConditionBookingSlot());

        SearchService searchService = new ParkingSearchService(new HashMap<String, ParkingSlot>());

        ParkingSystem parkingSystem = new MyParkingSystem(parkingBookingMgr, searchService);

        // Below logic is to test a simple round robin based parking system
        ParkingSlot slot = parkingSystem.parkVehicle(vehicle1, new NoConditionBookingSlot());
        System.out.println("Vehicle parked at floor " + slot.getFloorNumber() + " slot " + slot.getSlotNumbber());

        slot = parkingSystem.parkVehicle(vehicle2, new NoConditionBookingSlot());
        if(slot != null) {
            System.out.println("Vehicle parked at floor " + slot.getFloorNumber() + " slot " + slot.getSlotNumbber());
        }

        slot = parkingSystem.parkVehicle(vehicle3, new NoConditionBookingSlot());
        if(slot != null) {
            System.out.println("Vehicle parked at floor " + slot.getFloorNumber() + " slot " + slot.getSlotNumbber());
        }

        slot = parkingSystem.parkVehicle(vehicle4, new NoConditionBookingSlot());
        if(slot != null) {
            System.out.println("Vehicle parked at floor " + slot.getFloorNumber() + " slot " + slot.getSlotNumbber());
        }

        slot = parkingSystem.parkVehicle(vehicle5, new NoConditionBookingSlot());
        if(slot != null) {
            System.out.println("Vehicle parked at floor " + slot.getFloorNumber() + " slot " + slot.getSlotNumbber());
        }

        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, 1);

        Date start1 = c.getTime();
        c.add(Calendar.DATE, 2);
        Date end1 = c.getTime();

        Date start2 = c.getTime();
        c.add(Calendar.DATE, 2);
        Date end2 = c.getTime();

        Date start3 = c.getTime();
        c.add(Calendar.DATE, 2);
        Date end3 = c.getTime();

        Date start4 = c.getTime();
        c.add(Calendar.DATE, 2);
        Date end4 = c.getTime();

        parkingBookingMgr = new TimeBasedRoundRobinParkingMgr();
        parkingBookingMgr.addParkingSlot(new MyPayParkingSlot(0, 1), new NoConditionBookingSlot());
        parkingBookingMgr.addParkingSlot(new MyPayParkingSlot(0, 2), new NoConditionBookingSlot());
        parkingBookingMgr.addParkingSlot(new MyPayParkingSlot(1, 1), new NoConditionBookingSlot());
        parkingBookingMgr.addParkingSlot(new MyPayParkingSlot(1, 2), new NoConditionBookingSlot());

        searchService = new ParkingSearchService(new HashMap<String, ParkingSlot>());

        parkingSystem = new MyParkingSystem(parkingBookingMgr, searchService);

        // Below logic is to test a simple round robin based parking system
        slot = parkingSystem.parkVehicle(vehicle1, new TimeBasedBookingSlot(start1, end1));
        if(slot != null) {
            System.out.println("Vehicle parked at floor " + slot.getFloorNumber() + " slot " + slot.getSlotNumbber());
        }


        slot = parkingSystem.parkVehicle(vehicle2, new TimeBasedBookingSlot(start2, end2));
        if(slot != null) {
            System.out.println("Vehicle parked at floor " + slot.getFloorNumber() + " slot " + slot.getSlotNumbber());
        }

        slot = parkingSystem.parkVehicle(vehicle3, new TimeBasedBookingSlot(start1, end1));
        if(slot != null) {
            System.out.println("Vehicle parked at floor " + slot.getFloorNumber() + " slot " + slot.getSlotNumbber());
        }

        slot = parkingSystem.parkVehicle(vehicle4, new TimeBasedBookingSlot(start2, end2));
        if(slot != null) {
            System.out.println("Vehicle parked at floor " + slot.getFloorNumber() + " slot " + slot.getSlotNumbber());
        }


        slot = parkingSystem.parkVehicle(vehicle5, new TimeBasedBookingSlot(start2, end2));
        if(slot != null) {
            System.out.println("Vehicle parked at floor " + slot.getFloorNumber() + " slot " + slot.getSlotNumbber());
        }
    }

}

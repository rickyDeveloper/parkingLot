package com.naiyar.parkingslot;

import java.util.Date;

/**
 * Created by vikasnaiyar on 26/08/18.
 */
public class TimeBasedBookingSlot extends BookingSlot{
    private Date startDate;

    private Date endDate;

    public TimeBasedBookingSlot(Date startDate, Date endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Date getStartDate(){
        return startDate;
    }


    public Date getEndDate(){
        return endDate;
    }


    @Override
    public boolean equals(Object object) {
        if(object == null) {
            return false;
        }

        if(object instanceof TimeBasedBookingSlot) {
            TimeBasedBookingSlot that = (TimeBasedBookingSlot) object;
            return this.startDate.equals(that.startDate) && this.endDate.equals(that.endDate);
        }

        return  false;
    }

    @Override
    public int hashCode() {
        return (31 * this.startDate.hashCode() + 71 * this.endDate.hashCode()) ;
    }

    public boolean areExclusive(TimeBasedBookingSlot timeBasedBookingSlot) {
        return this.startDate.after(timeBasedBookingSlot.endDate) || this.endDate.before(timeBasedBookingSlot.startDate);
    }

}


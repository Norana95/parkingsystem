package com.parkit.parkingsystem.service;

import com.parkit.parkingsystem.constants.Fare;
import com.parkit.parkingsystem.model.Ticket;

public class FareCalculatorService {

    public void calculateFare(Ticket ticket) {
        if ((ticket.getOutTime() == null) || (ticket.getOutTime().before(ticket.getInTime()))) {
            throw new IllegalArgumentException("Out time provided is incorrect:" + ticket.getOutTime().toString());
        }

        double inHour = ticket.getInTime().getTime();
        double outHour = ticket.getOutTime().getTime();
        final int oneHourInMilliseconds = 3600000;


        //TODO: Some tests are failing here. Need to check if this logic is correct
        double duration = (outHour - inHour) / oneHourInMilliseconds; // the duration in hours

        if (duration <= 0.5) {
            /* duration = (outHour-inHour)/3600000
                        = 30minutes/3600000
                        = 1800000 milliseconds/3600000 = 0.5     */
            ticket.setPrice(0);
        } else if (ticket.isRecurrent() && duration > 0.5) {

            switch (ticket.getParkingSpot().getParkingType()) {
                case CAR: {
                    ticket.setPrice(duration * (Fare.CAR_RATE_PER_HOUR) - (duration * (Fare.CAR_RATE_PER_HOUR) * 0.05));
                    break;
                }
                case BIKE: {
                    ticket.setPrice(duration * (Fare.BIKE_RATE_PER_HOUR) - (duration * (Fare.BIKE_RATE_PER_HOUR) * 0.05));
                    break;
                }
                default:
                    throw new IllegalArgumentException("Unknown Parking Type");
            }

        } else {
            switch (ticket.getParkingSpot().getParkingType()) {
                case CAR: {
                    ticket.setPrice(duration * Fare.CAR_RATE_PER_HOUR);
                    break;
                }
                case BIKE: {
                    ticket.setPrice(duration * Fare.BIKE_RATE_PER_HOUR);
                    break;
                }
                default:
                    throw new IllegalArgumentException("Unknown Parking Type");
            }
        }
    }
}
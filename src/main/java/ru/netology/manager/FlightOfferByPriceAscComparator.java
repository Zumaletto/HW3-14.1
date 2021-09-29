package ru.netology.manager;

import ru.netology.domain.FlightOffer;

import java.util.Comparator;

public class FlightOfferByPriceAscComparator implements Comparator<FlightOffer> {
    public int compare(FlightOffer o1, FlightOffer o2) {
        return o1.getFlightTime() - o2.getFlightTime();
    }
}

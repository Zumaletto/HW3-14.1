package ru.netology.domain;

public class FlightOffer implements Comparable<FlightOffer> {
    private int id;
    private int price;
    private String fromIATA;
    private String toIATA;
    private int flightTime;

    public FlightOffer(int id, int price, String fromIATA, String toIATA, int flightTime) {
        this.id = id;
        this.price = price;
        this.fromIATA = fromIATA;
        this.toIATA = toIATA;
        this.flightTime = flightTime;
    }

    public FlightOffer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getFromIATA() {
        return fromIATA;
    }

    public void setFromIATA(String fromIATA) {
        this.fromIATA = fromIATA;
    }

    public String getToIATA() {
        return toIATA;
    }

    public void setToIATA(String toIATA) {
        this.toIATA = toIATA;
    }

    public int getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(int flightTime) {
        this.flightTime = flightTime;
    }

    @Override
    public int compareTo(FlightOffer o) {
        return price - o.price;
    }
}

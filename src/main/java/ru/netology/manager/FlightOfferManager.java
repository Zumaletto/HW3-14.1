package ru.netology.manager;

import ru.netology.domain.FlightOffer;
import ru.netology.repo.FlightOfferRepo;

public class FlightOfferManager {
    private FlightOfferRepo repo;

    public FlightOfferManager(FlightOfferRepo repo){this.repo = repo;}

    public void add(FlightOffer ticket) {
        repo.save(ticket);
    }

    public FlightOffer[] findAll(String fromIATA, String toIATA) {
        FlightOffer[] result = new FlightOffer[0];
        for (FlightOffer ticket : repo.findAll()) {
            if (ticket.getFromIATA() == fromIATA && ticket.getToIATA() ==toIATA) {
                FlightOffer[] tmp = new FlightOffer[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        return result;
    }


}

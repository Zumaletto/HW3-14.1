package ru.netology.repo;

import ru.netology.domain.FlightOffer;

public class FlightOfferRepo {
    private FlightOffer[] tickets = new FlightOffer[0];

    public void save(FlightOffer ticket) {
        int length = tickets.length + 1;
        FlightOffer[] tmp = new FlightOffer[length];
        System.arraycopy(tickets, 0, tmp, 0, tickets.length);
        int indexLast = tmp.length - 1;
        tmp[indexLast] = ticket;
        tickets = tmp;
    }

    public FlightOffer[] findAll() {
        return tickets;
    }

    public FlightOffer findById(int id) {
        for (FlightOffer ticket : tickets) {
            if (ticket.getId() == id) {
                return ticket;
            }
        }
        return null;
    }

    public void removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException("Element with id: " + id + " not found");
        }
        int length = tickets.length - 1;
        FlightOffer[] tmp = new FlightOffer[length];
        int index = 0;
        for (FlightOffer item : tickets) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        tickets = tmp;
    }
}

package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.FlightOffer;
import ru.netology.repo.FlightOfferRepo;

import static org.junit.jupiter.api.Assertions.*;

class FlightOfferManagerTest {
    private FlightOfferRepo repo = new FlightOfferRepo();
    private FlightOfferManager manager = new FlightOfferManager(repo);
    private FlightOffer first = new FlightOffer(1, 4500, "LED", "MOW", 40);
    private FlightOffer second = new FlightOffer(2, 5170, "LED", "ALA", 350);
    private FlightOffer third = new FlightOffer(3, 17200, "MOW", "GOI", 250);
    private FlightOffer forth = new FlightOffer(4, 17250, "DME", "FRU", 60);
    private FlightOffer fifth = new FlightOffer(5, 23142, "DME", "ZKD", 60);
    private FlightOffer sixth = new FlightOffer(6, 33750, "DME", "ZKD", 120);
    private FlightOffer seventh = new FlightOffer(7, 35170, "LED", "ALA", 650);
    private FlightOffer eighth = new FlightOffer(8, 41107, "MOW", "GOI", 143);
    private FlightOffer ninth = new FlightOffer(9, 45170, "LED", "ALA", 650);
    private FlightOffer tenth = new FlightOffer(10, 55170, "LED", "ALA", 650);

    @BeforeEach
    public void setUP() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(forth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
    }

    @Test
    void ShouldFindAllWithFromAndTo() {
        FlightOffer[] expected = new FlightOffer[]{second, seventh, ninth, tenth};
        FlightOffer[] actual = manager.findAll("LED", "ALA");
        assertArrayEquals(expected,actual);
    }



    @Test
    void ShouldFindAllWithoutFromAndTo() {
        assertArrayEquals(new FlightOffer[]{}, manager.findAll("FRU", "EGO"));
    }

    @Test
    void ShouldFindAllWithoutFromAndWithTo() {
        assertArrayEquals(new FlightOffer[]{}, manager.findAll("FRU", "DME"));
    }

    @Test
    void ShouldFindAllWitFromAndWithoutTo() {
        assertArrayEquals(new FlightOffer[]{}, manager.findAll("DME", "EGO"));
    }


    @Test
    void ShouldFindAllEmpty() {
        assertArrayEquals(new FlightOffer[]{}, manager.findAll("", ""));
    }

}
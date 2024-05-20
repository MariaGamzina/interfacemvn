package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;


public class AviaSoulsTest {


    Ticket ticket1 = new Ticket(
            "Париж",
            "Стамбул",
            5000,
            7,
            12
    );

    Ticket ticket2 = new Ticket(
            "Сочи",
            "Москва",
            6500,
            13,
            15
    );

    Ticket ticket3 = new Ticket(
            "Сочи",
            "Москва",
            5000,
            9,
            12
    );

    Ticket ticket4 = new Ticket(
            "Париж",
            "Стамбул",
            5700,
            3,
            7
    );

    Ticket ticket5 = new Ticket(
            "Париж",
            "Стамбул",
            4100,
            20,
            23
    );

    Ticket ticket6 = new Ticket(
            "Берлин",
            "Стамбул",
            4100,
            20,
            23
    );

    @Test
    public void shouldSortByTime() {
        TicketTimeComparator timeComparator = new TicketTimeComparator();
        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);


        Ticket[] expected = {ticket5, ticket4, ticket1};
        Ticket[] actual = aviaSouls.searchAndSortBy("Париж", "Стамбул", timeComparator);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortByTimeNoTickets() {
        TicketTimeComparator timeComparator = new TicketTimeComparator();
        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);


        Ticket[] expected = {};
        Ticket[] actual = aviaSouls.searchAndSortBy("Стамбул", "Москва", timeComparator);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortByTimeOneTicket() {
        TicketTimeComparator timeComparator = new TicketTimeComparator();
        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);


        Ticket[] expected = {ticket6};
        Ticket[] actual = aviaSouls.searchAndSortBy("Берлин", "Стамбул", timeComparator);
        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldCompareTimeOneMoreTwo() {
        TicketTimeComparator timeComparator = new TicketTimeComparator();

        Ticket[] tickets = {ticket1, ticket2};

        Arrays.sort(tickets, timeComparator);


        int expected = 1;
        int actual = timeComparator.compare(ticket1, ticket2);

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldCompareTimeTwoMoreOne() {
        TicketTimeComparator timeComparator = new TicketTimeComparator();

        Ticket[] tickets = {ticket1, ticket2};

        Arrays.sort(tickets, timeComparator);


        int expected = -1;
        int actual = timeComparator.compare(ticket2, ticket1);

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldCompareTimeOneEqualsTwo() {
        TicketTimeComparator timeComparator = new TicketTimeComparator();

        Ticket[] tickets = {ticket3, ticket5};

        Arrays.sort(tickets, timeComparator);


        int expected = 0;
        int actual = timeComparator.compare(ticket3, ticket5);

        Assertions.assertEquals(expected, actual);

    }


    @Test
    public void shouldCompareTicketOneMoreThenTwo() {

        int expected = -1;
        int actual = ticket1.compareTo(ticket2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCompareTicketTwoMoreThenOne() {

        int expected = 1;
        int actual = ticket2.compareTo(ticket1);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCompareTicketOneEqualsThree() {

        int expected = 0;
        int actual = ticket1.compareTo(ticket3);

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldSortSearch() {
        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);


        Ticket[] expected = {ticket5, ticket1, ticket4};
        Ticket[] actual = aviaSouls.search("Париж", "Стамбул");
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSortSearchNoTicketsTo() {
        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);


        Ticket[] expected = {};
        Ticket[] actual = aviaSouls.search("Париж", "Москва");
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSortSearchNoTicketsFrom() {
        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);


        Ticket[] expected = {};
        Ticket[] actual = aviaSouls.search("Москва", "Стамбул");
        Assertions.assertArrayEquals(expected, actual);

    }


}

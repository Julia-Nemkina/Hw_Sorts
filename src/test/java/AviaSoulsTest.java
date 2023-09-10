import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class AviaSoulsTest {
    @Test
    public void testSortTickets() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 200, 10, 12); //
        Ticket ticket2 = new Ticket("MSK", "EKB", 800, 9, 15);
        Ticket ticket3 = new Ticket("MSK", "SMR", 450, 12, 16);
        Ticket ticket4 = new Ticket("MSK", "SPB", 250, 18, 21); //
        Ticket ticket5 = new Ticket("MSK", "SPB", 200, 6, 10); //
        Ticket ticket6 = new Ticket("UFA", "SPB", 990, 10, 17);
        Ticket ticket7 = new Ticket("NEW", "LA", 300, 15, 18);
        Ticket ticket8 = new Ticket("MSK", "SPB", 500, 8, 8); //
        Ticket ticket9 = new Ticket("MSK", "SPB", 350, 8, 9); //
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);

        Ticket[] actual = manager.search("MSK", "SPB");
        Ticket[] expected = {ticket1, ticket5, ticket4, ticket9, ticket8};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortIfTicketNotFound() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 200, 10, 12); //
        Ticket ticket2 = new Ticket("MSK", "EKB", 800, 9, 15);
        Ticket ticket3 = new Ticket("MSK", "SMR", 450, 12, 16);
        Ticket ticket4 = new Ticket("MSK", "SPB", 250, 18, 21); //
        Ticket ticket5 = new Ticket("MSK", "SPB", 200, 6, 10); //
        Ticket ticket6 = new Ticket("UFA", "SPB", 990, 10, 17);
        Ticket ticket7 = new Ticket("NEW", "LA", 300, 15, 18);
        Ticket ticket8 = new Ticket("MSK", "SPB", 500, 8, 8); //
        Ticket ticket9 = new Ticket("MSK", "SPB", 350, 8, 9); //
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);

        Ticket[] actual = manager.search("MSK", "La");
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortOnlyOneTicket() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 200, 10, 12); //
        Ticket ticket2 = new Ticket("MSK", "EKB", 800, 9, 15);
        Ticket ticket3 = new Ticket("MSK", "SMR", 450, 12, 16);
        Ticket ticket4 = new Ticket("MSK", "SPB", 250, 18, 21); //
        Ticket ticket5 = new Ticket("MSK", "SPB", 200, 6, 10); //
        Ticket ticket6 = new Ticket("UFA", "SPB", 990, 10, 17);
        Ticket ticket7 = new Ticket("NEW", "LA", 300, 15, 18);
        Ticket ticket8 = new Ticket("MSK", "SPB", 500, 8, 8); //
        Ticket ticket9 = new Ticket("MSK", "SPB", 350, 8, 9); //
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);

        Ticket[] actual = manager.search("MSK", "SMR");
        Ticket[] expected = {ticket3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortTicketsWithComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 200, 10, 12); // 2
        Ticket ticket2 = new Ticket("MSK", "EKB", 800, 9, 15);
        Ticket ticket3 = new Ticket("MSK", "SMR", 450, 12, 16);
        Ticket ticket4 = new Ticket("MSK", "SPB", 250, 18, 21); // 3
        Ticket ticket5 = new Ticket("MSK", "SPB", 200, 6, 10); // 4
        Ticket ticket6 = new Ticket("UFA", "SPB", 990, 10, 17);
        Ticket ticket7 = new Ticket("NEW", "LA", 300, 15, 18);
        Ticket ticket8 = new Ticket("MSK", "SPB", 500, 8, 8); // 0
        Ticket ticket9 = new Ticket("MSK", "SPB", 350, 8, 9); // 1
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.search("MSK", "SPB", comparator);
        Ticket[] expected = {ticket8, ticket9, ticket1, ticket4, ticket5};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortNotFoundTicketsWithComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 200, 10, 12); // 2
        Ticket ticket2 = new Ticket("MSK", "EKB", 800, 9, 15);
        Ticket ticket3 = new Ticket("MSK", "SMR", 450, 12, 16);
        Ticket ticket4 = new Ticket("MSK", "SPB", 250, 18, 21); // 3
        Ticket ticket5 = new Ticket("MSK", "SPB", 200, 6, 10); // 4
        Ticket ticket6 = new Ticket("UFA", "SPB", 990, 10, 17);
        Ticket ticket7 = new Ticket("NEW", "LA", 300, 15, 18);
        Ticket ticket8 = new Ticket("MSK", "SPB", 500, 8, 8); // 0
        Ticket ticket9 = new Ticket("MSK", "SPB", 350, 8, 9); // 1
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.search("MSK", "LA", comparator);
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void testSortOnlyOneTicketWithComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 200, 10, 12); // 2
        Ticket ticket2 = new Ticket("MSK", "EKB", 800, 9, 15);
        Ticket ticket3 = new Ticket("MSK", "SMR", 450, 12, 16);
        Ticket ticket4 = new Ticket("MSK", "SPB", 250, 18, 21); // 3
        Ticket ticket5 = new Ticket("MSK", "SPB", 200, 6, 10); // 4
        Ticket ticket6 = new Ticket("UFA", "SPB", 990, 10, 17);
        Ticket ticket7 = new Ticket("NEW", "LA", 300, 15, 18);
        Ticket ticket8 = new Ticket("MSK", "SPB", 500, 8, 8); // 0
        Ticket ticket9 = new Ticket("MSK", "SPB", 350, 8, 9); // 1
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.search("UFA", "SPB", comparator);
        Ticket[] expected = {ticket6};

        Assertions.assertArrayEquals(expected, actual);
    }
}

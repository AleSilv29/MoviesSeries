package Tests;

import Model.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void calculatePriceForAllOrders() {
        List<Item> iniIt = new ArrayList<>();
        iniIt.add(new Series("Samurai Gec", 10, 2012, 13));
        iniIt.add(new Series("Gugushtiukul Furios", 5.5, 1967, 2));
        iniIt.add(new Movies("Marele castron", 8.7, 2003, 2, 10000));
        iniIt.add(new Movies("Bebelusul fermecat", 4, 1700, 300, 10));
        List<Order> iniOr = new ArrayList<>();
        List<Item> temp = new ArrayList<>();
        temp.add(iniIt.get(0));
        temp.add(iniIt.get(2));
        iniOr.add(new Order(LocalDateTime.now(), temp));
        temp = new ArrayList<>();
        temp.add(iniIt.get(1));
        temp.add(iniIt.get(3));
        iniOr.add(new Order(LocalDateTime.of(2012, 6, 12, 3, 4), temp));
        User u = new User("1", "Pop", "Florinel", "123", iniOr);
        assertEquals(3253.5, u.calculatePriceForAllOrders());
    }
}
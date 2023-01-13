package Tests;

import Model.Item;
import Model.Movies;
import Model.Order;
import Model.Series;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    void calculatePriceForOrder() {
        LocalDateTime specificDate = LocalDateTime.of(2014, Month.APRIL, 1, 10, 10, 30);
        List<Item> iniIt = new ArrayList<>();
        iniIt.add(new Series("Samurai Gec", 10, 2012, 13));
        iniIt.add(new Series("Gugushtiukul Furios", 5.5, 1967, 2));
        iniIt.add(new Movies("Marele castron", 8.7, 2003, 2, 10000));
        iniIt.add(new Movies("Bebelusul fermecat", 4, 1700, 300, 10));
        List<Order> iniOr = new ArrayList<>();
        List<Item> temp = new ArrayList<>();
        temp.add(iniIt.get(0));
        temp.add(iniIt.get(2));
        Order o = new Order(specificDate, temp);
        assertEquals(92.5, o.calculatePriceForOrder());
    }
}
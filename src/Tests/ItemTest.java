package Tests;

import Model.Movies;
import Model.Series;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {
    @Test
    void calculatePrice(){
        Movies movie1 = new Movies("Ice Age", 10, 2002,80,1400);
        assertEquals(840,movie1.calculatePrice());
        Series series1 = new Series("Adventure Time", 10, 2012, 20);
        assertEquals(110, series1.calculatePrice());
    }

}
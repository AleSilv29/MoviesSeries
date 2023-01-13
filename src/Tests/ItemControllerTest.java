package Tests;

import Controller.ItemController;
import Model.Item;
import Model.Movies;
import Model.Series;
import org.junit.jupiter.api.Test;
//import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ItemControllerTest {

    @Test
    void getMoviesSortedByRating() {
        List<Item> movies = new ArrayList<>();
        Movies movie1 = new Movies("Icecream Age",10, 2002, 90, 1000);
        Movies movie2 = new Movies("Razboiul stelutei",9.5, 2012, 120, 5000);
        Movies movie3 = new Movies("Lord Of no Rings",7, 2005, 100, 500);
        Movies movie4 = new Movies("Piratii de la carainfo",8, 2022, 80, 800);
        movies.add(movie1);
        movies.add(movie2);
        movies.add(movie3);
        movies.add(movie4);
        ItemController it = new ItemController(movies);
        List<Movies> itSort=it.getMoviesSortedByRating();
        assertEquals("Lord Of no Rings", itSort.get(0).getTitle());
    }

    @Test
    void getLongestSeries() {
        List<Item> series = new ArrayList<>();
        Series series1 = new Series("Icecream Age",10, 2002, 9);
        Series series2 = new Series("Razboiul stelutei",9.5, 2012, 120);
        Series series3 = new Series("Lord Of no Rings",7, 2005, 100);
        Series series4 = new Series("Piratii de la carainfo",8, 2022, 80);
        series.add(series1);
        series.add(series2);
        series.add(series3);
        series.add(series4);
        ItemController it = new ItemController(series);
        Series longestSeries = it.getLongestSeries();
        assertEquals("Razboiul stelutei", longestSeries.getTitle());
    }

    @Test
    void getHighestBudgetMovie() {
        List<Item> movies = new ArrayList<>();
        Movies movie1 = new Movies("Icecream Age",10, 2002, 90, 1000);
        Movies movie2 = new Movies("Razboiul stelutei",9.5, 2012, 120, 5000);
        Movies movie3 = new Movies("Lord Of no Rings",7, 2005, 100, 500);
        Movies movie4 = new Movies("Piratii de la carainfo",8, 2022, 80, 800);
        movies.add(movie1);
        movies.add(movie2);
        movies.add(movie3);
        movies.add(movie4);
        ItemController it = new ItemController(movies);
        Movies highestBudgetMovie = it.getHighestBudgetMovie();
        assertEquals("Razboiul stelutei", highestBudgetMovie.getTitle());
    }
}
package Controller;

import Model.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ItemController {
    private List<Item> items;

    public ItemController(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItems()
    {
        return new ArrayList<>(items);
    }
    public List<Movies> getMovies()
    {
        List<Movies> x = new ArrayList<>();
        for (Item i : items)
        {
            try
            {
                x.add((Movies) i);
            }
            catch (ClassCastException ignored)
            {
            }
        }
        return x;
    }
    public List<Series> getSeries()
    {
        List<Series> x = new ArrayList<>();
        for (Item i : items)
        {
            try
            {
                x.add((Series) i);
            }
            catch (ClassCastException ignored)
            {
            }
        }
        return x;
    }
    public List<Movies> getMoviesSortedByRating()
    {
        List<Movies> res = getMovies();
        Collections.sort(res,Collections.reverseOrder());
        return res;
    }
    public Series getLongestSeries()
    {
        Series s = getSeries().get(0);
        for (Series x : getSeries())
        {
            if (x.getNumberOfEpisodes() > s.getNumberOfEpisodes())
                s = x;
        }
        return s;
    }
    public Movies getHighestBudgetMovie()
    {
        Movies m = getMovies().get(0);
        for (Movies x : getMovies())
        {
            if (x.getBudget() > m.getBudget())
                m = x;
        }
        return m;
    }
}

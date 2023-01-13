package Model;

import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private LocalDateTime date;
    private List<Item> items;
    public Order(LocalDateTime date, List<Item> items) {
        this.date = date;
        this.items = items;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public double calculatePriceForOrder(){
        double sum = 0;
        for (Item i : items)
            sum += i.calculatePrice();
        return sum;
    };

}

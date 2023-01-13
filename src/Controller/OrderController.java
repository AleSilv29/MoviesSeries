package Controller;

import Model.Item;
import Model.Order;
import Model.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OrderController {
    private List<Order> orders;
    private UserController usersc;
    private ItemController itemsc;

    public OrderController(List<Order> orders, UserController usersc, ItemController itemsc) {
        this.orders = orders;
        this.usersc = usersc;
        this.itemsc = itemsc;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public UserController getUsersc() {
        return usersc;
    }

    public ItemController getItemsc() {
        return itemsc;
    }

    public void addOrder(String firstname, String lastname, List<String> l) {
        User u = null;
        for (User x : usersc.getUsers())
        {
            if (Objects.equals(x.getFirstName(), firstname) && Objects.equals(x.getLastName(), lastname))
                u = x;
        }
        if (u == null)
            throw new RuntimeException("Invalid firstname/lastname");
        List<Item> orderedItems = new ArrayList<>();
        for (String title : l)
        {
            for (Item i : itemsc.getItems())
            {
                if (Objects.equals(i.getTitle(), title))
                {
                    orderedItems.add(i);
                }
            }
        }
        Order no = new Order(LocalDateTime.now(), orderedItems);
        u.getOrders().add(no);
        orders.add(no);
    }
}

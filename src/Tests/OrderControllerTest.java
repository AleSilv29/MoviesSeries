package Tests;

import Controller.ItemController;
import Controller.OrderController;
import Controller.UserController;
import Model.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderControllerTest {

    @Test
    void addOrder() {
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
        List<String> orderList = new ArrayList<>();
        orderList.add("Samurai Gec");

        List<User> users = new ArrayList<>();
        UserController uc = new UserController(users);
        ItemController items = new ItemController(iniIt);
        OrderController oc = new OrderController(iniOr,uc, items);
        /*oc.addOrder("Talpa", "Adrian", orderList);
        System.out.println(iniOr.get(4));*/

    }
}
import Controller.ItemController;
import Controller.OrderController;
import Controller.UserController;
import Model.*;
import View.View;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
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
        List<User> iniUs = new ArrayList<>();
        List<Order> temp2 = new ArrayList<>();
        temp2.add(iniOr.get(0));
        iniUs.add(new User("1234","Talpa", "Adrian", "1234", temp2));
        temp2 = new ArrayList<>();
        temp2.add(iniOr.get(1));
        iniUs.add(new User("1235","Milos", "Ricardo","blabla", temp2));
        iniUs.add(new User("iyiy555","Ariana", "Vaida","ariana", temp2));
        ItemController ic = new ItemController(iniIt);
        UserController uc = new UserController(iniUs);
        OrderController oc = new OrderController(iniOr,uc, ic);
        View v = new View(ic, oc, uc);
        v.console();
    }
}
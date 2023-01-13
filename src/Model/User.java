package Model;

import java.util.List;

public class User {
    private String id;
private String firstName;
private String lastName;
private String password;
private List<Order> orders;

    public User(String id, String firstName, String lastName, String password, List<Order> orders) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password=password;
        this.orders = orders;
    }

    public String getId() {
        return id;
    }

    public void setId(int id) {
        this.id = String.valueOf(id);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public double calculatePriceForAllOrders(){
        double sum = 0;
        for (Order o : orders)
            sum += o.calculatePriceForOrder();
        return sum;
    }
}

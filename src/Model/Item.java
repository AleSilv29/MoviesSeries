package Model;

public abstract class Item {
    private String title;
    private double rating;
    private int jahr;

    public Item(String title, double rating, int jahr) {
        this.title = title;
        this.rating = rating;
        this.jahr = jahr;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getJahr() {
        return jahr;
    }

    public void setJahr(int jahr) {
        this.jahr = jahr;
    }

    public abstract double calculatePrice();
}



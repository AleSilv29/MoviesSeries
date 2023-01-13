package Model;

public class Movies extends Item implements Comparable<Movies> {
    private int duration;
    private double budget;

    public Movies(String title, double rating, int jahr, int duration, double budget) {
        super(title, rating, jahr);
        this.duration = duration;
        this.budget = budget;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    @Override
    public double calculatePrice() {
        return duration * 10.5;
    }

    @Override
    public int compareTo(Movies o) {
        double diff = getRating() - o.getRating();
        if (diff < 0)
            return -1;
        if (diff == 0)
            return 0;
        if (diff > 0)
            return 1;
        throw new RuntimeException();
    }
}

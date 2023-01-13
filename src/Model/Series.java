package Model;

public class Series extends Item{
    private int numberOfEpisodes;

    public Series(String title, double rating, int jahr, int numberOfEpisodes) {
        super(title, rating, jahr);
        this.numberOfEpisodes = numberOfEpisodes;
    }

    public int getNumberOfEpisodes() {
        return numberOfEpisodes;
    }

    public void setNumberOfEpisodes(int numberOfEpisodes) {
        this.numberOfEpisodes = numberOfEpisodes;
    }

    @Override
    public double calculatePrice() {
        return 5.5 * numberOfEpisodes;
    }
}

package FileHandler;

public class Wine {
    private String type;
    private double alcohol;
    private int quality;

    public Wine(String type, double alcohol, int quality) {
        this.type = type;
        this.alcohol = alcohol;
        this.quality = quality;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(double alcohol) {
        this.alcohol = alcohol;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }
}
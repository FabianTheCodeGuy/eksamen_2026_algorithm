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

    public double getAlcohol() {
        return alcohol;
    }

    public int getQuality() {
        return quality;
    }

    @Override
    public String toString() {
        return "Wine{" +
                "type='" + type + '\'' +
                ", alcohol=" + alcohol +
                ", quality=" + quality +
                '}';
    }
}
package FileHandler;

public class Wine {
    private String type;
    private double alcohol;

    public Wine(String type, double alcohol) {
        this.type = type;
        this.alcohol = alcohol;
    }

    public String getType() {
        return type;
    }

    public double getAlcohol() {
        return alcohol;
    }

    @Override
    public String toString() {
        return "Wine{" +
                "type='" + type + '\'' +
                ", alcohol=" + alcohol +
                '}';
    }
}
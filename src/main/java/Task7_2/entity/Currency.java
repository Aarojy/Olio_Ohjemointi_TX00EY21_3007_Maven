package Task7_2.entity;

public class Currency {
    String name;
    String abbreviation;
    Double conversionRate;

    public Currency(String name, String abbreviation, Double conversionRate) {
        this.name = name;
        this.abbreviation = abbreviation;
        this.conversionRate = conversionRate;
    }

    public String getName() {
        return name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public Double getConversionRate() {
        return conversionRate;
    }
}

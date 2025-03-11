package Task7_4.entity;

import Task7_4.datasource.MariaDbJpaConnection;
import jakarta.persistence.*;

@Entity
@Table(name="currencies")
public class Currency {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name="currencyName")
    String name;
    @Column(name="abbreviation")
    String abbreviation;
    @Column(name="conversionRate")
    Double conversionRate;

    public Currency(String name, String abbreviation, Double conversionRate) {
        super();
        this.name = name;
        this.abbreviation = abbreviation;
        this.conversionRate = conversionRate;
    }

    public Currency() {

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

    public void setName(String name) {
        this.name = name;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public void setConversionRate(Double conversionRate) {
        this.conversionRate = conversionRate;
    }
}

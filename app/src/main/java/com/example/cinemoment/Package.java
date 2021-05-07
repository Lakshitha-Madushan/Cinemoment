package com.example.cinemoment;

public class Package {
    private String Name;
    private Double Price;
    private Double Advance;

    public Package() {
    }

    public Package(String name, Double price, Double advance) {
        Name = name;
        Price = price;
        Advance = advance;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        Price = price;
    }

    public Double getAdvance() {
        return Advance;
    }

    public void setAdvance(Double advance) {
        Advance = advance;
    }
}

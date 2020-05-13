package ru.fjrd.receiptAnalyzer.model;

public class Item {
    private String name;
    private Integer price;
    private Double quantity;
    private Integer sum;

    @Override
    public String toString() {
        return "\n\t\t" + "Item{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", quantity='" + quantity + '\'' +
                ", sum='" + sum + '\'' +
                '}';
    }
}

package ru.fjrd.receiptAnalyzer.model;

public class Item {
    private String name;
    private Integer price;
    private Double quantity;
    private Integer sum;

    public Item(String name, Integer price, Double quantity, Integer sum) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.sum = sum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

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

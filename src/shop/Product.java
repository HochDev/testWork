package shop;

import java.math.BigDecimal;

public class Product {

    private int id;
    private String name;
    private BigDecimal price;

    public Product(int id, String name, BigDecimal price) {

        if (name == null || price == null) {
            throw new IllegalArgumentException();
        }

        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        if (name == null) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    public BigDecimal getPrice() {

        return price;
    }

    public void setPrice(BigDecimal price) {

        if(price == null ) {
            throw  new IllegalArgumentException();
        }

        this.price = price;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price;
    }
}

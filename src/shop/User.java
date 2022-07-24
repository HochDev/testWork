package shop;

import java.math.BigDecimal;

public class User {

    private int id;
    private String firstName;
    private String lastName;
    private BigDecimal amountOfMoney;

    public User(int id, String firstName, String lastName, BigDecimal amountOfMoney) {

        if(firstName == null || lastName == null || amountOfMoney == null ) {
          throw  new IllegalArgumentException();
        }

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.amountOfMoney = amountOfMoney;
    }

    public int getId() {

        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {

        if(firstName == null) {
            throw  new IllegalArgumentException();
        }
        this.firstName = firstName;
    }

    public String getLastName() {

        return lastName;
    }

    public void setLastName(String lastName) {
        if(lastName == null) {
            throw  new IllegalArgumentException();
        }
        this.lastName = lastName;
    }

    public BigDecimal getAmountOfMoney() {

        return amountOfMoney;
    }

    public void setAmountOfMoney(BigDecimal amountOfMoney) {
        if(amountOfMoney == null ) {
            throw  new IllegalArgumentException();
        }
        this.amountOfMoney = amountOfMoney;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", amountOfMoney=" + amountOfMoney;
    }
}

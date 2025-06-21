package model;

/**
 *
 * @author qp
 */
public class Book {

    private String bcode;
    private String title;
    private int quantity;
    private int lended;
    private double price;

    public Book() {
    }

    public Book(String bcode, String title, int quantity, int lended, double price) {
        this.bcode = bcode;
        this.title = title;
        this.quantity = quantity;
        this.lended = lended;
        this.price = price;
    }

    public String getBcode() {
        return bcode;
    }

    public void setBcode(String bcode) {
        this.bcode = bcode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getLended() {
        return lended;
    }

    public void setLended(int lended) {
        this.lended = lended;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getValue() {
        return this.quantity * this.price;
    }

    @Override
    public String toString() {
        return String.format("%-5s | %-30s | %5d | %5d | %7.2f | %7.2f",
                bcode, title, quantity, lended, price, getValue());
    }
}

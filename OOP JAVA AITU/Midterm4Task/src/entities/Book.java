package entities;

public class Book{
    private int id;
    private String name;
    private double price;
    private String authorName;

    public Book() {
    }

    public Book(String name, double price, String authorName) {
        this.name = name;
        this.price = price;
        this.authorName = authorName;
    }

    public Book(int id, String name, double price, String authorName) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.authorName = authorName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getAuthorName() {
        return authorName;
    }

    @Override
    public String toString() {
        return "Books{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", authorName='" + authorName + '\'' +
                '}';
    }
}

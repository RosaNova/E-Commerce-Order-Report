package model;

public class Product{
    private int id;
    private String title;
    private double price;
    private String imgUrl;
    private int qty;

    // Constructors
    public Product() {}

    public Product(String title, double price, String imgUrl, int qty) {
        this.title = title;
        this.price = price;
        this.imgUrl = imgUrl;
        this.qty = qty;
    }

    public Product(int id, String title, double price, String imgUrl, int qty) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.imgUrl = imgUrl;
        this.qty = qty;
    }

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public String getImgUrl() { return imgUrl; }
    public void setImgUrl(String imgUrl) { this.imgUrl = imgUrl; }

    public int getQty() { return qty; }
    public void setQty(int qty) { this.qty = qty; }
}

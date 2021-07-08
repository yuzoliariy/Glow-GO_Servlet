package entity;

import java.util.Objects;

public class Product {
    private int id;
    private String name;
    private double price;
    private double capacity;
    private String description;
    private String brand;
    private String madeIn;
    private int productTypeId;
    private String photo;

    public Product(){

    }

    public Product(int id, String name, double price, double capacity,
                   String description, String brand, String madeIn, int productTypeId,String photo) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.capacity = capacity;
        this.description = description;
        this.brand = brand;
        this.madeIn = madeIn;
        this.productTypeId = productTypeId;
        this.photo = photo;
    }
    public Product( String name, double price, double capacity,
                   String description, String brand, String madeIn, int productTypeId,String photo) {
        this.name = name;
        this.price = price;
        this.capacity = capacity;
        this.description = description;
        this.brand = brand;
        this.madeIn = madeIn;
        this.productTypeId = productTypeId;
        this.photo = photo;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getMadeIn() {
        return madeIn;
    }

    public void setMadeIn(String madeIn) {
        this.madeIn = madeIn;
    }

    public int getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(int productTypeId) {
        this.productTypeId = productTypeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && Objects.equals(name, product.name) && Objects.equals(description, product.description) && Objects.equals(photo, product.photo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, photo);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", capacity=" + capacity +
                ", description='" + description + '\'' +
                ", brand='" + brand + '\'' +
                ", madeIn='" + madeIn + '\'' +
                ", productTypeId=" + productTypeId +
                ", photo='" + photo + '\'' +
                '}';
    }
}

package com.example.lab2question6;

public class Product {
    private final String name;
    private final String price;
    private final int imageResourceId;
    private int quantity;
    public Product(String name, String price, int imageResourceId,int quantity) {
        this.name = name;
        this.price = price;
        this.imageResourceId = imageResourceId;
        this.quantity=1;
    }
    public String getName() {
        return name;
    }
    public String getPrice() {
        return price;
    }
    public int getImageResourceId() {
        return imageResourceId;
    }

    public  int getQuantity(){
        return quantity;
    }
    public void setQuantity(int quantity){
        this.quantity=quantity;
    }
}

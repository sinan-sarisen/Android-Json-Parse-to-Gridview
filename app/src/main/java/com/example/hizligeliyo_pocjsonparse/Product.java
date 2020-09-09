package com.example.hizligeliyo_pocjsonparse;

public class Product {
    private String id;
    private String title;
    private String price;
    private String category;
    private String image;

    public Product(){}
    public Product(String id,String title,String price,String category,String image){
        this.id=id;
        this.title=title;
        this.price=price;
        this.category=category;
        this.image=image;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price+" TL";
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

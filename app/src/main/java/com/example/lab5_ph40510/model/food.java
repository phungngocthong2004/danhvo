package com.example.lab5_ph40510.model;

public class food {
    private int imgfood;
    private String food;
    private int price;
     private int soluong ;

    public food() {
    }

    public food(int imgfood, String food, int price) {
        this.imgfood = imgfood;
        this.food = food;
        this.price = price;
    }

    public food(int imgfood, String food, int price, int soluong) {
        this.imgfood = imgfood;
        this.food = food;
        this.price = price;
        this.soluong = soluong;
    }

    public int getImgfood() {
        return imgfood;
    }

    public void setImgfood(int imgfood) {
        this.imgfood = imgfood;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }
}

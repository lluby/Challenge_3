package org.example;

public class Menu {
    private int id;
    private String name;
    private int price;

    public Menu(int id, String name, int price){
        this.id = id;
        this.name = name;
        this.price = price;
    }


    public int getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public int getPrice(){
        return this.price;
    }

    @Override
    public String toString(){
        return this.id + ". " + this.name + " | " + this.price;
    }


}

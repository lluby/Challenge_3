package org.example;

public class Pesanan {
    private Menu menu;
    private int qty;

    public Pesanan(Menu menu, int qty){
        this.menu = menu;
        this.qty = qty;
    }

    public Menu getMenu(){
        return this.menu;
    }

    public int getQty(){
        return this.qty;
    }

    public int getPrice(){
        return this.menu.getPrice() * this.qty;
    }

    @Override
    public String toString(){
        return this.menu.getName() + "\t" + this.qty + " \t" + this.getPrice();
    }

}

package main.java.ro.pao.Models;

import main.java.ro.pao.Models.Abstracts.AbstractUser;

public class Client extends AbstractUser {
    
    private List<String> cart;

    public Client(String username, String password, String email, List<String> cart) {
        super(username, password, email);
        this.cart = cart;
    }

    public List<String> getCart() {
        return cart;
    }

    public void setCart(List<String> cart) {
        this.cart = cart;
    }
}

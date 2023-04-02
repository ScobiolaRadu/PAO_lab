package src.main.java.ro.pao.Models;

import java.util.List;

import src.main.java.ro.pao.Models.Abstracts.AbstractUser;
import src.main.java.ro.pao.Models.Enums.EnumUsers;

public class Client extends AbstractUser {
    
    private List<String> cart;

    public Client(String username, String password, String email, List<String> cart) {
        super(username, password, email);
        this.cart = cart;
        this.type = EnumUsers.CLIENT;
    }

    public List<String> getCart() {
        return cart;
    }

    public void setCart(List<String> cart) {
        this.cart = cart;
    }
}

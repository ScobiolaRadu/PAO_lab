package main.java.ro.pao.Models;

import main.java.ro.pao.Models.Abstracts.AbstractUser;


public class Admin extends AbstractUser{
    
    public Admin(String username, String password, String email) {
        super(username, password, email);
    }
}

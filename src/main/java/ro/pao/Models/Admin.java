package src.main.java.ro.pao.Models;

import src.main.java.ro.pao.Models.Abstracts.AbstractUser;
import src.main.java.ro.pao.Models.Enums.EnumUsers;

public class Admin extends AbstractUser{
    
    public Admin(String username, String password, String email) {
        super(username, password, email);
        this.type = EnumUsers.ADMIN;
    }
}

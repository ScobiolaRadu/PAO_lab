package ro.pao.Models;

import ro.pao.Models.Abstracts.AbstractUser;
import ro.pao.Models.Enums.EnumUsers;

public class Admin extends AbstractUser{
    
    public Admin(String username, String password, String email) {
        super(username, password, email);
        this.type = EnumUsers.ADMIN;
    }

}

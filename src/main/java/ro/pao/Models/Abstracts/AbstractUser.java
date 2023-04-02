package src.main.java.ro.pao.Models.Abstracts;

import src.main.java.ro.pao.Models.Enums.EnumUsers;

public class AbstractUser {
    
    protected String username;
    protected String password;
    protected String email;
    protected EnumUsers type;

    public AbstractUser(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.type = EnumUsers.UNDEFINED;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}

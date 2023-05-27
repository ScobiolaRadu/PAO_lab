package ro.pao.Models;

import ro.pao.Models.Abstracts.AbstractUser;
import ro.pao.Models.Enums.EnumUsers;

public class Client extends AbstractUser {

    private int id;

    public Client(int id, String username, String password, String email) {
        super(username, password, email);
        this.type = EnumUsers.CLIENT;
    }

    public Client(String username, String password, String email) {
        super(username, password, email);
        this.type = EnumUsers.CLIENT;
    }

    public Client(){
        this.type = EnumUsers.CLIENT;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

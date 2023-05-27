package ro.pao.Services;

import java.util.List;
import ro.pao.Models.Client;
import ro.pao.Models.Guitar;
import ro.pao.Models.Piano;
import ro.pao.Models.Drums;

public interface ClientService {
    void createAccount(Client client);

    int login(String username, String password);

    void addGuitarToCart(Client client, Guitar guitar);

    void addPianoToCart(Client client, Piano piano);

    void addDrumsToCart(Client client, Drums drums);

    void emptyCart(Client client);

    List<Object> showCart(Client client);
}

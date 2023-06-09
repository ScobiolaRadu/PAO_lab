package ro.pao.Services;

import java.util.List;
import ro.pao.Models.Client;

public interface ClientService {
    void createAccount(Client client);

    Client login(String username, String password);

    void addGuitarToCart(Client client, int guitarid);

    void addPianoToCart(Client client, int pianoid);

    void addDrumsToCart(Client client, int drumsid);

    void emptyCart(Client client);

    List<Object> showCart(Client client);
}

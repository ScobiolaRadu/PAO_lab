package ro.pao.Services.Impl;

import java.util.ArrayList;
import java.util.List;

import ro.pao.Models.Client;
import ro.pao.Models.Guitar;
import ro.pao.Models.Piano;
import ro.pao.Models.Drums;
import ro.pao.Repositories.ClientRepository;
import ro.pao.Repositories.CartRepository;
import ro.pao.Services.ClientService;

public class ClientServiceI implements ClientService {

    private ClientRepository clientRepository;
    private CartRepository cartRepository;

    public ClientServiceI(ClientRepository clientRepository, CartRepository cartRepository) {
        this.clientRepository = clientRepository;
        this.cartRepository = cartRepository;
    }

    @Override
    public void createAccount(Client client) {
        clientRepository.createClient(client.getUsername(), client.getEmail(), client.getPassword());
    }

    @Override
    public int login(String username, String password) {
        Client retrievedClient = clientRepository.getClientByUsernameAndPassword(username, password);

        if (retrievedClient != null && retrievedClient.getUsername().equals(username)
                && retrievedClient.getPassword().equals(password)) {
            return 1;
        }
        return 0;
    }

    @Override
    public List<Object> showCart(Client client) {
        int clientId = client.getId();
        List<Object> cartItems = new ArrayList<>();
        cartItems.add(cartRepository.getCartByClientId(clientId));
        return cartItems;
    }

    @Override
    public void addGuitarToCart(Client client, Guitar guitar) {
        int clientId = client.getId();
        cartRepository.addToCart(clientId, guitar, null, null);
    }

    @Override
    public void addPianoToCart(Client client, Piano piano) {
        int clientId = client.getId();
        cartRepository.addToCart(clientId, null, piano, null);
    }

    @Override
    public void addDrumsToCart(Client client, Drums drums) {
        int clientId = client.getId();
        cartRepository.addToCart(clientId, null, null, drums);
    }

    @Override
    public void emptyCart(Client client) {
        int clientId = client.getId();
        cartRepository.clearCartByClientId(clientId);
    }
}

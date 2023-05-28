package ro.pao.Services.Impl;

import java.util.ArrayList;
import java.util.List;

import ro.pao.Models.Client;
import ro.pao.Models.Guitar;
import ro.pao.Models.Piano;
import ro.pao.Models.Drums;
import ro.pao.Repositories.ClientRepository;
import ro.pao.Repositories.CartRepository;
import ro.pao.Repositories.GuitarRepository;
import ro.pao.Repositories.PianoRepository;
import ro.pao.Repositories.DrumsRepository;
import ro.pao.Services.ClientService;

public class ClientServiceI implements ClientService {

    private ClientRepository clientRepository;
    private CartRepository cartRepository;
    private GuitarRepository guitarRepository;
    private PianoRepository pianoRepository;
    private DrumsRepository drumsRepository;

    public ClientServiceI(ClientRepository clientRepository, CartRepository cartRepository, GuitarRepository guitarRepository, PianoRepository pianoRepository, DrumsRepository drumsRepository) {
        this.clientRepository = clientRepository;
        this.cartRepository = cartRepository;
        this.guitarRepository = guitarRepository;
        this.pianoRepository = pianoRepository;
        this.drumsRepository = drumsRepository;
    }

    @Override
    public void createAccount(Client client) {
        clientRepository.createClient(client.getUsername(), client.getEmail(), client.getPassword());
    }

    @Override
    public Client login(String username, String password) {
        Client retrievedClient = clientRepository.getClientByUsernameAndPassword(username, password);
        return retrievedClient;
    }

    @Override
    public List<Object> showCart(Client client) {
        int clientId = client.getId();
        List<Object> cartItems = new ArrayList<>();
        cartItems.add(cartRepository.getCartByClientId(clientId));
        return cartItems;
    }

    @Override
    public void addGuitarToCart(Client client, int guitarId) {
        int clientId = client.getId();
        Guitar guitar = guitarRepository.getGuitarById(guitarId);
        cartRepository.addToCart(clientId, guitar);
    }

    @Override
    public void addPianoToCart(Client client, int pianoId) {
        int clientId = client.getId();
        Piano piano = pianoRepository.getPianoById(pianoId);
        cartRepository.addToCart(clientId, piano);
    }

    @Override
    public void addDrumsToCart(Client client, int drumsId) {
        int clientId = client.getId();
        Drums drums = drumsRepository.getDrumsById(drumsId);
        cartRepository.addToCart(clientId, drums);
    }

    @Override
    public void emptyCart(Client client) {
        int clientId = client.getId();
        cartRepository.clearCartByClientId(clientId);
    }
}

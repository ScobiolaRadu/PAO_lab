package ro.pao.Services;

import java.util.List;

import ro.pao.Models.Client;

public interface ClientService {

    public void createAccount(Client client);
    
    public void login(Client client);

    public void logout(Client client);

    public void deleteAccount(Client client);

    public void addToCart(Client client, String product);

    public List<String> showCart(Client client);

    
}

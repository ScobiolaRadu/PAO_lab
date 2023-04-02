package src.main.java.ro.pao.Services.Impl;

import java.util.ArrayList;
import java.util.List;

import src.main.java.ro.pao.Models.Client;
import src.main.java.ro.pao.Services.ClientService;

public class ClientServiceI implements ClientService{

    private List<Client> clients = new ArrayList<Client>();

    @Override
    public void createAccount(Client client)
    {
        clients.add(client);
    }

    @Override
    public void login(Client client)
    {
        for (int i = 0; i < clients.size(); i++) {
            if (clients.get(i).getUsername().equals(client.getUsername()) && clients.get(i).getPassword().equals(client.getPassword())) {
                System.out.println("You are logged in!");
            }
        }
    }

    @Override
    public void logout(Client client)
    {
        for (int i = 0; i < clients.size(); i++) {
            if (clients.get(i).getUsername().equals(client.getUsername()) && clients.get(i).getPassword().equals(client.getPassword())) {
                System.out.println("You are logged out!");
            }
        }
    }

    @Override
    public void deleteAccount(Client client)
    {
        for (int i = 0; i < clients.size(); i++) {
            if (clients.get(i).getUsername().equals(client.getUsername()) && clients.get(i).getPassword().equals(client.getPassword())) {
                clients.remove(i);
            }
        }
    }

    @Override
    public List<String> showCart(Client client)
    {
        return client.getCart();
    }

    @Override
    public void addToCart(Client client, String product)
    {
        client.getCart().add(product);
    }

}

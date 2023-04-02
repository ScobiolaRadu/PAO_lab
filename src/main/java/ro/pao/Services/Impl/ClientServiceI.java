package ro.pao.Services.Impl;

import java.util.ArrayList;
import java.util.List;

import ro.pao.Models.Client;
import ro.pao.Services.ClientService;
import ro.pao.Models.Guitar;
import ro.pao.Models.Piano;
import ro.pao.Models.Drums;

public class ClientServiceI implements ClientService{

    private List<Client> clients = new ArrayList<Client>();
    private List<Object> cart = new ArrayList<Object>();

    @Override
    public void createAccount(Client client)
    {
        clients.add(client);
    }

    @Override
    public int login(Client client)
    {
        int ok=0;
        for (int i = 0; i < clients.size(); i++) {
            if (clients.get(i).getUsername().equals(client.getUsername()) && clients.get(i).getPassword().equals(client.getPassword())) {
                ok=1;
                System.out.println("You are logged in!");
            }
        }

        if(ok==0)
            System.out.println("Wrong username or password");

        return ok;
    }

    
    public int permitLogin(int ok)
    {
        if(ok==1)
            return 1;
        else
            return 0;
    }

    @Override
    public List<Object> showCart()
    {
        return cart;
    }

    @Override
    public void addGuitarToCart(Client client, Guitar guitar, List<Guitar> guitars)
    {
        int ok=0;
        for (int i = 0; i < guitars.size(); i++) {
            if (guitars.get(i).toString().equals(guitar.toString())) {
                cart.add(guitar);
                ok=1;
            }
        }

        if(ok==0)
            System.out.println("Guitar not found");  

    }
    
    @Override
    public void addPianoToCart(Client client, Piano piano, List<Piano> pianos)
    {
        int ok=0;
        for (int i = 0; i < pianos.size(); i++) {
            if (pianos.get(i).getName().equals(piano.getName())) {
                cart.add(piano);
                ok=1;
            }
        }

        if(ok==0)
            System.out.println("Piano not found");
    }

    @Override
    public void addDrumsToCart(Client client, Drums drums, List<Drums> drumss)
    {
        int ok=0;
        for (int i = 0; i < drumss.size(); i++) {
            if (drumss.get(i).getName().equals(drums.getName())) {
                cart.add(drums);
                ok=1;
            }
        }

        if(ok==0)
            System.out.println("Drums not found");
    }

    @Override
    public void emptyCart()
    {
        cart.clear();
    }

}

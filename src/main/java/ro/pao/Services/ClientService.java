package ro.pao.Services;

import java.util.List;

import ro.pao.Models.Client;

import ro.pao.Models.Guitar;
import ro.pao.Models.Piano;
import ro.pao.Models.Drums;

public interface ClientService {

    public void createAccount(Client client);
    
    public void login(Client client);

    public void addGuitarToCart(Client client, Guitar guitar, List <Guitar> guitars);

    public void addPianoToCart(Client client, Piano piano, List <Piano> pianos);

    public void addDrumsToCart(Client client, Drums drums, List <Drums> drumsList);

    public void emptyCart();

    public List<Object> showCart();

    
}

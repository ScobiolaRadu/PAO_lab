package ro.pao.Repositories;

import ro.pao.Models.Client;

public interface ClientRepository {
    void createClient(String username, String email, String password);

    Client getClientByUsernameAndPassword(String username, String password);
}

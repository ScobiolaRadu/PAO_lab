package ro.pao.Repositories.impl;

import ro.pao.Repositories.ClientRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import ro.pao.Models.Client;

public class ClientRepositoryI implements ClientRepository {
    private Connection connection;

    public ClientRepositoryI(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void createClient(String username, String email, String password) {
        String query = "INSERT INTO client (username, email, password) VALUES (?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            statement.setString(2, email);
            statement.setString(3, password);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Client getClientByUsernameAndPassword(String username, String password) {
        Client client = null;
        String query = "SELECT * FROM client WHERE username = ? AND password = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                client = new Client();
                client.setId(resultSet.getInt("idclient"));
                client.setUsername(resultSet.getString("username"));
                client.setEmail(resultSet.getString("email"));
                client.setPassword(resultSet.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return client;
    }

}

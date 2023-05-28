package ro.pao.Repositories.impl;

import ro.pao.Models.Piano;
import ro.pao.Repositories.PianoRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PianoRepositoryI implements PianoRepository {

    private Connection connection;

    public PianoRepositoryI(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Piano> getAllPianos() {
        List<Piano> pianos = new ArrayList<>();
        String query = "SELECT * FROM piano";

        try (PreparedStatement statement = connection.prepareStatement(query);
                ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("idpiano");
                String brand = resultSet.getString("brand");
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                int quantity = resultSet.getInt("quantity");
                String key = resultSet.getString("musicalkey");

                Piano piano = new Piano(id, brand, name, price, quantity, key);
                pianos.add(piano);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pianos;
    }

    @Override
    public void addPiano(Piano piano) {
        String query = "INSERT INTO piano (brand, name, price, quantity, musicalkey) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, piano.getBrand());
            statement.setString(2, piano.getName());
            statement.setInt(3, piano.getPrice());
            statement.setInt(4, piano.getQuantity());
            statement.setString(5, piano.getKey());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updatePiano(int id, Piano newPiano) {
        String query = "UPDATE piano SET brand = ?, name = ?, price = ?, quantity = ?, musicalkey = ? WHERE idpiano = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, newPiano.getBrand());
            statement.setString(2, newPiano.getName());
            statement.setInt(3, newPiano.getPrice());
            statement.setInt(4, newPiano.getQuantity());
            statement.setString(5, newPiano.getKey());
            statement.setInt(6, id);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletePiano(int id) {
        String query = "DELETE FROM piano WHERE idpiano = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Piano getPianoById(int id) {
        String query = "SELECT * FROM piano WHERE idpiano = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String brand = resultSet.getString("brand");
                    String name = resultSet.getString("name");
                    int price = resultSet.getInt("price");
                    int quantity = resultSet.getInt("quantity");
                    String key = resultSet.getString("musicalkey");

                    return new Piano(id, brand, name, price, quantity, key);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
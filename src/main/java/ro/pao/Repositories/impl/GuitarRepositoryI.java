package ro.pao.Repositories.impl;

import ro.pao.Models.Guitar;
import ro.pao.Repositories.GuitarRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class GuitarRepositoryI implements GuitarRepository{

    private Connection connection;

    public GuitarRepositoryI(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Guitar> getAllGuitars() {
        List<Guitar> guitars = new ArrayList<>();
        String query = "SELECT * FROM guitar";

        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("idguitar");
                String brand = resultSet.getString("brand");
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                int quantity = resultSet.getInt("quantity");
                String body = resultSet.getString("body");

                Guitar guitar = new Guitar(id, brand, name, price, quantity, body);
                guitars.add(guitar);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return guitars;
    }

    @Override
    public void addGuitar(Guitar guitar) {
        String query = "INSERT INTO guitar (brand, name, price, quantity, body) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, guitar.getBrand());
            statement.setString(2, guitar.getName());
            statement.setInt(3, guitar.getPrice());
            statement.setInt(4, guitar.getQuantity());
            statement.setString(5, guitar.getBody());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateGuitar(int id, Guitar newGuitar) {
        String query = "UPDATE guitar SET brand = ?, name = ?, price = ?, quantity = ?, body = ? WHERE idguitar = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, newGuitar.getBrand());
            statement.setString(2, newGuitar.getName());
            statement.setInt(3, newGuitar.getPrice());
            statement.setInt(4, newGuitar.getQuantity());
            statement.setString(5, newGuitar.getBody());
            statement.setInt(6, id);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteGuitar(int id) {
        String query = "DELETE FROM guitar WHERE idguitar = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Guitar getGuitarById(int id) {
        String query = "SELECT * FROM guitar WHERE idguitar = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String brand = resultSet.getString("brand");
                    String name = resultSet.getString("name");
                    int price = resultSet.getInt("price");
                    int quantity = resultSet.getInt("quantity");
                    String body = resultSet.getString("body");

                    return new Guitar(brand, name, price, quantity, body);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
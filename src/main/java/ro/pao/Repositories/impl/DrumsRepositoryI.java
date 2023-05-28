package ro.pao.Repositories.impl;

import ro.pao.Models.Drums;
import ro.pao.Repositories.DrumsRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DrumsRepositoryI implements DrumsRepository {

    private Connection connection;

    public DrumsRepositoryI(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Drums> getAllDrums() {
        List<Drums> drumss = new ArrayList<>();
        String query = "SELECT * FROM drums";

        try (PreparedStatement statement = connection.prepareStatement(query);
                ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("iddrums");
                String brand = resultSet.getString("brand");
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                int quantity = resultSet.getInt("quantity");
                int nr_drums = resultSet.getInt("nr_drums");

                Drums drums = new Drums(id, brand, name, price, quantity, nr_drums);
                drumss.add(drums);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return drumss;
    }

    @Override
    public void addDrums(Drums drums) {
        String query = "INSERT INTO drums (brand, name, price, quantity, nr_drums) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, drums.getBrand());
            statement.setString(2, drums.getName());
            statement.setInt(3, drums.getPrice());
            statement.setInt(4, drums.getQuantity());
            statement.setInt(5, drums.getNr_drums());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateDrums(int id, Drums newDrums) {
        String query = "UPDATE drums SET brand = ?, name = ?, price = ?, quantity = ?, nr_drums = ? WHERE iddrums = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, newDrums.getBrand());
            statement.setString(2, newDrums.getName());
            statement.setInt(3, newDrums.getPrice());
            statement.setInt(4, newDrums.getQuantity());
            statement.setInt(5, newDrums.getNr_drums());
            statement.setInt(6, id);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteDrums(int id) {
        String query = "DELETE FROM drums WHERE iddrums = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Drums getDrumsById(int id) {
        String query = "SELECT * FROM drums WHERE iddrums = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String brand = resultSet.getString("brand");
                    String name = resultSet.getString("name");
                    int price = resultSet.getInt("price");
                    int quantity = resultSet.getInt("quantity");
                    int nr_drums = resultSet.getInt("nr_drums");

                    return new Drums(id, brand, name, price, quantity, nr_drums);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
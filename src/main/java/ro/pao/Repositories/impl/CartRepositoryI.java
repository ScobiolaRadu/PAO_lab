package ro.pao.Repositories.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ro.pao.Models.Cart;
import ro.pao.Models.Drums;
import ro.pao.Models.Guitar;
import ro.pao.Models.Piano;
import ro.pao.Repositories.CartRepository;
import ro.pao.Repositories.DrumsRepository;
import ro.pao.Repositories.GuitarRepository;
import ro.pao.Repositories.PianoRepository;

public class CartRepositoryI implements CartRepository {
    private Connection connection;

    public CartRepositoryI(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void addToCart(int clientId, Guitar guitar, Piano piano, Drums drums) {
        Cart existingCart = getCartByClientId(clientId);

        if (existingCart != null) {
            existingCart.getGuitars().add(guitar);
            existingCart.getPianos().add(piano);
            existingCart.getDrums().add(drums);
            updateCart(existingCart);
        } else {
            Cart newCart = new Cart();
            newCart.setClientId(clientId);
            newCart.getGuitars().add(guitar);
            newCart.getPianos().add(piano);
            newCart.getDrums().add(drums);
            insertCart(newCart);
        }
    }

    @Override
    public Cart getCartByClientId(int clientId) {
        Cart cart = null;
        String query = "SELECT * FROM cart WHERE idclient = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, clientId);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                cart = new Cart();
                cart.setId(resultSet.getInt("idcart"));
                cart.setClientId(clientId);

                GuitarRepository guitarRepository = new GuitarRepositoryI(connection);
                PianoRepository pianoRepository = new PianoRepositoryI(connection);
                DrumsRepository drumsRepository = new DrumsRepositoryI(connection);
                int guitarId = resultSet.getInt("idguitar");
                if (guitarId != 0) {
                    Guitar guitar = guitarRepository.getGuitarById(guitarId);
                    cart.addGuitar(guitar);
                }

                int pianoId = resultSet.getInt("idpiano");
                if (pianoId != 0) {
                    Piano piano = pianoRepository.getPianoById(pianoId);
                    cart.addPiano(piano);
                }

                int drumsId = resultSet.getInt("iddrums");
                if (drumsId != 0) {
                    Drums drums = drumsRepository.getDrumsById(drumsId);
                    cart.addDrums(drums);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cart;
    }

    @Override
    public void clearCartByClientId(int clientId) {
        String query = "DELETE FROM cart WHERE idclient = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, clientId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void insertCart(Cart cart) {
        String query = "INSERT INTO cart (idclient, idguitar, idpiano, iddrums) VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, cart.getClientId());
            int guitarId = cart.getGuitars().isEmpty() ? 0 : cart.getGuitars().get(0).getId();
            statement.setInt(2, guitarId);
            int pianoId = cart.getPianos().isEmpty() ? 0 : cart.getPianos().get(0).getId();
            statement.setInt(3, pianoId);
            int drumsId = cart.getDrums().isEmpty() ? 0 : cart.getDrums().get(0).getId();
            statement.setInt(4, drumsId);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateCart(Cart cart) {
        String query = "UPDATE cart SET idguitar = ?, idpiano = ?, iddrums = ? WHERE idclient = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            int guitarId = cart.getGuitars().isEmpty() ? 0 : cart.getGuitars().get(0).getId();
            statement.setInt(1, guitarId);
            int pianoId = cart.getPianos().isEmpty() ? 0 : cart.getPianos().get(0).getId();
            statement.setInt(2, pianoId);
            int drumsId = cart.getDrums().isEmpty() ? 0 : cart.getDrums().get(0).getId();
            statement.setInt(3, drumsId);
            statement.setInt(4, cart.getClientId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

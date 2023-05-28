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

import java.util.ArrayList;

public class CartRepositoryI implements CartRepository {
    private Connection connection;

    public CartRepositoryI(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void addToCart(int clientId, Guitar guitar) {
        Cart existingCart = getCartByClientId(clientId);

        System.out.println("clientid" + clientId);
        System.out.println("guitar" + guitar);

        if (existingCart != null) {
            if (existingCart.getGuitars() == null) {
                existingCart.setGuitars(new ArrayList<>());
            }
            existingCart.getGuitars().add(guitar);
            updateCart(existingCart);
        } else {
            Cart newCart = new Cart();
            newCart.setClientId(clientId);
            newCart.setGuitars(new ArrayList<>());
            newCart.getGuitars().add(guitar);
            insertCart(newCart);
        }
    }

    @Override
    public void addToCart(int clientId, Piano piano) {
        Cart existingCart = getCartByClientId(clientId);

        if (existingCart != null) {

            existingCart.getPianos().add(piano);
            updateCart(existingCart);
        } else {
            Cart newCart = new Cart();
            newCart.setClientId(clientId);
            newCart.getPianos().add(piano);
            insertCart(newCart);
        }
    }

    @Override
    public void addToCart(int clientId, Drums drums) {
        Cart existingCart = getCartByClientId(clientId);

        if (existingCart != null) {
            existingCart.getDrums().add(drums);
            updateCart(existingCart);
        } else {
            Cart newCart = new Cart();
            newCart.setClientId(clientId);
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

            Integer guitarId = cart.getGuitars().isEmpty() ? null : cart.getGuitars().get(0).getId();
            Integer pianoId = cart.getPianos().isEmpty() ? null : cart.getPianos().get(0).getId();
            Integer drumsId = cart.getDrums().isEmpty() ? null : cart.getDrums().get(0).getId();

            if (guitarId != null) {
                statement.setInt(2, guitarId);
            } else {
                statement.setNull(2, java.sql.Types.INTEGER);
            }

            if (pianoId != null) {
                statement.setInt(3, pianoId);
            } else {
                statement.setNull(3, java.sql.Types.INTEGER);
            }

            if (drumsId != null) {
                statement.setInt(4, drumsId);
            } else {
                statement.setNull(4, java.sql.Types.INTEGER);
            }

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateCart(Cart cart) {
        String query = "UPDATE cart SET idguitar = ?, idpiano = ?, iddrums = ? WHERE idclient = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            Integer guitarId = cart.getGuitars().isEmpty() ? null : cart.getGuitars().get(0).getId();
            Integer pianoId = cart.getPianos().isEmpty() ? null : cart.getPianos().get(0).getId();
            Integer drumsId = cart.getDrums().isEmpty() ? null : cart.getDrums().get(0).getId();

            if (guitarId != null) {
                statement.setInt(1, guitarId);
            } else {
                statement.setNull(1, java.sql.Types.INTEGER);
            }

            if (pianoId != null) {
                statement.setInt(2, pianoId);
            } else {
                statement.setNull(2, java.sql.Types.INTEGER);
            }

            if (drumsId != null) {
                statement.setInt(3, drumsId);
            } else {
                statement.setNull(3, java.sql.Types.INTEGER);
            }

            statement.setInt(4, cart.getClientId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

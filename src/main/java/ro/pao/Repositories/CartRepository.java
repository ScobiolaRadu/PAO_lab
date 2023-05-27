package ro.pao.Repositories;

import ro.pao.Models.Cart;
import ro.pao.Models.Drums;
import ro.pao.Models.Guitar;
import ro.pao.Models.Piano;

public interface CartRepository {
    void addToCart(int clientId, Guitar guitar, Piano piano, Drums drums);

    Cart getCartByClientId(int clientId);

    void clearCartByClientId(int clientId);
}

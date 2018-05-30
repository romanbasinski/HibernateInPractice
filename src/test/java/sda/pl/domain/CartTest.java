package sda.pl.domain;

import org.junit.Test;
import sda.pl.core.ShopException;
import sda.pl.repository.OrderRepository;
import sda.pl.repository.ProductRepository;
import sda.pl.repository.UserRepository;

import java.util.HashSet;

import static org.junit.Assert.*;

public class CartTest {

    @Test
    public void createNewOrder() {

        //given
        Cart cart = new Cart();
        UserRepository.findUser(1L).ifPresent(u -> cart.setUser(u));
        ProductRepository.findProduct(10L).ifPresent(p -> cart.addProductToCart(p, 5L));
        Order newOrder = null;
        try {
            newOrder = cart.createNewOrder();
        } catch (ShopException e) {
            e.printStackTrace();
        }
        OrderRepository.saveOrder(newOrder);


    }
}
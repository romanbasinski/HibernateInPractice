package sda.pl.repository;

import org.junit.Assert;
import sda.pl.Product;

import java.util.Optional;

import static org.junit.Assert.*;

public class ProductRepositoryTest {

    @org.junit.Test
    public void findProduct() {

        Optional<Product> product = ProductRepository.findProduct(2l);

        Assert.assertTrue(product.get().getProductImage().getImage() != null);

    }
}
package sda.pl;

import org.junit.Test;
import sda.pl.domain.Product;
import sda.pl.domain.WarehouseName;
import sda.pl.repository.ProductRepository;

import java.math.BigDecimal;
import java.util.Optional;

public class ProductTest {

    @Test
    public  void addStock() {

        Optional<Product> product = ProductRepository.findProduct(2L);
        product.ifPresent(p -> {
            p.addStock(WarehouseName.MAIN, BigDecimal.ONE);
            ProductRepository.saveOrUpdateProduct(p);

        });
    }
}

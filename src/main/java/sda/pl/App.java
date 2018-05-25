package sda.pl;

import org.hibernate.Session;
import sda.pl.repository.ProductRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class App {

    public static void main(String[] args){

        Product maslo = Product.builder()
                .name("Maslo")
                .color(Color.WHITE)
                .price(Price.builder()
                        .priceGross(new BigDecimal("7.5"))
                        .priceNet(new BigDecimal("5.25"))
                        .priceSymbol("PLN").build()).build();

        ProductRepository.saveProduct(maslo);

        Optional<Product> product = ProductRepository.findProduct(2L);
        product.ifPresent(e -> System.out.println(e.getName()));

        ProductRepository.findAll().forEach(p -> System.out.println(p.getId() +" "+p.getName()));

    }
}

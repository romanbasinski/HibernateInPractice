package sda.pl;

import sda.pl.domain.Product;
import sda.pl.repository.ProductRepository;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

//        System.out.println(DateTime.now());

//        List<Product> all = ProductRepository.findAll();
//
//        all.stream().forEach(product -> System.out.println(product.getName() + product.getId()));

        System.out.println(ZonedDateTime.now());

    }
}

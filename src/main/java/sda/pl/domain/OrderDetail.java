package sda.pl.domain;

import lombok.Data;
import sda.pl.Price;
import sda.pl.Product;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
public class OrderDetail implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn
    Product product;
    @ManyToOne
    @JoinColumn
    Order order;
    Long amount;
    Price price;

}

package sda.pl.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sda.pl.Price;
import sda.pl.Product;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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

    public OrderDetail(CartDetail cartDetail) {
        this.product = cartDetail.getProduct();
        this.amount = cartDetail.getAmount();
        this.price = cartDetail.price;
    }
}

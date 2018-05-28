package sda.pl;

import lombok.*;
import sda.pl.domain.CartDetail;
import sda.pl.domain.OrderDetail;
import sda.pl.domain.ProductImage;
import sda.pl.domain.ProductRating;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"orderDetailSet", "cartDetailSet", "productImage", "productRatingSet"})
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //baza danych sama generuje id
    private Long id;

    String name;

    @Embedded
    Price price;

    @Enumerated(EnumType.STRING) //Zapisuje Enuma w postaci stringa
    Color color;

    @OneToOne(mappedBy = "product")
    ProductImage productImage;

//    @Enumerated(EnumType.STRING) //tu zapisuje w postaci INT - numer koloru
//    Color color;

    @OneToMany(mappedBy = "product")
    Set<OrderDetail> orderDetailSet;

    @OneToMany(mappedBy = "product")
    Set<CartDetail> cartDetailSet;

    @OneToMany(mappedBy = "product")
    Set<ProductRating> productRatingSet;

}

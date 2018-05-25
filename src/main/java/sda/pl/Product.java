package sda.pl;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sda.pl.domain.OrderDetail;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //baza danych sama generuje id
    private Long id;

    String name;

    @Embedded
    Price price;

    @Enumerated(EnumType.STRING) //Zapisuje Enuma w postaci stringa
    Color color;

//    @Enumerated(EnumType.STRING) //tu zapisuje w postaci INT - numer koloru
//    Color color;

    @OneToMany(mappedBy = "product")
    Set<OrderDetail> orderDetailSet;

}

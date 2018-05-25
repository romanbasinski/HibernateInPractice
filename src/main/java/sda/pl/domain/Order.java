package sda.pl.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sda.pl.Price;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "orders")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order implements Serializable{

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY) //baza danych sama generuje id
        private Long id;

        LocalDate date;
        Price totalPrice;
        String email;

        @Column(name = "adress_wysylki")
        String cityName;

        boolean RODO;

        @OneToMany(mappedBy = "product")
        Set<OrderDetail> orderDetailSet;
}

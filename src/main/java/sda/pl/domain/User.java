package sda.pl.domain;


import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"orderSet", "cartSet", "productRatingSet"})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String firstName;
    String lastName;
    @Column(unique = true)
    String email;
    String zipCode;
    String cityName;
    String street;
    String pasword;

    @OneToMany(mappedBy = "user")
    Set<Order> orderSet;

    @OneToMany(mappedBy = "user")
    Set<Cart> cartSet;

    @OneToMany(mappedBy = "user")
    Set<ProductRating> productRatingSet;


}

package sda.pl.domain;


import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"orderSet", "cart", "productRatingSet", "advertisingBannerSet"})
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

    @OneToOne(mappedBy = "user")
    Cart cart;

    @OneToMany(mappedBy = "user")
    Set<ProductRating> productRatingSet;

    @Transient
    BigDecimal totalOrderPrice;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "advertisement_for_the_user",
            joinColumns = @JoinColumn(name = "advertisement_banner_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    Set<AdvertisingBanner> advertisingBannerSet;

    public User(Long id, String email, BigDecimal totalOrderPrice){
        this.id = id;
        this.email = email;
        this.totalOrderPrice = totalOrderPrice;
    }

    public Cart createCart() {
        Cart cart = new Cart();
        cart.setUser(this);
        return cart;
    }

    public ProductRating rateProduct (int rate, String description, Product product) {
        ProductRating productRating = new ProductRating();
        productRating.setActive(false);
        productRating.setRate(rate);
        productRating.setDescription(description);
        productRating.setProduct(product);
        return productRating;
    }


}

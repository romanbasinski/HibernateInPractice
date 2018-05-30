package sda.pl.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"orderDetailSet", "cartDetailSet", "productImage", "productRatingSet", "stockSet"})
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

    @OneToMany (mappedBy = "product" , cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    Set<Stock> stockSet;

    public void addStock(WarehouseName name, BigDecimal amount) {
        if(stockSet == null) {
            stockSet = new HashSet<>();
        }
        Optional<Stock> stockExist = stockSet.stream().filter(s -> s.getWarehouseName().equals(name)).findFirst();

        if (!stockExist.isPresent()) {
            Stock stock = new Stock();
            stock.setProduct(this);
            stock.setWarehouseName(name);
            stock.setAmount(amount);
            stockSet.add(stock);

        } else {
            stockExist.ifPresent(s -> {
                s.setAmount(s.getAmount().add(amount));
            });
        }
    }


    public long getSumStockForSale() {
        return getStockSet().stream().filter(stock -> !stock.getWarehouseName().equals(WarehouseName.COMPLAINT))
                .mapToLong(s -> s.getAmount().longValue()).sum();
    }

    public void addProductRating(ProductRating productRating) {
        if (productRatingSet == null) {
            productRatingSet = new HashSet<>();
        }
        productRating.setProduct(this);
        productRatingSet.add(productRating);
    }

}

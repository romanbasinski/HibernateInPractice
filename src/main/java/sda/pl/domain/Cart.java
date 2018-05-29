package sda.pl.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sda.pl.Product;
import sda.pl.repository.OrderRepository;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;


    @ManyToOne
    @JoinColumn
    User user;

    @OneToMany(mappedBy = "cart")
    Set<CartDetail> cartDetailSet;

    public void addProductToCart (Product product, Long amount) {
        if (cartDetailSet == null) {
            cartDetailSet = new HashSet<>();
        }

        Optional<CartDetail> first = cartDetailSet.stream().filter(cd -> cd.getProduct().getId().equals(product.getId())).findFirst();
        if (!first.isPresent()) {
            CartDetail build = CartDetail.builder()
                    .amount(amount)
                    .price(product.getPrice())
                    .cart(this)
                    .product(product).build();
        } else {
            first.ifPresent(cd -> cd.setAmount(cd.getAmount() + amount));
        }

    }

    public void subtractProductInCart(Product product) {
        if (cartDetailSet == null) {
            return;
        }

        Optional<CartDetail> productInCart = cartDetailSet.stream().filter(cd -> cd.getProduct().getId().equals(product.getId())).findFirst();
        productInCart.ifPresent(cd -> {
            if (cd.getAmount() > 0) {
                cd.setAmount(cd.getAmount() - 1);
            } else {
                cd.setAmount(0L);
            }
        });
    }

    public void changeProductAmount (Product product, Long newAmount) {
        if (cartDetailSet == null) {
            return;
        }

        Optional<CartDetail> productInCart = cartDetailSet.stream().filter(cd -> cd.getProduct().getId().equals(product.getId())).findFirst();
        productInCart.ifPresent(cd -> {
            if (newAmount > 0) {
                cd.setAmount(newAmount);
            } else {
                cd.setAmount(0L);
            }
        });
    }

    public void createNewOrder() {
        Set<OrderDetail> orderDetailSet = new HashSet<>();

        Order order = Order.builder()
                .user(this.user)
                .date(LocalDateTime.now())
                .build();
        for (CartDetail position : cartDetailSet) {
            OrderDetail orderDetail = new OrderDetail(position);

//            OrderDetail orderDetail = OrderDetail.builder()
//                    .product(position.getProduct())
//                    .order(order)
//                    .amount(position.getAmount())
//                    .price(position.getPrice())
//                    .build();
            order.addOrderDetail(orderDetail);
        }
        order.calculateTotalPrice();
        OrderRepository.saveOrder(order);
    }
}

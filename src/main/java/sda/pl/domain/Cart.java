package sda.pl.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sda.pl.core.ShopException;

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


    @OneToOne
    @JoinColumn
    User user;

    @OneToMany(mappedBy = "cart")
    Set<CartDetail> cartDetailSet;

    @Transient
    boolean valid;

    public void addProductToCart(Product product, Long amount) {
        if (cartDetailSet == null) {
            cartDetailSet = new HashSet<>();
        }

        Optional<CartDetail> first = cartDetailSet.stream().filter(cd -> cd.getProduct().getId().equals(product.getId())).findFirst();
        long sum = product.getSumStockForSale();

        if (!first.isPresent()) {
            if (amount > sum) {
                amount = sum;
            }

            CartDetail build = CartDetail.builder()
                    .amount(amount)
                    .price(product.getPrice())
                    .cart(this)
                    .product(product).build();
            cartDetailSet.add(build);
        } else {

            CartDetail cd = first.get();

            if (cd.getAmount() + amount > sum) {
                amount = sum - cd.getAmount();
            }
            cd.setAmount(cd.getAmount() + amount);
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

    public void changeProductAmount(Product product, Long newAmount) {
        if (cartDetailSet == null) {
            return;
        }

        long sum = product.getSumStockForSale();

        Optional<CartDetail> productInCart = cartDetailSet.stream().filter(cd -> cd.getProduct().getId().equals(product.getId())).findFirst();
        productInCart.ifPresent(cd -> {
            if (newAmount > 0) {
                if (newAmount > sum) {
                    cd.setAmount(sum);
                } else {
                    cd.setAmount(newAmount);
                }

            } else {
                cd.setAmount(0L);
            }
        });
    }

    public void cheskIsValid() {
        setValid(true);

        getCartDetailSet().forEach(cd -> {
            long sumStockForSale = cd.getProduct().getSumStockForSale();
            if (sumStockForSale < cd.getAmount()) {
                setValid(false);
            }
        });
    }

    public Order createNewOrder() throws ShopException {
        cheskIsValid();
        if (!valid) {
            throw new ShopException("Brak czesci produktow na stanie magazynowym");
        }


//        Set<OrderDetail> orderDetailSet = new HashSet<>();
//
//        Order order = Order.builder()
//                .user(this.user)
//                .date(LocalDateTime.now())
//                .build();
//        for (CartDetail position : cartDetailSet) {
//            OrderDetail orderDetail = new OrderDetail(position);
//
////            OrderDetail orderDetail = OrderDetail.builder()
////                    .product(position.getProduct())
////                    .order(order)
////                    .amount(position.getAmount())
////                    .price(position.getPrice())
////                    .build();
//            order.addOrderDetail(orderDetail);
//        }
//        order.calculateTotalPrice();
//        OrderRepository.saveOrder(order);

        Order order = new Order();
        order.setDate(LocalDateTime.now());
        order.setRODO(true);
        order.setUser(this.getUser());
        order.setCityName(this.getUser().getCityName());
        getCartDetailSet().forEach(cd -> order.addOrderDetail(new OrderDetail(cd)));
        order.calculateTotalPrice();

        return order;

    }
}

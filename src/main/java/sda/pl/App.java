package sda.pl;

import org.hibernate.Session;
import sda.pl.domain.Order;
import sda.pl.domain.OrderDetail;
import sda.pl.repository.OrderRepository;
import sda.pl.repository.ProductRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class App {

    public static void main(String[] args){

        Product maslo = Product.builder()
                .name("Maslo")
                .color(Color.WHITE)
                .price(Price.builder()
                        .priceGross(new BigDecimal("6.5"))
                        .priceNet(new BigDecimal("4.25"))
                        .priceSymbol("PLN").build()).build();

        ProductRepository.saveProduct(maslo);

        Optional<Product> product = ProductRepository.findProduct(2L);
        product.ifPresent(e -> System.out.println(e.getName()));

        ProductRepository.findAll().forEach(p -> System.out.println(p.getId() +" "+p.getName()));

        ProductRepository.findAllWithPriceNetLessThan(new BigDecimal("5")).forEach(p -> System.out.println("Cena mniejsza niż 5 " + p.getName()));

        Long sum = ProductRepository.countAll();
        System.out.println("Suma: " + sum);

        Optional<Product> product1 = ProductRepository.findProduct(9L);

        if (product1.isPresent()) {
            Product product10 = product1.get();
            product10.setName("Kefir");
            product10.setPrice(Price.builder()
            .priceNet(new BigDecimal("20"))
            .priceGross(new BigDecimal("25"))
            .priceSymbol("PLN").build());

            Order kowalskiOrder = Order.builder()
                    .date(LocalDateTime.now())
//                    .email("kowalski@gmail.com")
                    .RODO(true)
                    .cityName("Poznan")
                    .totalPrice(new Price())
                    .build();

            OrderDetail detail = OrderDetail.builder()
                    .amount(5l)
                    .product(product10)
                    .price(product10.getPrice()).build();


            ProductRepository.saveOrUpdateProduct(product10);

            kowalskiOrder.addOrderDetail(detail);

            double sum1 = kowalskiOrder.getOrderDetailSet().stream()
                    .mapToDouble(cd -> cd.getPrice().getPriceGross()
                            .multiply(new BigDecimal(cd.getAmount())).doubleValue())
                    .sum();

//            kowalskiOrder.getTotalPrice().setPriceGross(BigDecimal.ZERO);
//            kowalskiOrder.getTotalPrice().setPriceNet(BigDecimal.ZERO);
//            kowalskiOrder.getOrderDetailSet().forEach(  //TODO przeanalizowac lambdy
//                    cd->
//                    {
//                        kowalskiOrder.getTotalPrice().setPriceGross(kowalskiOrder.getTotalPrice().getPriceGross()
//                                .add(
//                                        cd.getPrice().getPriceGross().multiply(new BigDecimal(cd.getAmount()))
//                                )
//                        );
//                        kowalskiOrder.getTotalPrice().setPriceNet(kowalskiOrder.getTotalPrice().getPriceGross()
//                                .add(
//                                        cd.getPrice().getPriceGross().multiply(new BigDecimal(cd.getAmount()))
//                                )
//                        );
//
//                    });
//
////            kowalskiOrder.getOrderDetailSet().forEach( // przed połączeniem lambd
////                    cd-> kowalskiOrder.getTotalPrice().setPriceNet(kowalskiOrder.getTotalPrice().getPriceGross()
////                            .add(
////                                    cd.getPrice().getPriceGross().multiply(new BigDecimal(cd.getAmount()))
////                            )
////                    )
////            );

//            kowalskiOrder.getTotalPrice().setPriceSymbol("PLN");

            kowalskiOrder.calculateTotalPrice();

            OrderRepository.saveOrder(kowalskiOrder);

            OrderRepository.findAll().forEach(o -> o.getOrderDetailSet()
                    .forEach(od -> System.out.println(od.getProduct().getName()))); //domyślnie nie pobiera kolekcji z klasy dlatego trzeba zmodyfikowac Set w Order, lub zapytanie do bazy

            OrderRepository.findAllWithProductName("KEFIR").forEach(o -> o.getOrderDetailSet()
            .forEach(od -> System.out.println("zamowienie z kefirem " + od.getProduct().getName())));

        }





    }
}

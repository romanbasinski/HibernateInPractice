package sda.pl.web;

import sda.pl.domain.Cart;
import sda.pl.domain.Price;
import sda.pl.domain.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.HashSet;

@WebServlet(name = "AddProductToCartServlet", urlPatterns = "/addProductToCart")
public class AddProductToCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        long productAmount = Long.parseLong(request.getParameter("productAmount"));
        long productId = Long.parseLong(request.getParameter("productId"));

        Cart cart = new Cart();
        Product product = new Product();
        Price price = Price.builder()
                .priceGross(BigDecimal.ONE)
                .priceNet(BigDecimal.ONE).build();
        product.setPrice(price);

        product.setStockSet(new HashSet<>());

        cart.addProductToCart(product, productAmount);

        PrintWriter writer = response.getWriter();
        writer.write("productAmount " + productAmount);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

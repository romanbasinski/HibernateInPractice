package sda.pl.web;

import sda.pl.domain.Product;
import sda.pl.repository.ProductRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "HelloWorldServlet", urlPatterns = "/hello")
public class HelloWorldServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String firstName = request.getParameter("firstName");

        List<Product> all = new ArrayList<>();
        Product product1 = Product.builder().id(1L).name("maslo").build();
        Product product2 = Product.builder().id(2L).name("bulaka").build();
        Product product3 = Product.builder().id(3L).name("margaryna").build();
        Product product4 = Product.builder().id(4L).name("maslanka").build();
        Product product5 = Product.builder().id(5L).name("nozyczki").build();
        all.add(product1);
        all.add(product2);
        all.add(product3);
        all.add(product4);
        all.add(product5);


        PrintWriter writer = response.getWriter();
        writer.write("<html><head></head><body><h1>Hello World! "+firstName+" !!!</h1>");

        writer.write("<table><tr><td>Nazwa</td><td>Id</td></tr>");

        for (Product p : all) {
            writer.write("<tr><td>"+p.getName()+"</td><td>"+p.getId()+"</td></tr>");
        }

        writer.write("</body></html>");

    }
}

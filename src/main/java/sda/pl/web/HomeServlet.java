package sda.pl.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HomeServlet", urlPatterns = "/")
public class HomeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();

        writer.write("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "\n" +
                "  <head>\n" +
                "\n" +
                "    <meta charset=\"utf-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n" +
                "    <meta name=\"description\" content=\"\">\n" +
                "    <meta name=\"author\" content=\"\">\n" +
                "\n" +
                "    <title>Shop Homepage - Start Bootstrap Template</title>\n" +
                "\n" +
                "    <!-- Bootstrap core CSS -->\n" +
                "    <link href=\"vendor/bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\">\n" +
                "\n" +
                "    <!-- Custom styles for this template -->\n" +
                "    <link href=\"css/shop-homepage.css\" rel=\"stylesheet\">\n" +
                "\n" +
                "  </head>\n" +
                "\n" +
                "  <body>\n" +
                "\n" +
                "    <!-- Navigation -->\n" +
                "    <nav class=\"navbar navbar-expand-lg navbar-dark bg-dark fixed-top\">\n" +
                "      <div class=\"container\">\n" +
                "        <a class=\"navbar-brand\" href=\"#\">Start Bootstrap</a>\n" +
                "        <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarResponsive\" aria-controls=\"navbarResponsive\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n" +
                "          <span class=\"navbar-toggler-icon\"></span>\n" +
                "        </button>\n" +
                "        <div class=\"collapse navbar-collapse\" id=\"navbarResponsive\">\n" +
                "          <ul class=\"navbar-nav ml-auto\">\n" +
                "            <li class=\"nav-item active\">\n" +
                "              <a class=\"nav-link\" href=\"#\">Home\n" +
                "                <span class=\"sr-only\">(current)</span>\n" +
                "              </a>\n" +
                "            </li>\n" +
                "            <li class=\"nav-item\">\n" +
                "              <a class=\"nav-link\" href=\"#\">About</a>\n" +
                "            </li>\n" +
                "            <li class=\"nav-item\">\n" +
                "              <a class=\"nav-link\" href=\"#\">Services</a>\n" +
                "            </li>\n" +
                "            <li class=\"nav-item\">\n" +
                "              <a class=\"nav-link\" href=\"#\">Contact</a>\n" +
                "            </li>\n" +
                "          </ul>\n" +
                "        </div>\n" +
                "      </div>\n" +
                "    </nav>\n" +
                "\n" +
                "    <!-- Page Content -->\n" +
                "    <div class=\"container\">\n" +
                "\n" +
                "      <div class=\"row\">\n" +
                "\n" +
                "        <div class=\"col-lg-3\">\n" +
                "\n" +
                "          <h1 class=\"my-4\">Shop Name</h1>\n" +
                "          <div class=\"list-group\">\n" +
                "            <a href=\"#\" class=\"list-group-item\">Category 1</a>\n" +
                "            <a href=\"#\" class=\"list-group-item\">Category 2</a>\n" +
                "            <a href=\"#\" class=\"list-group-item\">Category 3</a>\n" +
                "          </div>\n" +
                "\n" +
                "        </div>\n" +
                "        <!-- /.col-lg-3 -->\n" +
                "\n" +
                "        <div class=\"col-lg-9\">\n" +
                "\n" +
                "          <div id=\"carouselExampleIndicators\" class=\"carousel slide my-4\" data-ride=\"carousel\">\n" +
                "            <ol class=\"carousel-indicators\">\n" +
                "              <li data-target=\"#carouselExampleIndicators\" data-slide-to=\"0\" class=\"active\"></li>\n" +
                "              <li data-target=\"#carouselExampleIndicators\" data-slide-to=\"1\"></li>\n" +
                "              <li data-target=\"#carouselExampleIndicators\" data-slide-to=\"2\"></li>\n" +
                "            </ol>\n" +
                "            <div class=\"carousel-inner\" role=\"listbox\">\n" +
                "              <div class=\"carousel-item active\">\n" +
                "                <img class=\"d-block img-fluid\" src=\"http://placehold.it/900x350\" alt=\"First slide\">\n" +
                "              </div>\n" +
                "              <div class=\"carousel-item\">\n" +
                "                <img class=\"d-block img-fluid\" src=\"http://placehold.it/900x350\" alt=\"Second slide\">\n" +
                "              </div>\n" +
                "              <div class=\"carousel-item\">\n" +
                "                <img class=\"d-block img-fluid\" src=\"http://placehold.it/900x350\" alt=\"Third slide\">\n" +
                "              </div>\n" +
                "            </div>\n" +
                "            <a class=\"carousel-control-prev\" href=\"#carouselExampleIndicators\" role=\"button\" data-slide=\"prev\">\n" +
                "              <span class=\"carousel-control-prev-icon\" aria-hidden=\"true\"></span>\n" +
                "              <span class=\"sr-only\">Previous</span>\n" +
                "            </a>\n" +
                "            <a class=\"carousel-control-next\" href=\"#carouselExampleIndicators\" role=\"button\" data-slide=\"next\">\n" +
                "              <span class=\"carousel-control-next-icon\" aria-hidden=\"true\"></span>\n" +
                "              <span class=\"sr-only\">Next</span>\n" +
                "            </a>\n" +
                "          </div>\n" +
                "\n" +
                "          <div class=\"row\">\n" +
                "\n" +
                "            <div class=\"col-lg-4 col-md-6 mb-4\">\n" +
                "              <div class=\"card h-100\">\n" +
                "                <a href=\"#\"><img class=\"card-img-top\" src=\"http://placehold.it/700x400\" alt=\"\"></a>\n" +
                "                <div class=\"card-body\">\n" +
                "                  <h4 class=\"card-title\">\n" +
                "                    <a href=\"#\">Item One</a>\n" +
                "                  </h4>\n" +
                "                  <h5>$24.99</h5>\n" +
                "                  <p class=\"card-text\">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet numquam aspernatur!</p>\n" +
                "                </div>\n" +
                "                <div class=\"card-footer\">\n" +
                "                  <small class=\"text-muted\">&#9733; &#9733; &#9733; &#9733; &#9734;</small>\n" +
                "                </div>\n" +
                "              </div>\n" +
                "            </div>\n" +
                "\n" +
                "            <div class=\"col-lg-4 col-md-6 mb-4\">\n" +
                "              <div class=\"card h-100\">\n" +
                "                <a href=\"#\"><img class=\"card-img-top\" src=\"http://placehold.it/700x400\" alt=\"\"></a>\n" +
                "                <div class=\"card-body\">\n" +
                "                  <h4 class=\"card-title\">\n" +
                "                    <a href=\"#\">Item Two</a>\n" +
                "                  </h4>\n" +
                "                  <h5>$24.99</h5>\n" +
                "                  <p class=\"card-text\">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet numquam aspernatur! Lorem ipsum dolor sit amet.</p>\n" +
                "                </div>\n" +
                "                <div class=\"card-footer\">\n" +
                "                  <small class=\"text-muted\">&#9733; &#9733; &#9733; &#9733; &#9734;</small>\n" +
                "                </div>\n" +
                "              </div>\n" +
                "            </div>\n" +
                "\n" +
                "            <div class=\"col-lg-4 col-md-6 mb-4\">\n" +
                "              <div class=\"card h-100\">\n" +
                "                <a href=\"#\"><img class=\"card-img-top\" src=\"http://placehold.it/700x400\" alt=\"\"></a>\n" +
                "                <div class=\"card-body\">\n" +
                "                  <h4 class=\"card-title\">\n" +
                "                    <a href=\"#\">Item Three</a>\n" +
                "                  </h4>\n" +
                "                  <h5>$24.99</h5>\n" +
                "                  <p class=\"card-text\">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet numquam aspernatur!</p>\n" +
                "                </div>\n" +
                "                <div class=\"card-footer\">\n" +
                "                  <small class=\"text-muted\">&#9733; &#9733; &#9733; &#9733; &#9734;</small>\n" +
                "                </div>\n" +
                "              </div>\n" +
                "            </div>\n" +
                "\n" +
                "            <div class=\"col-lg-4 col-md-6 mb-4\">\n" +
                "              <div class=\"card h-100\">\n" +
                "                <a href=\"#\"><img class=\"card-img-top\" src=\"http://placehold.it/700x400\" alt=\"\"></a>\n" +
                "                <div class=\"card-body\">\n" +
                "                  <h4 class=\"card-title\">\n" +
                "                    <a href=\"#\">Item Four</a>\n" +
                "                  </h4>\n" +
                "                  <h5>$24.99</h5>\n" +
                "                  <p class=\"card-text\">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet numquam aspernatur!</p>\n" +
                "                </div>\n" +
                "                <div class=\"card-footer\">\n" +
                "                  <small class=\"text-muted\">&#9733; &#9733; &#9733; &#9733; &#9734;</small>\n" +
                "                </div>\n" +
                "              </div>\n" +
                "            </div>\n" +
                "\n" +
                "            <div class=\"col-lg-4 col-md-6 mb-4\">\n" +
                "              <div class=\"card h-100\">\n" +
                "                <a href=\"#\"><img class=\"card-img-top\" src=\"http://placehold.it/700x400\" alt=\"\"></a>\n" +
                "                <div class=\"card-body\">\n" +
                "                  <h4 class=\"card-title\">\n" +
                "                    <a href=\"#\">Item Five</a>\n" +
                "                  </h4>\n" +
                "                  <h5>$24.99</h5>\n" +
                "                  <p class=\"card-text\">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet numquam aspernatur! Lorem ipsum dolor sit amet.</p>\n" +
                "                </div>\n" +
                "                <div class=\"card-footer\">\n" +
                "                  <small class=\"text-muted\">&#9733; &#9733; &#9733; &#9733; &#9734;</small>\n" +
                "                </div>\n" +
                "              </div>\n" +
                "            </div>\n" +
                "\n" +
                "            <div class=\"col-lg-4 col-md-6 mb-4\">\n" +
                "              <div class=\"card h-100\">\n" +
                "                <a href=\"#\"><img class=\"card-img-top\" src=\"http://placehold.it/700x400\" alt=\"\"></a>\n" +
                "                <div class=\"card-body\">\n" +
                "                  <h4 class=\"card-title\">\n" +
                "                    <a href=\"#\">Item Six</a>\n" +
                "                  </h4>\n" +
                "                  <h5>$24.99</h5>\n" +
                "                  <p class=\"card-text\">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet numquam aspernatur!</p>\n" +
                "                </div>\n" +
                "                <div class=\"card-footer\">\n" +
                "                  <small class=\"text-muted\">&#9733; &#9733; &#9733; &#9733; &#9734;</small>\n" +
                "                </div>\n" +
                "              </div>\n" +
                "            </div>\n" +
                "\n" +
                "          </div>\n" +
                "          <!-- /.row -->\n" +
                "\n" +
                "        </div>\n" +
                "        <!-- /.col-lg-9 -->\n" +
                "\n" +
                "      </div>\n" +
                "      <!-- /.row -->\n" +
                "\n" +
                "    </div>\n" +
                "    <!-- /.container -->\n" +
                "\n" +
                "    <!-- Footer -->\n" +
                "    <footer class=\"py-5 bg-dark\">\n" +
                "      <div class=\"container\">\n" +
                "        <p class=\"m-0 text-center text-white\">Copyright &copy; Your Website 2017</p>\n" +
                "      </div>\n" +
                "      <!-- /.container -->\n" +
                "    </footer>\n" +
                "\n" +
                "    <!-- Bootstrap core JavaScript -->\n" +
                "    <script src=\"vendor/jquery/jquery.min.js\"></script>\n" +
                "    <script src=\"vendor/bootstrap/js/bootstrap.bundle.min.js\"></script>\n" +
                "\n" +
                "  </body>\n" +
                "\n" +
                "</html>\n");
    }
}

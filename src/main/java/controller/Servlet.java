package controller;

import model.Product;
import service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Servlet", value = "/product")
public class Servlet extends HttpServlet {
    ProductService productService = new ProductService();
    Product product = new Product();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateFrom(request, response);
                break;
            case "edit":
                showEditFrom(request, response);
                break;
            case "delete":
                deleteProduct(request, response);
                break;
            default:
                showProduct(request, response);
                break;
        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("productId"));
        productService.deleteProduct(id);
        List<Product> list = productService.showListProduct();
        request.setAttribute("listP", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/list.jsp");
        dispatcher.forward(request, response);

    }

    private void showEditFrom(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("productId"));
        Product product = productService.findById(id);
        RequestDispatcher dispatcher;
        if (product == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("product", product);
            dispatcher = request.getRequestDispatcher("product/edit.jsp");
        }
        dispatcher.forward(request, response);
    }

    private void showCreateFrom(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/create.jsp");
        dispatcher.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createProduct(request, response);
                break;
            case "edit":
                updateProduct(request, response);
                break;
            case "searchMenu":
                showSearchProduct(request, response);
                break;
            default:
                showProduct(request, response);
                break;
        }

    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String color = request.getParameter("color");
        int typeId = Integer.parseInt(request.getParameter("typeID"));
        int productId = Integer.parseInt(request.getParameter("productId"));
        Product product = new Product(name, price, quantity, color, typeId);
        productService.update(product, productId);
        String message = "Cập nhật thành công";
        request.setAttribute("message", message);
        showProduct(request, response);
    }

    private void showProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> list = productService.showListProduct();
        request.setAttribute("listP", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/list.jsp");
        dispatcher.forward(request, response);
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String color = request.getParameter("color");
        int typeId = Integer.parseInt(request.getParameter("typeID"));
        Product product = new Product(name, price, quantity, color, typeId);
        productService.addProduct(product);
        showProduct(request, response);
    }
    private void showSearchProduct(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String textSearch = request.getParameter("search");
        List<Product> list = productService.searchProduct(textSearch);
        request.setAttribute("listP", list);
        request.getRequestDispatcher("product/list.jsp").forward(request, response);
    }

}

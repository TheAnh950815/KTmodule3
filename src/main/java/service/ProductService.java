package service;

import model.Category;
import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductService {

    public ProductService() {
    }

    Connection connection = DatabaseConnection.getConnection();


    public List<Product> showListProduct() {
        String ALL_PRODUCT = "select product.productID, product.productName, product.price, product.quantity, product.color, product.typeID, category.typeProduct\n" +
                "from  product inner join category  on product.typeID = category.typeID";
        List<Product> productList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ALL_PRODUCT);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int productId = resultSet.getInt("productID");
                String productName = resultSet.getString("productName");
                String price = resultSet.getString("price");
                int quantity = resultSet.getInt("quantity");
                String color = resultSet.getString("color");
                String typeProduct = resultSet.getString("typeProduct");
                productList.add(new Product(productId, productName, price, quantity, color, typeProduct));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return productList;
    }

    public void addProduct(Product product) {
        String addProduct = "insert into product(productName, price,quantity,color,typeID) value (?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(addProduct);
            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setString(2, product.getPrice());
            preparedStatement.setInt(3, product.getQuantity());
            preparedStatement.setString(4, product.getColor());
            preparedStatement.setInt(5, product.getTypeID());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Product findById(int productId) {
        Product product = null;
        Connection connection = DatabaseConnection.getConnection();
        String getProductID = "SELECT * FROM product WHERE productID = ?";
        if (connection != null) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(getProductID);
                preparedStatement.setInt(1, productId);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    String name = resultSet.getString("productName");
                    String price = resultSet.getString("price");
                    int quantity = Integer.parseInt(resultSet.getString("quantity"));
                    String color = resultSet.getString("color");
                    int typeId = Integer.parseInt(resultSet.getString("typeID"));
                    product = new Product(name, price, quantity, color, typeId);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return product;
    }

    public void update(Product product, int productId) {
        Connection connection = DatabaseConnection.getConnection();
        String updateProduct="UPDATE product set productName = ?,  price= ?, quantity=?, color=?, typeID=? where productID= ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateProduct );
            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setString(2, product.getPrice());
            preparedStatement.setInt(3, product.getQuantity());
            preparedStatement.setString(4, product.getColor());
            preparedStatement.setInt(5, product.getTypeID());
            preparedStatement.setInt(6, productId);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
        public void deleteProduct (int productId) {
            String DELETE_PRODUCT = "DELETE FROM product WHERE productId =?";
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCT);
                preparedStatement.setInt(1, productId);
                preparedStatement.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    public List<Product> searchProduct(String text) {
        List<Product> productList = new ArrayList<>();
        String searchProduct = "select product.productID, product.productName, product.price, product.quantity, product.color, product.typeID, category.typeProduct\n" +
                "from  product inner join category  on product.typeID = category.typeID where productName like ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(searchProduct);
            preparedStatement.setString(1, "%"+text+"%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int productId = resultSet.getInt("productID");
                String productName = resultSet.getString("productName");
                String price = resultSet.getString("price");
                int quantity = resultSet.getInt("quantity");
                String color = resultSet.getString("color");
                String typeProduct = resultSet.getString("typeProduct");
                productList.add(new Product(productId, productName, price, quantity, color, typeProduct));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }
  /*  public static void main(String[] args) {
        ProductService productService = new ProductService();
        Product product =new Product("Iphone12","24.000.000", 12,"red", 1);
      productService.addProduct(product);
    }*/
}

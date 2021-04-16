package model;

public class Product {
    int productId;
    String productName;
    String price;
    int quantity;
    String color;
    String typeProduct;
    int typeID;

    public Product() {
    }

    public Product(int productId, String productName, String price, int quantity, String color, String typeProduct) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.typeProduct = typeProduct;
    }

    public Product(String productName, String price, int quantity, String color, String typeProduct, int typeID) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.typeProduct = typeProduct;
        this.typeID = typeID;
    }

    public Product(String productName, String price, int quantity, String color, int typeID) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.typeID = typeID;
    }

    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(String typeProduct) {
        this.typeProduct = typeProduct;
    }
}

package model;

public class Category {
    int typeId;
    String typeProduct;

    public Category() {
    }

    public Category(int typeId, String typeProduct) {
        this.typeId = typeId;
        this.typeProduct = typeProduct;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(String typeProduct) {
        this.typeProduct = typeProduct;
    }
}

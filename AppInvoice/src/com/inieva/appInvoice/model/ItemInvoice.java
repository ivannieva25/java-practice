package com.inieva.appInvoice.model;

import com.inieva.appInvoice.model.Product;

public class ItemInvoice {
    private int quantity;
    private Product product;

    public ItemInvoice(int quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public float calculateImport(){
        return this.quantity * this.product.getPrice();
    }

    @Override
    public String toString() {
        return  product.toString() + "\t\t" + quantity +"\t\t"+ calculateImport() ;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.waa;

/**
 *
 * @author Hang Ha
 */
public class Product {
    
    private String productCode;
    private String productName;
    private Float price;

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Product(String productCode, String productName, Float price) {
        this.productCode = productCode;
        this.productName = productName;
        this.price = price;
    }

}

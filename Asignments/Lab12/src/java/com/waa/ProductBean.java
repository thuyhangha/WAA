/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.waa;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


/**
 *
 * @author Hang Ha
 */
@ManagedBean
@SessionScoped
public class ProductBean {

    List<Product> allProducts = new ArrayList<>();

    public List<Product> getAllProducts() {
        return allProducts;
    }

    public void setAllProducts(List<Product> allProducts) {
        this.allProducts = allProducts;
    }   

    public ProductBean() {
        this.allProducts.add(new Product("A32581", "The winner takes it all", 12.95f));
        this.allProducts.add(new Product("A33278", "Yellow submarine", 11.35f));
    }
    
}

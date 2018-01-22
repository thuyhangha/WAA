/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.waa;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Hang Ha
 */
@ManagedBean
@SessionScoped
public class ShoppingCartBean {

    private List<ProductItem> listProduct = new ArrayList<>();
    private Float totalPrice;
    private Integer totalQuantities;
    private Float finalPrice;

    public ShoppingCartBean() {

    }

    public Float getFinalPrice() {
        this.finalPrice = 0f;
        this.finalPrice = listProduct.stream().map((i) -> i.getProduct().getPrice() * i.getQuantities()).reduce(this.finalPrice, (accumulator, _item) -> accumulator + _item);
        return this.finalPrice;
    }

    public void setFinalPrice(Float finalPrice) {
        this.finalPrice = finalPrice;
    }

    public Integer getTotalQuantities() {
        this.totalQuantities = 0;
        totalQuantities = listProduct.stream().map((i) -> i.getQuantities()).reduce(totalQuantities, Integer::sum);
        return totalQuantities;
    }

    public void setTotalQuantities(Integer totalQuantities) {
        this.totalQuantities = totalQuantities;
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<ProductItem> getListProduct() {
        return listProduct;
    }

    public void setListProduct(List<ProductItem> listProduct) {
        this.listProduct = listProduct;
    }

    public String addToCart() {

        Map<String, String> params = FacesContext.getCurrentInstance()
                .getExternalContext().getRequestParameterMap();

        String productCode = params.get("productCode");
        String productName = params.get("productName");
        Float price = Float.parseFloat(params.get("price"));
        Product product = new Product(productCode, productName, price);

        // Increment quantity of item when product already existed in the listProduct
        for (ProductItem i : listProduct) {
            if (i.getProduct().getProductCode()
                    .equals(product.getProductCode())) {
                i.setQuantities(i.getQuantities()+ 1);
                return "";
            }
        }

        // Create new item and add it to the listProduct
        ProductItem i = new ProductItem();
        i.setQuantities(1);
        i.setProduct(product);
        listProduct.add(i);
        return "";
    }

    public String removeFromCart() {
        Map<String, String> params = FacesContext.getCurrentInstance()
                .getExternalContext().getRequestParameterMap();

        String productCode = params.get("productCode");
        this.listProduct.remove(this.listProduct.stream()
                .filter(x -> x.getProduct().getProductCode().equals(productCode))
                .collect(Collectors.toList()).get(0));
        return "";
    }

}

package com.Guddu.ECommerce.Service;

import com.Guddu.ECommerce.Model.Category;
import com.Guddu.ECommerce.Model.Product;
import com.Guddu.ECommerce.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {
    @Autowired
    ProductRepo productRepo;

    public Map<Integer, Product> getProducts() {
        return productRepo.getProductList();
    }


    public String addProducts( List<Product> products) {
        Map<Integer, Product> productList = getProducts();

        for(Product product : products){
            productList.put(product.getProductId(),product);
        }
        return "products were added";
    }
    public List<Product> getAllProductsBelowPrice(Double price){
        List<Product> priceFilteredProducts = new ArrayList<>();
        Map<Integer, Product> productList = getProducts();
        for(Integer id : productList.keySet()){
            if(productList.get(id).getProductPrice()<=price){
                priceFilteredProducts.add(productList.get(id));
            }
        }

        return priceFilteredProducts;
    }

    public List<Product> getAllProductsByCategory(Category category) {
        List<Product> categoryFilteredProducts = new ArrayList<>();
        Map<Integer, Product> productList = getProducts();
        for(Integer id : productList.keySet()){
            if(productList.get(id).getProductCategory().equals(category)){
                categoryFilteredProducts.add(productList.get(id));
            }
        }

        return categoryFilteredProducts;
    }

    public String removeProduct(Integer pId) {
        Map<Integer, Product> productList = getProducts();
        Product product = productList.get(pId);
        if(product != null){
            productList.remove(pId);
            return pId+ " removed";
        }else {
            return pId+" Not Found";
        }
    }
    public String updateProductByDiscount(Double discount){
        Map<Integer, Product> productList = getProducts();
        for(Integer id : productList.keySet()){
            Double actualPrice = productList.get(id).getProductPrice();
            productList.get(id).setProductPrice(actualPrice-actualPrice*discount/(100.0));
        }
        return "price updated";
    }
}

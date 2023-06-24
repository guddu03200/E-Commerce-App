package com.Guddu.ECommerce.Controller;

import com.Guddu.ECommerce.Model.Category;
import com.Guddu.ECommerce.Model.Product;
import com.Guddu.ECommerce.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    //get Api



    //get all products
@GetMapping("products")
    public Map<Integer, Product> getProducts(){
        return productService.getProducts();

    }


    //get all products below a particular price range
    @GetMapping("products/price/{price}")
    public List<Product> getProductBelowPrice(@PathVariable Double price){
    return productService.getAllProductsBelowPrice(price);
    }

    //get all products belonging to a particular category
    @GetMapping("products/category/{category}")
    public List<Product> getProductByCategory(@PathVariable Category category){
        return productService.getAllProductsByCategory(category);
    }




    //create


    //add a multiple product at the same time
    @PostMapping("products")
    public String addProducts(@RequestBody List<Product> products){
    return productService.addProducts(products);
    }

    //remove a particular product based on product id
    @DeleteMapping("products/{pId}")
    public String removeProduct(@PathVariable Integer pId){
    return productService.removeProduct(pId);
    }


    //update price based on some discount
@PutMapping("products/discount/{discount}")
    public String updateProductByDiscount(@PathVariable Double discount){
    return productService.updateProductByDiscount(discount);
}

}

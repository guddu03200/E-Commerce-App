package com.Guddu.ECommerce.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data //getter and setter
@AllArgsConstructor//(with args)
@NoArgsConstructor//(without args)

public class Product {
    private Integer productId;
    private String productName;
    private Double productPrice;
    private Category productCategory;
}


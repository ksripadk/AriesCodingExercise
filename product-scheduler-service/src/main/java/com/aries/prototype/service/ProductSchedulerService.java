package com.aries.prototype.service;

import com.aries.prototype.model.Product;
import com.aries.prototype.model.ProductRequest;
import com.aries.prototype.model.ProductResponse;
import com.aries.prototype.utility.DateUtility;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ProductSchedulerService {

    public List<Product> handleAddProducts(List<ProductRequest> productRequestList, List<Product> productsList)
    {
        for (ProductRequest productRequest : productRequestList) {
            if(productRequest.getCustomerId() != null && productRequest.getProductName() != null &&
                    productRequest.getDomain() != null && productRequest.getStartDate() != null) {

                productsList.add(new Product(productRequest.getCustomerId(), productRequest.getProductName(),
                        productRequest.getDomain(), productRequest.getStartDate(), productRequest.getDurationMonths(),
                        DateUtility.getExpirationDate(productRequest.getStartDate(), productRequest.getDurationMonths())
                ));
            }
        }
        return productsList;
    }

    public List<ProductResponse> handleGetEmailScheduler(List<Product> productList)
    {
        List<ProductResponse> emailProdList = new ArrayList<ProductResponse>();
        if(productList != null && productList.size() != 0) {
            for (Product product : productList) {
                if (product.getCustomerId() != null) {
                    List<String> dateList = DateUtility.getEmailDates(product.getStartDate(), product.getExpirationDate(), product.getProductName());
                    if (dateList.size() != 0 && dateList != null) {
                        for (String date : dateList) {
                            emailProdList.add(new ProductResponse(product.getCustomerId(), product.getProductName(),
                                    product.getDomain(), date));
                        }
                    }
                }
            }
        }
        Collections.sort(emailProdList);
        return emailProdList;
    }
}

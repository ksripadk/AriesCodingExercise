package com.aries.prototype.service;

import com.aries.prototype.model.Product;
import com.aries.prototype.model.ProductRequest;
import com.aries.prototype.utility.DateUtility;
import org.springframework.stereotype.Service;

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
}

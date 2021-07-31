package com.aries.prototype.controller;

import com.aries.prototype.model.Product;
import com.aries.prototype.model.ProductList;
import com.aries.prototype.model.ProductRequest;
import com.aries.prototype.model.ProductResponseList;
import com.aries.prototype.service.ProductSchedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Scheduler/Service")
public class ProductSchedulerController {

    @Autowired
    private ProductList productList;
    @Autowired
    private ProductSchedulerService productSchedulerService;


    @GetMapping("/getProducts")
    public ResponseEntity<ProductList> getProducts()
    {
        return new ResponseEntity<ProductList>(productList, HttpStatus.OK);
    }

    @PostMapping("/addProducts")
    public ResponseEntity<String> addProducts(@RequestBody List<ProductRequest>  productRequestList)
    {
        List<Product> productsList = productList.getProductsList();
        if(productsList == null)
            productsList = new ArrayList<Product>();
        if(productRequestList.size() != 0 && productRequestList != null) {
            productList.setProductsList(productSchedulerService.handleAddProducts(productRequestList, productsList));
        }
        return new ResponseEntity<String>("Successfully Added!",HttpStatus.OK);
    }

    @GetMapping("/getEmailScheduler")
    public ResponseEntity<ProductResponseList> getEmailScheduler()
    {
        ProductResponseList productResponseList = new ProductResponseList();
        productResponseList.setProductResponseList(productSchedulerService.handleGetEmailScheduler(productList.getProductsList()));
        return new ResponseEntity<ProductResponseList>(productResponseList,HttpStatus.OK);
    }

    @DeleteMapping("/removeProduct")
    public ResponseEntity<String> removeProduct(@RequestParam(name = "id") String custId, @RequestParam(name = "product") String prodName, @RequestParam String domain)
    {
        String response = null;
        if(productList != null && productList.getProductsList() != null)
        {
            for (Product product: productList.getProductsList())
            {
                if(product.getCustomerId() != null &&product.getCustomerId().equals(custId) &&
                        product.getProductName().equals(prodName) && product.getDomain().equals(domain))
                {
                    productList.getProductsList().remove(product);
                    response = "Removed The Product Successfully!";
                    break;
                }
            }
        }
        if(response == null)
            return new ResponseEntity<String>("Product not found to remove!",HttpStatus.OK);
        else
            return new ResponseEntity<String>(response,HttpStatus.OK);
    }
}

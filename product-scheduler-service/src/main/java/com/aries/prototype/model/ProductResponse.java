package com.aries.prototype.model;

import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ProductResponse implements Comparable<ProductResponse> {

    private String customerId;
    private String productName;
    private String domain;
    private String emailDate;

    public ProductResponse() {
    }

    public ProductResponse(String customerId, String productName, String domain, String emailDate) {
        this.customerId = customerId;
        this.productName = productName;
        this.domain = domain;
        this.emailDate = emailDate;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getEmailDate() {
        return emailDate;
    }

    public void setEmailDate(String emailDate) {
        this.emailDate = emailDate;
    }

    @Override
    public int compareTo(ProductResponse productResponse) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date start,end;
        int result=0;
        try {
            start = sdf.parse(getEmailDate());
            end = sdf.parse(productResponse.getEmailDate());
            result = start.compareTo(end);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }
}

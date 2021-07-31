package com.aries.prototype.model;

import org.springframework.stereotype.Component;

@Component
public class ProductResponse {
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
}

package com.aries.prototype.model;

import org.springframework.stereotype.Component;

@Component
public class Product {

    private String customerId;
    private String productName;
    private String domain;
    private String startDate;
    private int durationMonths;
    private String expirationDate;

    public Product() {
    }

    public Product(String customerId, String productName, String domain, String startDate, int durationMonths, String expirationDate) {
        this.customerId = customerId;
        this.productName = productName;
        this.domain = domain;
        this.startDate = startDate;
        this.durationMonths = durationMonths;
        this.expirationDate = expirationDate;
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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public int getDurationMonths() {
        return durationMonths;
    }

    public void setDurationMonths(int durationMonths) {
        this.durationMonths = durationMonths;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }
}

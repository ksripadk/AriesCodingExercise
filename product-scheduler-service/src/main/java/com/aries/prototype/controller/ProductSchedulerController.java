package com.aries.prototype.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Scheduler/Service")
public class ProductSchedulerController {

    @GetMapping("/getProducts")
    public void getProducts()
    {
    }

    @PostMapping("/addProducts")
    public String addProducts()
    {
        return "Successfully Added!";
    }

    @GetMapping("/getEmailScheduler")
    public void getEmailScheduler()
    {
    }

    @DeleteMapping("/removeProduct")
    public String removeProduct(@RequestParam(name = "id") String custId, @RequestParam(name = "product") String prodName, @RequestParam String domain)
    {
        return "Successfully Removed!";
    }
}

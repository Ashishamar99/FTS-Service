package com.hcltech.fts.controller;

import com.hcltech.fts.model.Customer;
import com.hcltech.fts.service.FTSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class FTSController {

    @Autowired
    FTSService ftsService;


    @GetMapping(path = "${api.rootpath}")
    public String testServer(){
//        ftsService.generateTestData();
        return "able to reach endpoint";
    }

    @GetMapping(path = "${api.getCustomerFromIdPath}")
    public Customer getCustomerFromId(@PathVariable(name = "cid", required = true) String cid){
        return ftsService.getCustomerFromId(cid);
    }

    @PostMapping(path = "${api.addCustomerPath}")
    public Customer addCustomer(@RequestBody Customer customer){
        return ftsService.addCustomer(customer);
    }
}

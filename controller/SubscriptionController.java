package com.example.audible.controller;

import com.example.audible.Service.SubscriptionService;
import com.example.audible.model.Order;
import com.example.audible.model.Subscription;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/subscription")
public class SubscriptionController {
    @Autowired
    private SubscriptionService subscriptionService;
    @GetMapping
    public List<Subscription> getAllSubscription() {
        return subscriptionService.getAllsubscription();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Subscription> getsubscriptionById(@PathVariable int id) {
        return subscriptionService.getSubscriptionById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping("/addSubscriptionDetails")
    public Subscription postSubscriptionDetails(@RequestBody Subscription subscription){

        return subscriptionService.saveSubscriptionDetails(subscription);
    }

}

package com.example.audible.Service;

import com.example.audible.model.Order;
import com.example.audible.model.Subscription;
import com.example.audible.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionService {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    public List<Subscription> getAllsubscription(){
        return subscriptionRepository.findAll();
    }

    public Optional<Subscription> getSubscriptionById(int id) {
        return subscriptionRepository.findById(id);
    }

    public Subscription createSubscription(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    public Subscription saveSubscriptionDetails(Subscription subscription){

        return subscriptionRepository.save(subscription);
    }
}



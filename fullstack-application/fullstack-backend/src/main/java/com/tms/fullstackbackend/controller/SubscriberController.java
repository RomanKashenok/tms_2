package com.tms.fullstackbackend.controller;

import com.tms.fullstackbackend.model.Subscriber;
import com.tms.fullstackbackend.service.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = { "http://localhost:3000"})
public class SubscriberController {

    private final SubscriberService subscriberService;

    @Autowired
    public SubscriberController(SubscriberService subscriberService) {
        this.subscriberService = subscriberService;
    }

    @GetMapping("/subscribers")
    public List<Subscriber> getAllSubscribers() {
        return subscriberService.findAllActive();
    }

    @GetMapping("/subscribers/{id}")
    public Subscriber getSubscriber(@PathVariable Long id) {
        return subscriberService.findById(id);
    }

    //Not used

    @GetMapping("/subscribers/search/{name}")
    public List<Subscriber> searchSubscriber(@PathVariable String name) {
        return subscriberService.findByName(name);
    }

    @PostMapping("/subscribers")
    public Subscriber addSubscriber(@RequestBody Subscriber subscriber) {
        return subscriberService.add(subscriber);
    }

    @PostMapping("/subscribers/list")
    public List<Subscriber> addSubscriber(@RequestBody List<Subscriber> subscribers) {
        return subscriberService.addAll(subscribers);
    }

    @PutMapping("/subscribers")
    public Subscriber updateSubscriber(@RequestBody Subscriber subscriber) {
        return subscriberService.update(subscriber);
    }

    @DeleteMapping("/subscribers/{id}")
    public ResponseEntity<HttpStatus> deleteSubscriber(@PathVariable Long id){
        subscriberService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

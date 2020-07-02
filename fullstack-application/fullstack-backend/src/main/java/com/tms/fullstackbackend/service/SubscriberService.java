package com.tms.fullstackbackend.service;

import com.tms.fullstackbackend.model.Subscriber;

import java.util.List;

public interface SubscriberService {

    Subscriber add(Subscriber subscriber);
    Subscriber findById(Long id);
    void delete(Long id);
    Subscriber update(Subscriber subscriber);
    List<Subscriber> findAllActive();
    List<Subscriber> findByName(String name);
    List<Subscriber> addAll(List<Subscriber> subscribers);
}

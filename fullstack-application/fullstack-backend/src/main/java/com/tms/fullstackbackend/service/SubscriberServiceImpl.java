package com.tms.fullstackbackend.service;

import com.tms.fullstackbackend.model.Subscriber;
import com.tms.fullstackbackend.repository.SubscriberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubscriberServiceImpl implements SubscriberService {

    private final SubscriberRepository repo;

    @Autowired
    public SubscriberServiceImpl(SubscriberRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Subscriber> findAllActive() {
        return repo.findAllActive();
    }

    @Override
    public Subscriber findById(Long id) {
        Optional<Subscriber> subscriber = repo.findById(id);
        return subscriber.orElse(null);
    }

    @Override
    public List<Subscriber> findByName(String name) {
        return repo.findByName(name);
    }

    @Override
    public List<Subscriber> addAll(List<Subscriber> subscribers) {
        return repo.saveAll(subscribers);
    }

    @Override
    public Subscriber add(Subscriber subscriber) {
        return repo.save(subscriber);
    }

    @Override
    public Subscriber update(Subscriber subscriber) {
        return repo.save(subscriber);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}

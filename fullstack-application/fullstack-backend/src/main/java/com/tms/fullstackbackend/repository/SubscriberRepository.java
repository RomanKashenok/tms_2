package com.tms.fullstackbackend.repository;

import com.tms.fullstackbackend.model.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscriberRepository extends JpaRepository<Subscriber, Long> {

    @Query("from Subscriber  where active = true")
    List<Subscriber> findAllActive();

    @Query("select s from Subscriber s where lower(s.name) like lower(concat('%', :name,'%')) AND active = true")
    List<Subscriber> findByName(String name);
}
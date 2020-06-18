package com.tms.testing.repository;

import com.tms.testing.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("from User where name = :name")
    List<User> findUsersByName(String name);

}

package com.tms.sbsecurity.app.repository;

import com.tms.sbsecurity.app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("from User where username = :username")
    User findByLogin(String username);

}

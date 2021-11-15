package com.phase3.stockmarket.Repositories;

import com.phase3.stockmarket.Entities.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select * from user where email = :e and password = :p and confirmed = 1", nativeQuery = true)
    public User signin(@Param("e") String email, @Param("p") String pass);
}

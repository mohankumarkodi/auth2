package com.example.demo.repositiory;

import com.example.demo.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

    @Repository
    public interface UserRepository extends JpaRepository<UserDetails,Integer> {

        @Query(value="select * from auth_details where email =:email AND password = :password",nativeQuery = true)
        UserDetails findEmailAndPassword(@Param("email")String email, @Param("password")String password);
//    Optional<User> findByUserId(int id);

        @Query(value ="select * from auth_details where username =:username",nativeQuery = true )
        UserDetails findDetailsByEmail(@Param("username")String username);

    }


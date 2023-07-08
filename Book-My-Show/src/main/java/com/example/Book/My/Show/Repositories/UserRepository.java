package com.example.Book.My.Show.Repositories;

import com.example.Book.My.Show.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByEmailId(String emailId);
}

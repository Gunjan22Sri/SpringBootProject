package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.books;

@Repository
public interface demorepository extends JpaRepository<books, Integer> {

    // public void add(User u);
    // public User show();

}

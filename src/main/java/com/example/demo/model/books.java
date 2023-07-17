package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Books")
public class books {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    int id;
    
    private String name;
    private String author;

    
    public books(int id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }

    public books() {
    }

    @Override
    public String toString() {
        return "User [name=" + name + ", author=" + author + ", author=" + author + "]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}

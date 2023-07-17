package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.books;
import com.example.demo.repository.demorepository;

@Service
public class demoservice {

    @Autowired
    private demorepository repo;

    books b;
    List<books> bk = new ArrayList();

    public List<books> test() {
        bk.add(new books(1, "ravi", "ravi@gmail.com"));
        bk.add(new books(2, "saurav", "saurav@gmail.com"));
        bk.add(new books(3, "aashi", "aashi@gmail.com"));
        bk.add(new books(4, "priya", "priya@gmail.com"));
        return bk;
    }

    public void add(books u) {
        repo.save(u);

    }

    public List<books> getBooks() {
        System.out.println("data frm db" + repo.findAll());
        return repo.findAll();
    }

    public books getBookById(int id) {
        Optional<books> opt = repo.findById(id);
        if (opt.isPresent())
            return opt.get();
        else
            return null;
    }

    public void delete(int id) {
        repo.deleteById(id);
    }

}

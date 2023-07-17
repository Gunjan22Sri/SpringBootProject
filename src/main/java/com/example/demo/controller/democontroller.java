package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.books;
import com.example.demo.service.demoservice;

import jakarta.servlet.http.HttpSession;

@Controller
// @RestController
public class democontroller {

    @Autowired
    demoservice service;

    // @GetMapping("/")
    // public List<books> jwtTestin() {
    // List<books> list = service.test();

    // return list;
    // }

    @GetMapping("/")
    public String index(Model model) {
        List<books> list = service.getBooks();
        model.addAttribute("data", list);
        return "index";
    }

    @GetMapping("/add")
    public String add() {
        return "addbook";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute books user, HttpSession session) {
        System.out.println(user.toString());
        service.add(user);
        session.setAttribute("msg", "Record Added Successfully");
        return "redirect:/";
    }

    @PostMapping("/welcome")
    public String welcome(@ModelAttribute books user, Model model) {
        System.out.println(user.toString());
        model.addAttribute("name", user.getName());
        return "welcome";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model m) {
        books b = service.getBookById(id);
        m.addAttribute("book", b);
        return "editbook";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute books book, HttpSession session) {
        service.add(book);
        session.setAttribute("msg", "Record Update Successfully");
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, HttpSession session) {
        service.delete(id);
        session.setAttribute("msg", "Record Deleted Successfully");
        return "redirect:/";
    }

}

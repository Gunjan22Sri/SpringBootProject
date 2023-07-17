package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.demo.model.books;
import com.example.demo.repository.demorepository;
import com.example.demo.service.demoservice;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private demoservice demoserv;

	@MockBean
	private demorepository demorepo;

	@Test
	public void getBook(){
		when(demorepo.findAll()).thenReturn(Stream.of(new books(12,"aa","aa@gmail.com"),
		new books(13,"bb","bb@gmail.com")).collect(Collectors.toList()));
		assertEquals(2,demoserv.getBooks().size());
	}

}

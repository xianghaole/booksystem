package com.xjl.springboot;

import com.xjl.springboot.domain.Book;
import com.xjl.springboot.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@SpringBootTest
class SpringbootBackendApplicationTests {
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private ApplicationContext ioc;
	@Test
	public void test02() throws SQLException {
		DataSource bean = ioc.getBean(DataSource.class);

		System.out.println(bean);
	}
	@Test
	public void test01(){
		List<Book> all = bookRepository.findAll();
		System.out.println(all);
	}
	@Test
	void contextLoads() {
	}

}

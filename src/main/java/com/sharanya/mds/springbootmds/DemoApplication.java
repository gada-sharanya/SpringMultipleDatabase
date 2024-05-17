package com.sharanya.mds.springbootmds;

import com.sharanya.mds.springbootmds.orderentities.Order;
import com.sharanya.mds.springbootmds.orderrepository.OrderDAO;
import com.sharanya.mds.springbootmds.productentities.Product;
import com.sharanya.mds.springbootmds.productrepoistory.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private OrderDAO orderDAO;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Product p = new Product(1, "Laptop",200000.00);
		productDAO.save(p);

		Order o = new Order(1,"Sharanya", LocalDate.now());
		orderDAO.save(o);

	}
}

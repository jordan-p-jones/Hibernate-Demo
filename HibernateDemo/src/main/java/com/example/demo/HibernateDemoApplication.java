package com.example.demo;

import java.util.Arrays;
import java.util.Date;

//import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * Main class to run the demo application.
 */
@SpringBootApplication
public class HibernateDemoApplication 
{
	/**
	 * Main method to run the application. It will create records in the
	 * customer, product, and purchase tables and persist them to the database.
	 * Once this is done, the program will terminate.
	 * 
	 * @param args could contain program arguments (not used).
	 */
	public static void main(String[] args) 
	{				
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgresPersistence");
        EntityManager em = emf.createEntityManager();

        // Create a new customer.
        Customer customer = new Customer("John Doe", "john.doe@example.com");

        // Create new products.
        Product product1 = new Product("BBQ Chips", 3.99);
        Product product2 = new Product("Milk", 4.99);

        // Create a new purchase with the customer and products.
        Purchase purchase = new Purchase();
        purchase.setCustomer(customer);
        purchase.setProducts(Arrays.asList(product1, product2));
        purchase.setPurchaseTimestamp(new Date());

        // Persist the purchase and all objects it contains.
        em.getTransaction().begin();
        em.persist(purchase);
        em.getTransaction().commit();

        em.close();
        emf.close();
	}

}

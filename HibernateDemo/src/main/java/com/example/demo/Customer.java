package com.example.demo;
import jakarta.persistence.*;

/**
 * Class to represent a customer business object.
 */
@Entity
@Table(name = "customer")
public class Customer 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
    
    @Column(name = "email")
    private String email;
    
    public Customer() {}
    
    /**
     * Constructor for Customer.
     * 
     * @param name is the name to set.
     * @param email is the email to set.
     */
    public Customer(String name, String email) 
    {
        this.name = name;
        this.email = email;
    }

	/**
	 * Get the id.
	 *
	 * @return the id
	 */
	public Long getId() 
	{
		return id;
	}

	/**
	 * Set the id.
	 *
	 * @param id the id to set
	 */
	public void setId(Long id) 
	{
		this.id = id;
	}

	/**
	 * Get the name.
	 *
	 * @return the name
	 */
	public String getName() 
	{
		return name;
	}

	/**
	 * Set the name.
	 *
	 * @param name the name to set
	 */
	public void setName(String name) 
	{
		this.name = name;
	}

	/**
	 * Get the email.
	 *
	 * @return the email
	 */
	public String getEmail() 
	{
		return email;
	}

	/**
	 * Set the email.
	 *
	 * @param email the email to set
	 */
	public void setEmail(String email) 
	{
		this.email = email;
	}
}

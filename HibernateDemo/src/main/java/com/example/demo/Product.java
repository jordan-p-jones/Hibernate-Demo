package com.example.demo;
import jakarta.persistence.*;

/**
 * Class to represent a product business object.
 */
@Entity
@Table(name = "product")
public class Product 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
    
    @Column(name = "price")
    private Double price;
    
    // Reference to the Order entity
    @ManyToOne
    @JoinColumn(name = "purchaseId")
    private Purchase purchase;
    
    public Product() {}
    
    /**
     * Constructor for Product.
     * 
     * @param name is the name to set.
     * @param price is the price to set.
     */
    public Product(String name, Double price)
    {
    	this.name = name;
    	this.price = price;
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
	 * Get the price.
	 *
	 * @return the price
	 */
	public Double getPrice()
	{
		return price;
	}

	/**
	 * Set the price.
	 *
	 * @param price the price to set
	 */
	public void setPrice(Double price)
	{
		this.price = price;
	}

	/**
	 * Get the purchase.
	 *
	 * @return the purchase
	 */
	public Purchase getPurchase()
	{
		return purchase;
	}

	/**
	 * Set the purchase.
	 *
	 * @param purchase the purchase to set
	 */
	public void setPurchase(Purchase purchase)
	{
		this.purchase = purchase;
	}
}

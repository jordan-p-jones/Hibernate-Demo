package com.example.demo;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Class to represent a purchase business object.
 */
@Entity
@Table(name = "purchase")
public class Purchase 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customerId")
    private Customer customer;

    @OneToMany(mappedBy = "purchase", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Product> products;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "purchaseTimestamp")
    private Date purchaseTimestamp;
    
    public Purchase() {}
    
    /**
     * Constructor for Purchase.
     * 
     * @param customer is the customer to set.
     * @param products is the list of products to set.
     * @param purchaseTimestamp is the purchaseTimestamp to set.
     */
    public Purchase(Customer customer, List<Product> products, Date purchaseTimestamp) 
    {
        this.customer = customer;
        this.products = products;
        this.purchaseTimestamp = purchaseTimestamp;
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
	 * Get the customer.
	 *
	 * @return the customer
	 */
	public Customer getCustomer()
	{
		return customer;
	}

	/**
	 * Set the customer.
	 *
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer)
	{
		this.customer = customer;
	}

	/**
	 * Get the products.
	 *
	 * @return the products
	 */
	public List<Product> getProducts()
	{
		return products;
	}

	/**
	 * Set the products.
	 *
	 * @param products the products to set
	 */
	public void setProducts(List<Product> products)
	{
		this.products = products;
	}

	/**
	 * Get the purchaseTimestamp.
	 *
	 * @return the purchaseTimestamp
	 */
	public Date getPurchaseTimestamp()
	{
		return purchaseTimestamp;
	}

	/**
	 * Set the purchaseTimestamp.
	 *
	 * @param purchaseTimestamp the purchaseTimestamp to set
	 */
	public void setPurchaseTimestamp(Date purchaseTimestamp)
	{
		this.purchaseTimestamp = purchaseTimestamp;
	}
}

# Hibernate-Demo
Demonstrates the use of Hibernate in a Spring Boot application to create database tables and persist data to a Postgres database.

There are a few different ways to use Hibernate to manage data access in Java. In this demo I will use the simplest method, which is to create an EntityManager configured to connect to the Postgres database through the persistence.xml file. The EntityManager will be able to handle all of the necessary database calls for all of the Entity classes (which represent database tables). Using this method, it is not necessary to create any files specially for database access. The only setup I need to do in advance is create the database with a database name, and have a username and password for accessing the database. I do not need to create any of the database tables, Hibernate will do that when the program runs.

I want to create a simple relational database to loosely represent a store concept. There will be customers, who have a name and email. Then there are products, which have a name and price, and a link to a purchase for when they are bought. Finally there are purchases, which record which customer made the transaction on a certain timestamp.

For the customer table, I only need a few basic annotations to tell Hibernate how to interpret the class:
  - @Entity tells it that the class represents a database table
  - @Table specifies the name of the table
  - @Id and @GeneratedValue setup a generated ID field for the primary key
  - @Column above each instance variable specifies that each represents a database table column and what that column is named

![image](https://github.com/jordan-p-jones/Hibernate-Demo/assets/20289004/ce46551e-df2d-4f2d-9a23-947a024718a9)

For the product table, there is only one new element, which is a foreign key to the purchase table:
  - @JoinColumn is used to map the purchase variable to a foreign key to the purchase table called purchaseId
  - @ManyToOne specifies that many different products can be linked to one purchase

![image](https://github.com/jordan-p-jones/Hibernate-Demo/assets/20289004/90470fa2-880c-4c21-bfad-8f3aed68d692)

Finally, the purchase table includes a few more new elements to define the relationships to customer and product:
  - @JoinColumn is used to specify a foreign key on purchase to customer
  - @ManyToOne specifies that many purchases can be linked to one customer
  - Purchase contains a List of Products in the class, but a database record can't contain a list of other records. So, @OneToMany is used to specify that one purchase can map to many products
  - CascadeType.ALL is used for both customer and product relationships to have any changes made to their objects within Purchase to be persisted along with the purchase record itself

![image](https://github.com/jordan-p-jones/Hibernate-Demo/assets/20289004/9c3e1018-6ccb-41d2-89a2-d8f8179be19f)

In the main method, I point EntityManagerFactory to the persistence-unit defined in persistence.xml, which tells it how to connect to my database. Then it creates an EntityManager that I can use for database calls. After that, all I have to do is create some objects and set their values appropriately.

Once everything is setup, a single persist of the purchase will save all of the records to the database.

![image](https://github.com/jordan-p-jones/Hibernate-Demo/assets/20289004/508cd5f2-9aca-4ba4-b076-4d173b28c16a)

Selected records from pgAdmin:

![image](https://github.com/jordan-p-jones/Hibernate-Demo/assets/20289004/7ff97c7a-17d1-4ad0-a2f4-f359ad628cda)

![image](https://github.com/jordan-p-jones/Hibernate-Demo/assets/20289004/de47356b-7bb4-450d-809c-ab2c791a2682)

![image](https://github.com/jordan-p-jones/Hibernate-Demo/assets/20289004/5af00251-226c-4d95-a54c-8197f3bacea3)

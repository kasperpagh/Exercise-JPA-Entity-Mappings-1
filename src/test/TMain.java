/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entity.Book;
import entity.Customer;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author kaspe
 */
public class TMain
{

    /*
    SVAR PÅ OPGAVE 4: De nye bøger der bliver addet fra sql-scriptet, har fået ID 1 og 2. Det er fordi at databasen "loader" ind fra persistence.xml (hvor addData.sql bliver linket)
    førend vores main method får lov at køre (og lave bøger mv.)
     */
    public static void main(String[] args)
    {
        Persistence.generateSchema("JPAMandagPU", null);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAMandagPU");
        EntityManager em = emf.createEntityManager();
        Book b1 = new Book("bog1");
        Book b2 = new Book("bog2");
        Book b3 = new Book("bog3");
        Book b4 = new Book("bog4");
        Book b5 = new Book("bog5");

        Customer c1 = new Customer();
        c1.addPhone("1", "tel1");
        Customer c2 = new Customer();
        c1.addPhone("2", "tel2");
        Customer c3 = new Customer();
        c1.addPhone("3", "tel3");
        Customer c4 = new Customer();
        c1.addPhone("4", "tel4");
        Customer c5 = new Customer();
        c1.addPhone("5", "tel5");

        try
        {
            em.getTransaction().begin();
            em.persist(b1);
            em.persist(b2);
            em.persist(b3);
            em.persist(b4);
            em.persist(b5);
            em.persist(c1);
            em.persist(c2);
            em.persist(c3);
            em.persist(c4);
            em.persist(c5);
            em.getTransaction().commit();

            Integer id = b1.getId();
            Book found = em.find(Book.class, id);

            System.out.println("her er den bog der er fundet v. em.find(). Navn: " + found.getTitle() + " and the id is: " + found.getId());

        }
        finally
        {
            em.close();
        }

    }
}

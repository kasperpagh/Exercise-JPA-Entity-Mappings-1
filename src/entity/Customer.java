/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import enums.CustomerType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.FetchType;
import javax.persistence.MapKeyColumn;

/**
 *
 * @author kaspe
 */
@Entity
public class Customer implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;
    private String lastName;
    @ElementCollection()
    private List<String> hobbies = new ArrayList();

    @ElementCollection(fetch = FetchType.LAZY)
    @MapKeyColumn(name = "PHONE")
    @Column(name = "Description")
    private Map<String, String> phones = new HashMap();

    /*
    I really dont see what difference the annotation made in the DB 
     */
    @Enumerated(EnumType.STRING)
    private CustomerType customerType;

    public void addPhone(String phoneNo, String description)
    {
        phones.put(phoneNo, description);

    }

    public String getPhoneDescription(String phoneNo)
    {
        return phones.get(phoneNo);
    }

//--------------------------------------------------------------------------
    public List<String> getHobbies()
    {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies)
    {
        this.hobbies = hobbies;
    }

    public CustomerType getCustomerType()
    {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType)
    {
        this.customerType = customerType;
    }

    public int getId()
    {
        return id;
    }

    public Customer(String firstName, String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Customer()
    {
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public void setId(int id)
    {
        this.id = id;
    }

}

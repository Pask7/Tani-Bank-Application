package com.tinybankmodyfied.tinybankmodapi.database.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


/**
 * Created by pkalamucki on 05.04.2018.
 */
@Entity
@NamedQuery(name ="find_all_customers", query ="select c from Customer c")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int  customerId;
	
    private  String name;
    private  String surname;
    private  Date birthDate;
    private  String address;
    
    @OneToMany(mappedBy="customerId")
    private  List<Account> accounts = new ArrayList<>();

    public Customer() {
    	
    }
    public Customer(int customerId, String name, String surname, Date birthDate, String address, List<Account> accounts) {
        this.customerId = customerId;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.address = address;
        this.accounts = new ArrayList<Account>(accounts);
    }
	public int getCustomerId() {
		return customerId;
	}
	public String getName() {
		return name;
	}
	public String getSurname() {
		return surname;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public String getAddress() {
		return address;
	}
	public List<Account> getAccounts() {
		return accounts;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	
	}
	


  

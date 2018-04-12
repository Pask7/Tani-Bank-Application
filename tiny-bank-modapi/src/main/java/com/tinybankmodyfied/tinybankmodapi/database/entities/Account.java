package com.tinybankmodyfied.tinybankmodapi.database.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



/**
 * Created by pkalamucki on 05.04.2018.
 * 
 */
@Entity
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private int customerId;
	
    private String displayName;
    
    public Account() {
    	
    }

    public Account(int id, int customerId, String displayName) {
        this.id = id;
        this.customerId = customerId;
        this.displayName = displayName;
    }

	public int getId() {
		return id;
	}

	public int getCustomerId() {
		return customerId;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	@Override
	public String toString() {
		return "Account " + id + " " + displayName ;
	}

	

 
}
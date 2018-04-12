package com.tinybankmodyfied.tinybankmodapi.database.operations;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.tinybankmodyfied.tinybankmodapi.database.entities.Customer;



@Repository
@Transactional
public class CustomerOperations {
	
	@PersistenceContext
	EntityManager entityMenager;
		
		public List<Customer> findAll(){
			TypedQuery<Customer> namedQuery = entityMenager.createNamedQuery("find_all_customers",Customer.class);
			return namedQuery.getResultList();
		}
	
		public Customer findById(int customerId)
		{
			return entityMenager.find(Customer.class, customerId);
		}
		
		public Customer insert(Customer customer)
		{
			return entityMenager.merge(customer);
		}
		
		public Customer update(Customer customer)
		{
			return entityMenager.merge(customer);
		}
		
		public void deleteById(int id)
		{
			Customer customers = findById(id);
			entityMenager.remove(customers);
		}
			
	}


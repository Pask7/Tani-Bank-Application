package com.tinybankmodyfied.tinybankmodapi.database.operations;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.tinybankmodyfied.tinybankmodapi.database.entities.Account;

@Repository
@Transactional
public class AccountsOperations {

	@PersistenceContext
	EntityManager entityMenager;
	
		public void deleteFrom(int Id) 
		{
			entityMenager.createNativeQuery("DELETE FROM  Account  WHERE customer_Id = " +Id +"")
				.executeUpdate();
			
		}
		
		public Account findById(int id)
		{
			return entityMenager.find(Account.class, id);
		}
		
		public Account insert(Account accounts)
		{
			return entityMenager.merge(accounts);
		}
		
		public Account update(Account accounts)
		{
			return entityMenager.merge(accounts);
		}
		
		public void deleteById(int id)
		{
			Account accounts = findById(id);
			entityMenager.remove(accounts);
		}
			
	}



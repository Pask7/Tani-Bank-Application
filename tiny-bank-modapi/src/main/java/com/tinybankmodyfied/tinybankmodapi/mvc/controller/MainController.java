package com.tinybankmodyfied.tinybankmodapi.mvc.controller;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tinybankmodyfied.tinybankmodapi.database.entities.Account;
import com.tinybankmodyfied.tinybankmodapi.database.entities.Customer;
import com.tinybankmodyfied.tinybankmodapi.database.operations.AccountsOperations;
import com.tinybankmodyfied.tinybankmodapi.database.operations.CustomerOperations;


@Controller
public class MainController {

	@Autowired
	CustomerOperations customperop;
	
	@Autowired
	AccountsOperations accountop;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
		binder.registerCustomEditor(Date.class , new CustomDateEditor (
				dateFormat,false));
	}
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String showCustomers(ModelMap model)
	{
		
		model.put("customers", customperop.findAll());
		return "customers";
	}
	@RequestMapping(value="/addCustomer", method = RequestMethod.GET)
	public String addCustomer(ModelMap model)
	{
		model.addAttribute("customer",new Customer(0,"Podaj imie ","Podaj Nazwisko",new Date(),"Podaj addres",new ArrayList<>()));
		return "addCustomer";
	}

	@RequestMapping(value="/addCustomer", method = RequestMethod.POST)
	public String saveCustomer(ModelMap model ,@Valid Customer customer ,BindingResult Result)
	{
		
		customer = new Customer(customer.getCustomerId(),customer.getName(),customer.getSurname(),customer.getBirthDate(),customer.getAddress(),new ArrayList<>());
		customperop.insert(customer);

		return "redirect:/";
	}
	
	@RequestMapping(value="/oppenAccount", method = RequestMethod.GET)
	public String oppenAccount(ModelMap model,@RequestParam int customerId )
	{
		
		model.addAttribute("account",new Account(0,customerId,"Podaj Nazwe"));

		return "oppenAccount";
	}
	
	@RequestMapping(value="/oppenAccount", method = RequestMethod.POST)
	public String saveAccount(ModelMap model ,@Valid Account account ,BindingResult Result)
	{
		
		account = new Account(account.getId(),account.getCustomerId(),account.getDisplayName());
		accountop.insert(account);

		return "redirect:/";
	}
	@RequestMapping(value="/delete", method = RequestMethod.GET)
	public String deleteCustomer(@RequestParam int customerId )
	{
		accountop.deleteFrom(customerId);
		customperop.deleteById(customerId);
		return "redirect:/";
	}
}

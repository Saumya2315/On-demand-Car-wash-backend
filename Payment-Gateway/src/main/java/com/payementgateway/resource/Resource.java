package com.payementgateway.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payementgateway.models.TransactionDetails;
import com.payementgateway.service.TransactionService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/payment")
public class Resource {
	
	@Autowired
	TransactionService transactionService;
	
	@GetMapping("/createTransaction/{amount}")
	public TransactionDetails createTransaction(@PathVariable double amount) {
		
//		System.out.println(transactionService.createTransaction(amount));
		
		return transactionService.createTransaction(amount);
		
		
	}

}

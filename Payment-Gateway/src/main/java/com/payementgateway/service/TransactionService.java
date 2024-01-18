package com.payementgateway.service;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.payementgateway.models.TransactionDetails;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;

@Service
public class TransactionService {
	private static final String KEY="rzp_test_d9fuCy5w83vfWH";
	private static final String KEY_SECRET="Hk06Sd89JlA1tXu6DzDhvq9S";
	private static final String CURRENCY="INR";
	public TransactionDetails createTransaction(double amount) {
		try {
//			System.out.println(amount);
			JSONObject jsonObject= new JSONObject();
			jsonObject.put("amount", amount*100);
			jsonObject.put("currency", CURRENCY);
			
			RazorpayClient razorpayClient=new RazorpayClient(KEY, KEY_SECRET);
			Order order= razorpayClient.orders.create(jsonObject);
			
//			System.out.println(order + "order");
			return prepareTransactionDetails(order);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}	
		return null;
	}
	private TransactionDetails prepareTransactionDetails(Order order) {
		String orderId=order.get("id");
		String currency=order.get("currency");
		int amount=order.get("amount");
		System.out.println(orderId+currency+amount);
		
		TransactionDetails transactionDetails = 
				new TransactionDetails(orderId, currency, amount,KEY);
		return transactionDetails;
		
		
	}
	
	

}

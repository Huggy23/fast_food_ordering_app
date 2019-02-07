//******************************************************************************************************************
// CPSC-50100-002                                       		 Assignment 2, Week 2
// Flyers' Online Ordering System			                     Author: Jason Huggy
//
//
// This program will allow a customer to submit an online order for pick-up or delivery through Flyers. 
//
//******************************************************************************************************************

import java.util.Scanner;
import java.text.NumberFormat;
import java.text.DecimalFormat;

public class Main {
	
	public static void main(String[] args) {
		
		
	
		//Customer chooses if they want to order for pick-up or delivery.
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Welome to Flyers' Online Ordering system! First, "
				+ "Would you like to place an order for Pick-up or Delivery? (Enter \"1\" for Pick-up or \"2\" for Delivery)");
		
		int selection = scan.nextInt();
		
		while (selection <= 0 || selection >= 3) {  //This is in case the customer chooses a number other than 1 or 2
			System.out.println("Please type \"1\" for Pick-up or \"2\" for Delivery.");
			selection = scan.nextInt();
			break;
		}
		
		// Customer enters zip code if requesting a delivery order. 
		
		int zipcode = 0;
		
		if (selection != 1) {  
			System.out.println("Please type in your zipcode");
			zipcode = scan.nextInt();
			
			if (zipcode >= 60442 && zipcode <= 60450) {
				System.out.println("Delivery is Available in this Area");
			}else if (zipcode == 60441 || zipcode == 60451) {
				System.out.println("Delivery with Extra Cost");
			}else System.out.println("Delivery is Not Available in this Area. You must pick-up your order.");
			}
	

		// Customer Orders Food. Total is updated when each item is added. 
		
		double subtotal = 0, totalBill;
		
		
		System.out.println("Choose items to add to your order: ");
		System.out.println("Choose 1 for Flyers' Burger : $4.50 per order");
		System.out.println("Choose 2 for Flyers' Drink  : $1.50 per order");
		System.out.println("Choose 3 for Flyers' Fries  : $2.50 per order");
		System.out.println("Choose 4 for Flyers' Dessert: $3.00 per order");
		System.out.println("Type 5 to Finish Order");
		int value = scan.nextInt();
		
		while(value != 5) {
			
			if (value == 1) {
				subtotal += 4.50;
				System.out.println("One Burger added to order. Your current total is: " + subtotal);
			} else if (value == 2) {
				subtotal += 1.50;
			    System.out.println("One Drink added to order. Your current total is: " + subtotal);
			} else if (value == 3) {
				subtotal += 2.50;
			    System.out.println("One Fry added to order. Your current total is: " + subtotal);
			} else if (value == 4) {
				subtotal += 3.00;
			    System.out.println("One Dessert added to order. Your current total is: " + subtotal);
			} else if (value <= 0 || value >= 6 ) {
				System.out.println("Please type in a number 1 through 4 to add an item to your order. Enter 5 to finalize order."); // In case the customer enters an incorrect input. 
			} else break;
			value = scan.nextInt();
			
		}
		
		
		// Taxes and additional fees are added to the subtotal and total cost and end message is displayed. 
		
		double tax = 0.05, deliveryCost= 5, extraCost= 7;
		
		NumberFormat fmt = NumberFormat.getCurrencyInstance();
		
		if (selection == 1) {
			System.out.println("Your total is: " + fmt.format(subtotal + (subtotal * tax)) + ". Your order will be ready for pick-up in 15 minutes. Thank you!");
		} else if ((selection == 2) && (zipcode >= 60442) && (zipcode <= 60450) ) {
			System.out.println("Your total is: " + fmt.format(subtotal + deliveryCost + (subtotal * tax)) + ". Your order will be delivered to you within 30 minutes. Thank you!");
		} else if ((selection == 2) && (zipcode == 60441 || zipcode == 60451)) {
			System.out.println("Your total is: " + fmt.format(subtotal + extraCost + (subtotal * tax)) + ". Your order will be delivered to you within 40 minutes. Thank you!");
		} else if ((selection == 2) && (zipcode <= 60440 || zipcode >= 60452)){
			System.out.println("Your total is: " + fmt.format(subtotal + (subtotal * tax)) + ". Your order will be ready for pick-up in 15 minutes. Thank you!");
		}
		
	}	
}
		
 			
		
	
		
		
		
		


	

	

package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.model.Client;
import com.model.Policy;
import com.service.ClientService;
import com.service.PolicyService;

public class ClientController {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ClientService clientService = new ClientService();
		PolicyService policyService = new PolicyService();
		
		int clientId=-1; // clientId=-1 means no user is logged in
		String name = null;
		
		if(args[0] != null) {
			String loggedInUserId = args[0];
			int id = Integer.parseInt(loggedInUserId); // converting string to int
			
			try {
				Client c1 = clientService.getClient(id);
				clientId = c1.getId();
				name = c1.getClient_name();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		
		System.out.println("HELLO," + name);
		
		while(true) {
			System.out.println("----------CLIENT MENU-------------"); // MAIN MENU
			System.out.println("Press 1. All policies");
			System.out.println("Press 0. exit");
			
			int input = sc.nextInt(); // INPUT FROM USER
			
			if(input == 0) { // FOR EXITING
				System.out.println("Logging out");
				break;
			}
			
			switch(input) {
			
				case 1:
					try {
					List<Policy> p = policyService.getAll();
					System.out.println("ID   NAME   PREMIUM   RATE OF INTEREST");
					for(Policy policy : p) {
						System.out.println(policy.getId() + " | " + policy.getName() + " | " + policy.getPremium() + " | " + policy.getRateOfInterest());
					}
					System.out.println("");
					} catch (SQLException e) {
						System.out.println(e.getMessage());
					}
					break;
					
				default:
						System.out.println("invalid input");
			}
			
		}
	}

	public static void clientMenu(int id) {
		int user_id = id;
		String loggedInUserId = Integer.toString(user_id);
		String[] menu= {""};
		menu[0] = loggedInUserId;
		main(menu);	
	}

}

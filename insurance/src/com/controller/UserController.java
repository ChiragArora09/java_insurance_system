package com.controller;

import java.sql.SQLException;
import java.util.Scanner;

import com.exception.InvalidCredentialsException;
import com.model.Client;
import com.model.User;
import com.service.ClientService;
import com.service.UserService;

public class UserController {

	public static void main(String[] args) {
		UserService userService = new UserService();
		ClientService clientService = new ClientService();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("----------INSURANCE SYSTEM-------------"); // MAIN MENU
			System.out.println("Press 1. Sign up");
			System.out.println("Press 2. Login ");
			System.out.println("Press 0. to Exit");
			
			int input = sc.nextInt(); // INPUT FROM USER
			
			if(input == 0) { // FOR EXITING
				System.out.println("Leaving insurance system");
				break;
			}
			
			switch(input) {
			case 1: // FOR SIGN UP
				System.out.println("Enter username");
				sc.nextLine();
				String username = sc.nextLine();
				System.out.println("Enter password");
				String password = sc.nextLine();
				
				String role = "client"; // default

				User user = new User(username, password, role);
				
				try {
					String status = userService.insert(user); // INSERTION INTO USER TABLE
					if(status == null) {
						System.out.println("Sign up failed");
					} else {                                 // IF INSERTION SUCCESSFUL THEN
						String createdUsername = status;
						
						int userId = userService.getId(createdUsername); // find userid from the grabbed username
						
						System.out.println("-------------- Please complete your profile info ---------------");
							System.out.println("Enter your name");
							String name = sc.nextLine();
							System.out.println("Enter contact info");
							String contactInfo = sc.nextLine();
							
							Client c1 = new Client(name, contactInfo, userId);
							
							try {
								int clientSignupStatus = clientService.insert(c1);
								if(clientSignupStatus == 1) {
									System.out.println("Account successfully created, you can LOGIN now");
								}
							}catch(SQLException e) {
								System.out.println(e.getMessage());
							}
					}
				}catch(SQLException e) {
					System.out.println(e.getMessage());
				}
				break;
				
			case 2: // FOR LOGIN
                try {
					System.out.println("Enter username");
					sc.nextLine();
					String loginUsername = sc.nextLine();
					System.out.println("Enter password");
					String loginPassword = sc.nextLine();
					/* go to DB and check if this credentials are valid, if yes then return object*/
					 
					User userObj = userService.login(loginUsername,loginPassword);
						if(userObj.getRole().equalsIgnoreCase("CLIENT")) {
							ClientController.clientMenu(userObj.getId());
						}
						else{
							AdminController.AdminMenu();
						}
				} catch (SQLException e) {
					 System.out.println(e.getMessage());
				} catch (InvalidCredentialsException e) {
					 System.out.println(e.getMessage());
				}
				break; 
				
			default: 
				 System.out.println("Invalid input given, try again!!!");
				
			}
			
		}
		sc.close();

	}

}

package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.exception.PolicyNotFoundException;
import com.model.Policy;
import com.service.PolicyService;

public class AdminController {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PolicyService policyService = new PolicyService();
		
		System.out.println("");
		System.out.println("_______________________________ADMIN_______________________________");
		System.out.println("");
		
		while(true) { // MAIN MENU
			System.out.println("Press 1. Create Policy");
			System.out.println("Press 2. All Policies");
			System.out.println("Press 3. Get a Policy");
			System.out.println("Press 4. Change Policy data");
			System.out.println("Press 5. Delete Policy");
			System.out.println("Press 6. Activate Policy");
			System.out.println("Press 0. Exit");
			
			int input = sc.nextInt(); // INPUT FROM USER
			
			if(input == 0) { // FOR EXITING
				System.out.println("Logging out");
				break;
			}
			
			switch(input) {
			
				case 1:
					try {
						System.out.println("Enter Policy name");
						sc.nextLine();
						String policyName = sc.nextLine();
						System.out.println("Enter Policy premium");
						double premium = sc.nextDouble();
						System.out.println("Enter rate of interest(%)");
						int rateOfInterest = sc.nextInt();		
						
						Policy p = new Policy(policyName, premium, rateOfInterest);
						int status = policyService.insertPolicy(p);
						
						if(status == 1) {
							System.out.println("Policy created successfully");
						}
						System.out.println("");
					}catch(SQLException e) {
						System.out.println(e.getMessage());
					}
					
					break;
					
				case 2:
					try {
						List<Policy> p = policyService.getAll();
						System.out.println("ID   NAME  PREMIUM  RATE OF INTEREST  ACTIVE");
						for(Policy policy : p) {
							System.out.println(policy.getId() + " | " + policy.getName() + " | " + policy.getPremium() + " | " + policy.getRateOfInterest() + " | " + policy.getIsActive());
						}
						System.out.println("");
					} catch (SQLException e) {
						System.out.println(e.getMessage());
					}
					
					break;
					
				case 3:
					try {
						List<Policy> p = policyService.getAll();
						System.out.println("ID   NAME");
						for(Policy policy : p) {
							System.out.println(policy.getId() + " | " + policy.getName());
						}
						System.out.println("");
						System.out.println("Enter policy id to view the policy in detail");
						int policyId = sc.nextInt();
						
						Policy policy = policyService.getPolicyById(policyId);
						System.out.println("Selected Policy is:");
						System.out.println("ID: " + policy.getId());
						System.out.println("NAME: " + policy.getName());
						System.out.println("RATE OF INTEREST: " + policy.getRateOfInterest());
						System.out.println("PREMIUM: " + policy.getPremium());
						System.out.println("ACTIVE: " + policy.getIsActive());
						System.out.println("");
						
					} catch (SQLException e) {
						System.out.println(e.getMessage());
					} catch (PolicyNotFoundException e) {
						System.out.println(e.getMessage());
					}
					
					break;
					
				case 4:
					try {
						List<Policy> p = policyService.getAll();
						System.out.println("ID   NAME   PREMIUM   RATE OF INTEREST");
						for(Policy policy : p) {
							System.out.println(policy.getId() + " | " + policy.getName() + " | " + policy.getPremium() + " | " + policy.getRateOfInterest() + " | " + policy.getIsActive());
						}
						System.out.println("");
						
						System.out.println("Enter policy ID");
						
						int policyId = sc.nextInt();

						System.out.println("Enter the new values:");
						System.out.println("NAME");
						sc.nextLine();
						String newName = sc.nextLine();
						System.out.println("PREMIUM");
						double newPremium = sc.nextDouble();
						System.out.println("RATE OF INTEREST");
						int newInterest = sc.nextInt();
						
						int status = policyService.updatePolicyData(policyId, newName, newPremium, newInterest);
						if(status==1) {
							System.out.println("Policy data updated successfully");
							System.out.println("");
						}
						
					}catch(SQLException e) {
						System.out.println(e.getMessage());
					}
					
					break;
					
				case 5:
					try {
						List<Policy> p = policyService.getAll();
						System.out.println("ID  NAME  PREMIUM  RATE_OF_INTEREST  ACTIVE");
						for(Policy policy : p) {
							System.out.println(policy.getId() + " | " + policy.getName() + " | " + policy.getPremium() + " | " + policy.getRateOfInterest() + " | " + policy.getIsActive());
						}
						System.out.println("");
						
						System.out.println("Enter policy ID you want to delete");
						
						int policyId = sc.nextInt();
						
						int status = policyService.deactivatePolicy(policyId);
						if(status==1) {
							System.out.println("POLICY " + policyId + " has been deactivated");
						}
						
					}catch(SQLException e) {
						System.out.println(e.getMessage());
					}
					
					break;
					
				case 6:
					try {
						List<Policy> p = policyService.getAll();
						System.out.println("ID  NAME  PREMIUM  RATE_OF_INTEREST  ACTIVE");
						for(Policy policy : p) {
							System.out.println(policy.getId() + " | " + policy.getName() + " | " + policy.getPremium() + " | " + policy.getRateOfInterest() + " | " + policy.getIsActive());
						}
						System.out.println("");
						
						System.out.println("Enter policy ID you want to activate");
						
						int policyId = sc.nextInt();
						
						int status = policyService.activatePolicy(policyId);
						if(status==1) {
							System.out.println("POLICY " + policyId + " has been activated");
						}
					}catch(SQLException e) {
						System.out.println(e.getMessage());
					}
					
					break;
					
				default:
						System.out.println("invalid input");
			}
			
		}

	}

	public static void AdminMenu() {
		String[] menu= {""};
		main(menu);			
	}

}

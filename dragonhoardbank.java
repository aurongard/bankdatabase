/*
CIS 117
Tom Williams
10/22/22
Final Project - Banking Program
*/

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class dragonhoardbank {
	public static Scanner scnr = new Scanner(System.in);
	private static String userFirstName;
	private static String userLastName;
	private static double userAPR;
	private static double userCheckBalance;
	private static double userSaveBalance;
	private static int userAccount;	
	
	public dragonhoardbank() {
		userFirstName = "none";
		userLastName = "none";
		userAPR = 0.00;
		userCheckBalance = 0.00;
		userSaveBalance = 0.00;
		userAccount = 10000;
	}
	public dragonhoardbank(String userFirstName, String userLastName, double userAPR, double userCheckBalance, double userSaveBalance, int userAccount) {
		dragonhoardbank.userFirstName = userFirstName;
		dragonhoardbank.userLastName = userLastName;
		dragonhoardbank.userAPR = userAPR;
		dragonhoardbank.userCheckBalance = userCheckBalance;
		dragonhoardbank.userSaveBalance = userSaveBalance;
		dragonhoardbank.userAccount = userAccount;
	}
	public static String getFirstName() {
		return userFirstName;
	}
	public static String getLastName() {
		return userLastName;
	}
	public static double getAPR() {
		return userAPR;
	}
	public static double getCheckBalance() {
		return userCheckBalance;
	}
	public static double getSaveBalance() {
		return userSaveBalance;
	}
	public static int getUserAccount() {
		return userAccount;
	}
	
	//initial main menu
	public static void menuMain() {
		
		System.out.println("*---------------------------------*");
		System.out.println("|            ***Menu:***          |");
		System.out.println("*---------------------------------*");
		System.out.println("[1] New Account");
		System.out.println("[2] Select Account");
		System.out.println("[3] Account Management");
		System.out.println("[4] Exit Dragonhoard Bank");
		System.out.println("");
	}
	//account menu
	public static void acctMenu() {
		System.out.println("*---------------------------------*");
		System.out.println("|        ***Account Menu:***      |");
		System.out.println("*---------------------------------*");
		System.out.println("[1] Balance Inquiry");
		System.out.println("[2] Transfer Funds");
		System.out.println("[3] Withdrawl Funds");
		System.out.println("[4] Deposit Funds");
		System.out.println("[5] Apply Monthly APR to Account");
		System.out.println("[6] Return to Main Menu Menu");
		System.out.println("");
	}
	
	//account transfer menu
	public static void acctTransfer() {
		System.out.println("*---------------------------------*");
		System.out.println("|       ***Transfer Menu:***      |");
		System.out.println("*---------------------------------*");
		System.out.println("[1] Checking to Savings Account");
		System.out.println("[2] Savings to Checking Account");
		System.out.println("[3] Return to Account Menu");
		System.out.println("");	
	}
	
	//deposit sub menu
	public static void acctDep() {
		System.out.println("*---------------------------------*");
		System.out.println("|        ***Deposit Menu:***      |");
		System.out.println("*---------------------------------*");
		System.out.println("[1] Checking Account");
		System.out.println("[2] Savings Account");
		System.out.println("[3] Return to Account Menu");
		System.out.println("");
	}
	//withdrawal sub menu
	public static void acctWith() {
		System.out.println("*---------------------------------*");
		System.out.println("|      ***Withdrawal Menu:***     |");
		System.out.println("*---------------------------------*");
		System.out.println("[1] Checking Account");
		System.out.println("[2] Savings Account");
		System.out.println("[3] Return to Account Menu");
		System.out.println("");
	}
	
	//APR sub menu
	public static void acctAPR() {
		System.out.println("*---------------------------------*");
		System.out.println("|           ***APR Menu:***       |");
		System.out.println("*---------------------------------*");
		System.out.println("[1] Checking Account");
		System.out.println("[2] Savings Account");
		System.out.println("[3] Return to Account Menu");
		System.out.println("");
	}
	//debug account for testing.
	public static void tempAcct() {
		userFirstName = "Tad";
		userLastName = "Cooper";
		userCheckBalance = 1000.00;
		userSaveBalance = 1000.00;
		userAccount = 10010;
		userAPR = 0.06;	
	}
	//The new account menu option
	public static void newAcct(int accountNO) {	
		userAccount = accountNO;
	}
	public static void newAcctFN() {
		System.out.println("Please enter your first name and press enter to continue:");
		userFirstName = scnr.nextLine();
	}
	public static void newAcctLN() {
		System.out.println("Please enter your last name and press enter to continue:");
		userLastName = scnr.nextLine();
	}
	
	public static void newAcctCB() {
		System.out.println("Please enter your checking account starting balance and press enter to continue:");
		userCheckBalance = scnr.nextDouble();
	}
	
	public static void newAcctSB() {
		try {
			System.out.println("Please enter your savings account starting balance and press enter to continue:");
			userSaveBalance = scnr.nextDouble();
		}
		catch (InputMismatchException e) {
			System.out.println("Not a valid deposit amount.");
		}
	}
		
	//Sub Menu for selecting account APR
	public static void newAcctAPR() {
		int choice = 0;
		while (choice < 1 || choice >3) {
			System.out.println("Select account APR and press enter to continue:");
			System.out.println("[1] 2%");
			System.out.println("[2] 4%");
			System.out.println("[3] 6%");
			System.out.println("");
			choice = scnr.nextInt();
			
			if (choice == 1) {
				userAPR = 0.02;
			}
			else if (choice == 2) {
				userAPR = 0.04;
			}
			else if (choice == 3) {
				userAPR = 0.06;
			}
			else {
				newAcctAPR();
				choice = 0;
			}
		}
	}
	//Balance Inquiry function.
	public static void acctBal() {
		System.out.println("Account Balance Inquiry:");
		System.out.println("Account Name: " + userLastName + ", " + userFirstName);
		System.out.println("Account Number: DH-" + userAccount);
		System.out.print("Checking Account Balance: $");
		System.out.printf("%.2f", userCheckBalance);
		System.out.println();
		System.out.print("Savings Account Balance: $");
		System.out.printf("%.2f", userSaveBalance);
		System.out.println();
		System.out.print("Account APR: ");
		
		if (userAPR == 0.02) {
			System.out.print("2%");
		}
		else if (userAPR == 0.04) {
			System.out.print("4%");
		}
		else if (userAPR == 0.06) {
			System.out.print("6%");
		}
		else {
			System.out.print("null");
		}
		System.out.println();
	}
	//calls the program to end
	public static void exit(int status) {	
		}
	
	public static void main(String[] args) throws Exception {
		
		Scanner scnr = new Scanner (System.in);
		final int MAXUSERS = 5;
		int userCount = 1;
		int choiceMain = 0;
		int choiceAcct = 0;
		int choiceSubAcct = 0;
		int accountNO = 10011;
		int acctSelect = 0;
		
		ArrayList<String> arrFirstName = new ArrayList<String>(MAXUSERS);
		ArrayList<String> arrLastName = new ArrayList<String>(MAXUSERS);
		ArrayList<Double> arrCheckBal = new ArrayList<Double>(MAXUSERS);
		ArrayList<Double> arrSaveBal = new ArrayList<Double>(MAXUSERS);
		ArrayList<Integer> arrAcctNo = new ArrayList<Integer>(MAXUSERS);
		ArrayList<Double> arrAPR = new ArrayList<Double>(MAXUSERS);		
		
		//tempAcct is used to test a user variable without entering a new account each time.
		tempAcct();	
		
		System.out.println("Welcome to the Dragon's Hoard Bank.");
		
		menuMain();
		
		//Adds a test entry into the ArrayLists
		arrFirstName.add(userFirstName); 
		arrLastName.add(userLastName);
		arrCheckBal.add(userCheckBalance);
		arrSaveBal.add(userSaveBalance);
		arrAcctNo.add(userAccount);
		arrAPR.add(userAPR);
		
		while (choiceMain < 1 || choiceMain > 4) {
			System.out.print("Please enter your selection and press enter: ");
			choiceMain = scnr.nextInt();
			System.out.println();
			
			//new account choice
			if (choiceMain == 1) {
				System.out.println("Let's open a new account!");
				if (userCount < MAXUSERS) {
					scnr.nextLine();
					newAcct(accountNO);
					newAcctFN();
					newAcctLN();
					newAcctCB();
					newAcctSB();
					newAcctAPR();
					System.out.println("Account Creation Complete!");					
					
					//add save functionality here.
					
					++accountNO;
					++userCount;
										
					arrFirstName.add(userFirstName); 
					arrLastName.add(userLastName);
					arrCheckBal.add(userCheckBalance);
					arrSaveBal.add(userSaveBalance);
					arrAcctNo.add(userAccount);
					arrAPR.add(userAPR);
					
					choiceMain = 0;
					menuMain();

				}
				else {
					System.out.println("No free space available");
					
					choiceMain = 0;
					menuMain();

				}
			}
			//account selection menu
			else if (choiceMain == 2) {
				int userElements;
				int i;
								
				userElements = arrFirstName.size();
				if (userElements > 0) {
					System.out.println("*---------------------------------*");
					System.out.println("|        ***Select Account:***    |");
					System.out.println("*---------------------------------*");
					for (i = 0; i < userElements; ++i) {
						System.out.println("[" + (i + 1) + "] Account No: DH-" + arrAcctNo.get(i) + ", Account Name: " + arrLastName.get(i) + ", " + arrFirstName.get(i));
					}
					System.out.print("[" + (i + 1) + "] Return to Main Menu.");
				}
					else {
					System.out.println("There are no available accounts at this time.");
					
				}
				
				while (choiceAcct < 1 || choiceAcct > userElements) {
					System.out.println();
					System.out.println("Please enter your selection and press enter: ");
					choiceAcct = scnr.nextInt();
					acctSelect = (choiceAcct - 1);
					
					if (choiceAcct <= userElements) {
						userFirstName = arrFirstName.get(acctSelect);
						userLastName = arrLastName.get(acctSelect);
						userSaveBalance = arrSaveBal.get(acctSelect);
						userCheckBalance = arrCheckBal.get(acctSelect);
						userAccount = arrAcctNo.get(acctSelect);
						userAPR = arrAPR.get(acctSelect);
						
						//
						//add save function for acctSelect here
						//
					
						System.out.println("You have selected account: DH" + userAccount);
						System.out.println();
						
						choiceAcct = 0;
						choiceMain = 0;
						acctSelect = 0;
						menuMain();
						break;
					}
					else if (choiceAcct == (userElements + 1)) {
						choiceAcct = 0;
						choiceMain = 0;
						menuMain();

					}
				}					
			}
			
			
			//Account Management Menu Choice
			else if (choiceMain == 3) {
				acctMenu();
				
				while (choiceAcct < 1 || choiceAcct > 6) {
					System.out.print("Please enter your selection and press enter: ");
					choiceAcct = scnr.nextInt();
					System.out.println();
					
					//account balance inquiry
					if (choiceAcct == 1) {
						acctBal();
						System.out.println();
						
						while (choiceSubAcct < 1 || choiceSubAcct > 1) {
							System.out.println("[1] Return to Account Menu");
							System.out.print("Please enter your selection and press enter: ");
							choiceSubAcct = scnr.nextInt();
							System.out.println();
							
							if (choiceSubAcct == 1) {
								choiceSubAcct = 0;
								choiceAcct = 0;
								
								acctMenu();
								break;
							}
							else {
								choiceSubAcct = 0;
							}
						}
					}
					
					//transfer funds
					if (choiceAcct == 2) {
						acctTransfer();
						
						while (choiceSubAcct < 1 || choiceSubAcct > 3) {
							System.out.print("Please enter your selection and press enter: ");
							choiceSubAcct = scnr.nextInt();
							System.out.println();
							
							//transfers Checking to savings
							if (choiceSubAcct == 1) {
								System.out.print("Enter amount to be transfered to Savings: ");
								double transfer = scnr.nextDouble();
								System.out.println();
								
								if (transfer < 0.00) {
									System.out.println("Invalid Amount. ");
									choiceSubAcct = 0;
									acctTransfer();
								}
								
								else if (transfer > userCheckBalance) {
									System.out.println("Invalid Amount. ");
									choiceSubAcct = 0;
									acctTransfer();
								}
								
								else if (transfer <= userCheckBalance) {
									userSaveBalance += transfer;
									userCheckBalance -= transfer;
									
									arrSaveBal.set((userAccount - 10010), userSaveBalance);
									arrCheckBal.set((userAccount - 10010),  userCheckBalance);
									
									System.out.print("Transfer Succesful! " );
									System.out.print("Your new Checking Balance is: $");
									System.out.printf("%.2f", userCheckBalance);
									System.out.println();
									System.out.print("Your new Savings Balance is: $");
									System.out.printf("%.2f", userSaveBalance);
									System.out.println();
									
									acctWith();	
									choiceSubAcct = 0;
								}
								else {
									System.out.print("Insufficient Funds. ");
									choiceSubAcct = 0;
									acctWith();
								}
							}
							
							//transfers savings to checking
							if (choiceSubAcct == 2) {
								System.out.print("Enter amount to be transfered to Checking: ");
								double transfer = scnr.nextDouble();
								System.out.println();
								
								if (transfer < 0.00) {
									System.out.println("Invalid Amount. ");
									choiceSubAcct = 0;
									acctTransfer();
								}
								
								else if (transfer > userSaveBalance) {
									System.out.println("Invalid Amount. ");
									choiceSubAcct = 0;
									acctTransfer();
								}
								
								else if (transfer <= userSaveBalance) {
									userSaveBalance -= transfer;
									userCheckBalance += transfer;
									
									arrSaveBal.set((userAccount - 10010), userSaveBalance);
									arrCheckBal.set((userAccount - 10010),  userCheckBalance);
									
									System.out.print("Transfer Succesful! " );
									System.out.print("Your new Checking Balance is: $");
									System.out.printf("%.2f", userCheckBalance);
									System.out.println();
									System.out.print("Your new Savings Balance is: $");
									System.out.printf("%.2f", userSaveBalance);
									System.out.println();
									
									acctWith();	
									choiceSubAcct = 0;
								}
								else {
									System.out.print("Insufficient Funds. ");
									choiceSubAcct = 0;
									acctWith();
								}
							}
							
							//exit transfer menu
							else if (choiceSubAcct == 3) {
								choiceSubAcct = 0;
								choiceAcct = 0;
								
								acctMenu();
								break;
							}
							//rejects invalid entries.
							else {
								choiceSubAcct = 0;
							}
						}
					}
					
					//withdrawal funds
					if (choiceAcct == 3) {
						
						acctWith();
						
						while (choiceSubAcct < 1 || choiceSubAcct > 3) {
							System.out.print("Please enter your selection and press enter: ");
							choiceSubAcct = scnr.nextInt();
							System.out.println();
							
							//checking withdrawal
							if (choiceSubAcct == 1) {
								System.out.print("Enter amount to be withdrawn: ");
								double withdrawal = scnr.nextDouble();
								System.out.println();
								
								if (withdrawal < 0.00) {
									System.out.println("Invalid Amount. ");
									choiceSubAcct = 0;
									acctWith();
								}
								
								else if (withdrawal < userCheckBalance) {
									userCheckBalance -= withdrawal;
									arrCheckBal.set((userAccount - 10010),  userCheckBalance);
									
									System.out.print("Withdrawal Succesful! " );
									System.out.print("Your new Checking Balance is: $");
									System.out.printf("%.2f", userCheckBalance);
									System.out.println();
									
									acctWith();	
									choiceSubAcct = 0;
									
									}
								
								else {
									System.out.print("Insufficient Funds. ");
									choiceSubAcct = 0;
									acctWith();
								}
							}
							
							//savings withdrawal
							else if (choiceSubAcct == 2) {
								System.out.print("Enter amount to be withdrawn: ");
								double withdrawal = scnr.nextDouble();
								System.out.println();
								
								if (withdrawal < 0.00) {
									System.out.println("Invalid Amount. ");
									choiceSubAcct = 0;
									acctWith();
								}
								
								else if (withdrawal < userSaveBalance) {
									userSaveBalance -= withdrawal;
									arrSaveBal.set((userAccount - 10010), userSaveBalance);
																		
									System.out.print("Withdrawal Succesful! " );
									System.out.print("Your new Checking Balance is: $");
									System.out.printf("%.2f", userSaveBalance);
									System.out.println();
									
									acctWith();	
									choiceSubAcct = 0;
									
									}
								
								else {
									System.out.print("Insufficient Funds. ");
									choiceSubAcct = 0;
									acctWith();
								}
							}
							//exit withdrawal menu
							else if (choiceSubAcct == 3) {
								choiceSubAcct = 0;
								choiceAcct = 0;
								
								acctMenu();
								break;
							}
							//rejects invalid entries.
							else {
								choiceSubAcct = 0;
							}
						}
					}
					
					//deposit funds
					if (choiceAcct == 4) {
						
						acctDep();
						
						while (choiceSubAcct < 1 || choiceSubAcct > 3) {
							System.out.print("Please enter your selection and press enter: ");
							choiceSubAcct = scnr.nextInt();
							System.out.println();
							
							if (choiceSubAcct == 1) {
								System.out.print("Enter amount to be deposited: ");
								double deposit = scnr.nextDouble();
								System.out.println();
								
								if (deposit < 0.00) {
									System.out.println("Invalid Amount. ");
									choiceSubAcct = 0;
									acctDep();
								}
								
								else if (deposit < userCheckBalance) {
									userCheckBalance += deposit;
									arrCheckBal.set((userAccount - 10010),  userCheckBalance);
									
									System.out.print("Deposit Succesful! " );
									System.out.print("Your new Checking Balance is: $");
									System.out.printf("%.2f", userCheckBalance);
									System.out.println();
									
									acctDep();	
									choiceSubAcct = 0;
									
									}
								
								else {
									System.out.print("Insufficient Funds. ");
									choiceSubAcct = 0;
									acctDep();
								}
							}
							
							
							else if (choiceSubAcct == 2) {
								System.out.print("Enter amount to be deposited: ");
								double deposit = scnr.nextDouble();
								System.out.println();
								
								if (deposit < 0.00) {
									System.out.println("Invalid Amount. ");
									choiceSubAcct = 0;
									acctDep();
								}
								
								else if (deposit < userSaveBalance) {
									userSaveBalance += deposit;
									arrSaveBal.set((userAccount - 10010), userSaveBalance);
									
									System.out.print("Deposit Succesful! " );
									System.out.print("Your new Checking Balance is: $");
									System.out.printf("%.2f", userSaveBalance);
									System.out.println();
									
									acctDep();	
									choiceSubAcct = 0;
									
									}
								
								else {
									System.out.print("Insufficient Funds. ");
									choiceSubAcct = 0;
									acctDep();
								}
							}
							//exit withdrawal menu
							else if (choiceSubAcct == 3) {
								choiceSubAcct = 0;
								choiceAcct = 0;
								
								acctMenu();
								break;
							}
							//rejects invalid entries.
							else {
								choiceSubAcct = 0;
							}
						}
					}
					//apply monthly APR 
					if (choiceAcct == 5) {
						
						acctAPR();
						
						while (choiceSubAcct < 1 || choiceSubAcct > 3) {
							System.out.print("Please enter your selection and press enter: ");
							choiceSubAcct = scnr.nextInt();
							System.out.println();
							
							if (choiceSubAcct == 1) {
								double calcAPR = 1.00;
								calcAPR += userAPR;
								userCheckBalance *= calcAPR;
								arrCheckBal.set((userAccount - 10010),  userCheckBalance);
								
								System.out.print("Monthly APR Applied Succesfully! " );
								System.out.print("Your new Checking Balance is: $");
								System.out.printf("%.2f", userCheckBalance);
								System.out.println();
								
								acctAPR();	
								choiceSubAcct = 0;
							}
							
							else if (choiceSubAcct == 2) {
								double calcAPR = 1.00;
								calcAPR += userAPR;
								userSaveBalance *= calcAPR;
								arrSaveBal.set((userAccount - 10010), userSaveBalance);
								
								System.out.print("Monthly APR Applied Succesfully! " );
								System.out.print("Your new Savings Balance is: $");
								System.out.printf("%.2f", userSaveBalance);
								System.out.println();
								
								acctAPR();	
								choiceSubAcct = 0;
									
							}

							//exit APR menu
							else if (choiceSubAcct == 3) {
								choiceSubAcct = 0;
								choiceAcct = 0;
								
								acctMenu();
								break;
							}
							//rejects invalid entries.
							else {
								choiceSubAcct = 0;
							}
						}
					}
					
					//exits account management menu
					else if (choiceAcct == 6) {
						
						choiceMain = 0;
						choiceAcct = 0;
						menuMain();
						break;
						
					}
					
					else {
						choiceAcct = 0;
					}
				}
			}
			//calls program to end
			else if (choiceMain == 4) {
				System.exit(0);
			}
			else {
				choiceMain = 0;
			}
		}
		scnr.close();
	}
}


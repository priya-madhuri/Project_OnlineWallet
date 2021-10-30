package com.cg.app;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import com.cg.app.exception.InvalidEntry;
import com.cg.app.model.WalletAccount;
import com.cg.app.model.WalletTransaction;
import com.cg.app.service.WalletAccountService;
import com.cg.app.service.WalletAccountServiceImpl;

public class App {

	static WalletAccountService walletService=new WalletAccountServiceImpl();
	static Scanner in= new Scanner(System.in);
	public static void main(String[] args) throws Exception {

		WalletAccount ac1=new WalletAccount(111,10000,9866345987L,"Ankita",Arrays.asList(new WalletTransaction(Math.abs(new Random().nextLong()),"Account created with initial deposit of Rs.10000")));
		walletService.addAccount(ac1);

		WalletAccount ac2=new WalletAccount(222,20000,9498735623L,"Sruthi",Arrays.asList(new WalletTransaction(Math.abs(new Random().nextLong()),"Account created with initial deposit of Rs.20000")));
		walletService.addAccount(ac2);

		WalletAccount ac3=new WalletAccount(333,30000,9673595421L,"Kirti",Arrays.asList(new WalletTransaction(Math.abs(new Random().nextLong()),"Account created with initial deposit of Rs.30000")));
		walletService.addAccount(ac3);

		for(;;) {
		int choice;
		System.out.println("Enter your choice : ");
		System.out.println("1 - Create Account: ");
		System.out.println("2 - Add Amount:");
		System.out.println("3 - Transfer Funds: ");
		System.out.println("4 - Check Account Balance with details:");
		System.out.println("5 - Exit");
		
		
		choice=in.nextInt();
		switch (choice) {
		case 4:
			try{
				getAccountInfo();
			
			}catch(InvalidEntry ie) {
				System.err.println("Incorrect id");
			}
			break;
		case 2:
			addAmount();
			break;
		case 3: 
			sendAmount();
			break;
		case 1: addAcccount();
			break;
		case 5: System.exit(0);
			break;
		default:
			System.out.println("Invalid Choice");
			break;
		}
		
		}
		
	}

	private static void addAmount() throws InvalidEntry{
		
		System.out.println("Enter wallet id(only digits) :");
		long id=in.nextLong();
		
		if(walletService.getAccountInfo(id)!=null) {
			System.out.println("Enter Amount ");
			float amount=in.nextFloat();
			walletService.addAmount(id, amount);
		}
		else{
				try {
					throw new InvalidEntry("Account already exists");
				} catch (Exception e) {
					//TODO: handle exception
					System.err.println("ID doesn't exists");
				}
			}		
	}

	private static void sendAmount() throws Exception{
		if (true) {
			try {
				System.out.println("Enter wallet id of sender: ");
				long id1=in.nextLong();
				if(walletService.getAccountInfo(id1)==null) {
					throw new InvalidEntry("ID invalid");
				}
				System.out.println("Enter wallet id of reciever: ");
				long id2=in.nextLong();
				if(walletService.getAccountInfo(id2)==null) {
					throw new InvalidEntry("ID invalid");
				}
				System.out.println("Enter Amount: ");
				float amount=in.nextFloat();
				walletService.sendAmount(id1,id2,amount);
				System.out.println("Transaction Completed");			
			} catch (Exception e) {
				//TODO: handle exception
				System.err.println("Invalid sender ID or Reciever ID");
			}
		} else {
			throw new InvalidEntry("Could not add the money");
		}
		
	}
		
	//Check Balance and details
	private static void getAccountInfo() {
		System.out.println("Enter wallet id :");
		long id=in.nextLong();
		if(walletService.getAccountInfo(id)==null) {
			throw new InvalidEntry("");
		}
		WalletAccount acc=walletService.getAccountInfo(id);
		System.out.println("Account Id : "+acc.getWalletId());
		System.out.println("Current balance : "+acc.getBalance());
		System.out.println("Recent transactions: ");
		acc.getTransactions().stream().forEach(t->System.out.println(t));
		
	}
	public static void addAcccount() throws Exception{
		System.out.println("Create Account: ");
		Scanner s =new Scanner(System.in);
		System.out.println("Enter ID: ");
		long id = s.nextLong();
		if(walletService.getAccountInfo(id)==null) {
			System.out.println("Enter Balance: ");
			float bal = s.nextFloat();
			System.out.println("Enter phone number: ");
			long phone = s.nextLong();
			System.out.println("Enter name: ");
			String name = s.next()+s.nextLine();
			WalletAccount ac=new WalletAccount(id,bal,phone,name,Arrays.asList(new WalletTransaction(Math.abs(new Random().nextLong()),"Account created with initial deposit of Rs."+bal)));

			System.out.println(walletService.addAccount(ac));
		}
		else{
			try {
				throw new InvalidEntry("");
			} catch (InvalidEntry e) {
				//TODO: handle exception
				System.err.println("Account already exists");
			}
			}
		
		
		
	}
}
package com.cg.app.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.cg.app.exception.InvalidEntry;
import com.cg.app.model.WalletAccount;
import com.cg.app.model.WalletTransaction;

public class WalletAccountDaoImpl implements WalletAccountDao {
	
Map<Long, WalletAccount> walletAccounts=new HashMap<>();
	
	public WalletAccountDaoImpl() {
		addSomeWalletAccount();
	}
	public void addSomeWalletAccount() {
		WalletAccount ac1=new WalletAccount(1001121312L,2000.0F,99586566L,"Ankita",
					Arrays.asList(new WalletTransaction(1012121L,"Added Rs.1200"),
							new WalletTransaction(1012115L,"Added Rs.200"),
							new WalletTransaction(1012125L,"Added Rs.600")));
		WalletAccount ac2=new WalletAccount(10011213021L,1000.0F,99586562L,"Akhil",
				Arrays.asList(new WalletTransaction(10125323L,"Added Rs.1500")));
		
		walletAccounts.put(ac1.getWalletId(), ac1);
		walletAccounts.put(ac2.getWalletId(), ac2);
	}

	@Override
	public boolean addWalletAccount(WalletAccount account) {
		
		
		if(walletAccounts.containsKey(account)) {
			return false;
		}
		walletAccounts.put(account.getWalletId(), account);
		
		return true;
	}

	@Override
	public WalletAccount getWalletAccountById(long id) {
		try{return walletAccounts.get(id);}
			catch(InvalidEntry e)
		{
			System.out.println("Incorrect entry id ");	
		}
		
		return walletAccounts.get(id);
	}

	@Override
	public boolean updateWalletAccount(WalletAccount account) {
		if(!walletAccounts.containsKey(account.getWalletId())) {
			return false;
		}
		WalletAccount accountToUpdate=walletAccounts.get(account.getWalletId());
		accountToUpdate.setBalance(account.getBalance());
		return true;
	}

	@Override
	public boolean addAmount(long id,float amount) {
		
		if(!(walletAccounts.containsKey(id)) ){
			return false;
		}
		if(amount>0) {
		WalletAccount acc=walletAccounts.get(id);
		WalletTransaction tx=new WalletTransaction();
		tx.setTransactionId(Math.abs(new Random().nextLong()));
		// tx.setTransactionDate(LocalDate.now());
		tx.setTransactionDetails("Rs. "+amount+" Added..");
		List<WalletTransaction> trns=new ArrayList<WalletTransaction>();
		for(WalletTransaction t:acc.getTransactions()) {
			trns.add(t);
		}
		trns.add(tx);
		acc.setTransactions(trns);
		
		acc.setBalance(acc.getBalance()+amount);
		
		return true;
		
		}
		return false;
	}

	@Override
	public boolean sendAmount(long id1,long id2,float amount) {
		
		if(!((walletAccounts.containsKey(id1) || (walletAccounts.containsKey(id2))))) {
			return false;
		}
		WalletAccount acc1=walletAccounts.get(id1);
		WalletAccount acc2=walletAccounts.get(id2);
		if(amount>acc1.getBalance()){
			System.out.println("Insufficient Funds");
			return false;
		}
		if(amount<0){
			System.out.println("Enter valid Amount");
			return false;
		}
		if(amount>0 && amount<acc1.getBalance()) {
		WalletTransaction tx1=new WalletTransaction();
		WalletTransaction tx2=new WalletTransaction();
		tx1.setTransactionId(Math.abs(new Random().nextLong()));
		// tx.setTransactionDate(LocalDate.now());
		tx1.setTransactionDetails("Rs. "+amount+" Debited..");
		List<WalletTransaction> trns1=new ArrayList<WalletTransaction>();
		for(WalletTransaction t:acc1.getTransactions()) {
			trns1.add(t);
		}
		trns1.add(tx1);
		acc1.setTransactions(trns1);
		
		acc1.setBalance(acc1.getBalance()-amount);
		
		tx2.setTransactionDetails("Rs. "+amount+" Credited..");
		List<WalletTransaction> trns2=new ArrayList<WalletTransaction>();
		for(WalletTransaction t:acc2.getTransactions()) {
			trns2.add(t);
		}
		trns2.add(tx2);
		acc2.setTransactions(trns2);
		
		acc2.setBalance(acc2.getBalance()+amount);	
		return true;
		}
		return false;
	}

}
package com.cg.app.model;

import java.util.ArrayList;
import java.util.List;

public class WalletAccount {

	long walletId;
	float balance;
	long phone;
	String userName;
	List<WalletTransaction> transactions=new ArrayList<WalletTransaction>();
	public WalletAccount() {
		// TODO Auto-generated constructor stub
	}
	public long getWalletId() {
		return walletId;
	}
	public void setWalletId(long walletId) {
		this.walletId = walletId;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public List<WalletTransaction> getTransactions() {
		return transactions;
	}
	public void setTransactions(List<WalletTransaction> transactions) {
		this.transactions = transactions;
	}
	public WalletAccount(long walletId, float balance, long phone, String userName,
			List<WalletTransaction> transactions) {
		super();
		this.walletId = walletId;
		this.balance = balance;
		this.phone = phone;
		this.userName = userName;
		this.transactions = transactions;
	}
	@Override
	public String toString() {
		return "WalletAccount [walletId=" + walletId + ", balance=" + balance + ", phone=" + phone + ", userName="
				+ userName + ", transactions=" + transactions + "]";
	}
	
	
	
	
}
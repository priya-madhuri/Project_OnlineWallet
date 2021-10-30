package com.cg.app.model;

public class WalletTransaction {
	long transactionId;
	// LocalDate transactionDate;
	String transactionDetails;
	
	public String getTransactionDetails() {
		return transactionDetails;
	}
	public void setTransactionDetails(String transactionDetails) {
		this.transactionDetails = transactionDetails;
	}
	public WalletTransaction() {
		// TODO Auto-generated constructor stub
	}
	public WalletTransaction(long transactionId,  String transactionDetails) {
		super();
		this.transactionId = transactionId;
		// this.transactionDate = transactionDate;
		this.transactionDetails = transactionDetails;
	}

	
	@Override
	public String toString() {
		return "WalletTransaction [transactionId=" + transactionId + 
				 ", transactionDetails=" + transactionDetails + "]";
	}
	public long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}
	// public LocalDate getTransactionDate() {
	// 	return transactionDate;
	// }
	// public void setTransactionDate(LocalDate transactionDate) {
	// 	this.transactionDate = transactionDate;
	// }
	
	
}
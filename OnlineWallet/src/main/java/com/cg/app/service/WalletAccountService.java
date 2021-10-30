package com.cg.app.service;

import com.cg.app.exception.InvalidEntry;
import com.cg.app.model.WalletAccount;

public interface WalletAccountService {

public WalletAccount getAccountInfo(long id) throws InvalidEntry;
	
	public boolean addAmount(long id, float amount)throws InvalidEntry;
	
	public String addAccount(WalletAccount ac)throws InvalidEntry;

	public boolean sendAmount(long id1,long id2, float amount)throws InvalidEntry;
}
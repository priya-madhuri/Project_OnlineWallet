package com.cg.app.dao;

import com.cg.app.model.WalletAccount;

public interface WalletAccountDao {

	public boolean addWalletAccount(WalletAccount account);
	public WalletAccount getWalletAccountById(long id) ;
	public boolean updateWalletAccount(WalletAccount account);
	public boolean addAmount(long id,float amount);
	public boolean sendAmount(long id1,long id2,float amount);
	
}
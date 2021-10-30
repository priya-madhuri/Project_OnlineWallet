package com.cg.app.service;

import com.cg.app.dao.WalletAccountDao;
import com.cg.app.dao.WalletAccountDaoImpl;
import com.cg.app.model.WalletAccount;

public class WalletAccountServiceImpl implements WalletAccountService {

	
	WalletAccountDao walletDao=new WalletAccountDaoImpl();
	@Override
	
		public WalletAccount getAccountInfo(long id) {
			
			return walletDao.getWalletAccountById(id);
		}
	
	

	@Override
	public boolean addAmount(long id, float amount) {
		if(amount>0) {
			if(walletDao.addAmount(id, amount)==false){
			System.out.println("Id incorrect");
			}
			else {
				System.out.println("Amount Credited");
				return true;
			}
		}
		else{
			System.err.println("Invalid Amount\n");
			return false;
		}	
		return false;	
	}
	
	@Override
	public boolean sendAmount(long id1,long id2, float amount) {
		
		return walletDao.sendAmount(id1,id2, amount);		
		
	}

	public String addAccount(WalletAccount ac) {
		if(!(walletDao.addWalletAccount(ac)==true)) {
			return "Could not Add Account";
		}
		return"Account Added Successfully";
	}
}
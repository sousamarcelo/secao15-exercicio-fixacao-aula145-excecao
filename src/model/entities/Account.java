package model.entities;

import model.exceptions.DomainException;

public class Account {
	
	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLlimit;
	
	public Account() {
	}

	public Account(Integer number, String holder, Double balance, Double withdrawLlimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLlimit = withdrawLlimit;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getWithdrawLlimit() {
		return withdrawLlimit;
	}

	public void setWithdrawLlimit(Double withdrawLlimit) {
		this.withdrawLlimit = withdrawLlimit;
	}
	
	public Double getBalance() {
		return balance;
	}
	
	public void deposit(Double amount) {
		balance += amount;
	}
	
	public void withdraw(Double amount) throws DomainException {
		if (amount > getWithdrawLlimit()) {
			throw new DomainException("The amount exceeds withdraw limit");
		}
		
		if (amount > getBalance()) {
			throw new DomainException("Not enough balance");
		}		
		
		balance -= amount;
	}
	
	@Override
	public String toString() {		
		return "New balance: " + String.format("%.2f", getBalance()) ;
	}
	

}

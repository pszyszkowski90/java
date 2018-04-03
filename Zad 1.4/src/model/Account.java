package model;

import java.util.ArrayList;
import java.util.Date;

public class Account {
	private String number;
	private String name;
	private String surname;
	private double account_balance;
	private ArrayList<Operation> operationList = new ArrayList<Operation>();
	
	public Account(String number, String name, String surname, double account_balance) {
		this.number = number;
		this.name = name;
		this.surname = surname;
		this.account_balance = account_balance;
	}
	
	public void cashPayoff(double howMuch){
		account_balance = account_balance - howMuch;			
		operationList.add(new Operation ("Wyp³ata\t", number, "Brak", howMuch, new Date()));
	}
	public void cashPayment(double howMuch) {
		account_balance = account_balance + howMuch;			
		operationList.add(new Operation ("Wp³ata\t\t", "Brak\t", number, howMuch, new Date()));
	}
	public void incomingTransfer(double howMuch, Account from) {
		account_balance = account_balance + howMuch;			
		operationList.add(new Operation ("Przelew przychodz¹cy", from.getNumber(), number, howMuch, new Date()));
	}
	public void outgoingTransfer(double howMuch, Account where) {
		account_balance = account_balance - howMuch;
		where.incomingTransfer(howMuch, this);
		operationList.add(new Operation ("Przelew wychodz¹cy", number, where.getNumber(), howMuch, new Date()));
	}
	
	public ArrayList<Operation> getHistory (Date from, Date to){
		ArrayList<Operation> returnList = new ArrayList<Operation>();
		for (Operation operation : operationList) {
			if (from.getTime() <= operation.getWhen().getTime() && to.getTime() >= operation.getWhen().getTime()) {
				returnList.add(operation);
			}
		}
		return returnList;	
	}
	
	public void printHistory (Date from, Date to) {
		ArrayList<Operation> tmpList = getHistory(from, to);
		System.out.println("Historia operacji dla konta " + number + ", którego w³aœcicielem jest " + name + " " + surname + ":" );
		if (tmpList.size() > 0) {
			System.out.println("\n|DATA \t\t\t| TYP OPERACJI \t\t| KWOTA \t| RACHUNEK ZRODLOWY \t| RACHUNEK DOCELOWY \t");
			System.out.println("________________________________________________________________________________________________");
			for (Operation operation : tmpList) {
				Operation.printOperation(operation);		    
			}
		} else System.out.println("Brak operacji w podanym zakresie dat");
	}
	
	public String getNumber() {
		return number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public double getAccount_balance() {
		return account_balance;
	}

	public void setAccount_balance(double account_balance) {
		this.account_balance = account_balance;
	}	
}

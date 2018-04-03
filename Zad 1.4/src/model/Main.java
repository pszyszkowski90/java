package model;

import java.util.Date;

public class Main {
	public static void main(String[] args){
		Account account1 = new Account("123456789", "Jan", "Kowalski", 1000);
		Account account2 = new Account("987654321", "Janina", "Nowak", 5000);
		
		account1.cashPayment(1000);
		account1.cashPayoff(300);
		account1.outgoingTransfer(500, account2);
		account2.outgoingTransfer(400, account1);
		
		System.out.println("Kwota na koncie "+account1.getNumber()+": "+ account1.getAccount_balance());
		System.out.println("Kwota na koncie "+account2.getNumber()+": "+account2.getAccount_balance() + "\n");
		
		account1.printHistory(new Date(118, 3, 3, 18, 10), new Date());
		System.out.println("\n\n");	
		
		account2.printHistory(new Date(118, 3, 3, 18, 10), new Date());
		System.out.println("\n\n");
		
		account1.printHistory(new Date(118, 3, 3, 18, 10), new Date(118, 3, 3, 18, 50));
		System.out.println("\n\n");	
		
		account1.getHistory(new Date(118, 3, 3, 18, 10), new Date());
		account2.getHistory(new Date(118, 3, 3, 18, 10), new Date());
	}
}

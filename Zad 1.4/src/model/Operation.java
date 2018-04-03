package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Operation {
	private String type;
	private String from;
	private String where;
	private double howMuch;
	private Date when;
	
	public Operation(String type, String from, String where, double howMuch, Date date) {
		this.type = type;
		this.from = from;
		this.where = where;
		this.howMuch = howMuch;
		this.when = date;		
	}
	
	public static void printOperation(Operation operation){
		System.out.println("|"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(operation.getWhen())+"\t|"+operation.getType()+"\t|"+operation.getHowMuch()+"\t\t|"+operation.getFrom()+"\t\t|"+operation.getWhere());
	}

	public String getType() {
		return type;
	}

	public String getFrom() {
		return from;
	}

	public String getWhere() {
		return where;
	}

	public double getHowMuch() {
		return howMuch;
	}

	public Date getWhen() {
		return when;
	}	
}

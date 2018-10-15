package com.aman.dbTransaction;

public class Transaction {

	int id;
	String nameoncard;
	String cardtype;
	String CardNumber;
	double UnitPrice;
	int Quantity;
	double TotalPrice;
	String ExpDate;
	String CreatedOn;
	String CreatedBy;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameoncard() {
		return nameoncard;
	}

	public void setNameoncard(String nameoncard) {
		this.nameoncard = nameoncard;
	}

	public String getCardtype() {
		return cardtype;
	}

	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}

	public String getCardNumber() {
		return CardNumber;
	}

	public void setCardNumber(String cardNumber) {
		CardNumber = cardNumber;
	}

	public double getUnitPrice() {
		return UnitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		UnitPrice = unitPrice;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	public double getTotalPrice() {
		return TotalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		TotalPrice = totalPrice;
	}

	public String getExpDate() {
		return ExpDate;
	}

	public void setExpDate(String expDate) {
		ExpDate = expDate;
	}

	public String getCreatedOn() {
		return CreatedOn;
	}

	public void setCreatedOn(String createdOn) {
		CreatedOn = createdOn;
	}

	public String getCreatedBy() {
		return CreatedBy;
	}

	public void setCreatedBy(String createdBy) {
		CreatedBy = createdBy;
	}

	public Transaction(int id, String nameoncard, String cardNumber, String cardtype, double unitPrice, int quantity,
			double totalPrice, String expDate, String createdOn, String createdBy) {
		super();
		this.id = id;
		this.nameoncard = nameoncard;
		this.cardtype = cardtype;
		CardNumber = cardNumber;
		UnitPrice = unitPrice;
		Quantity = quantity;
		TotalPrice = totalPrice;
		ExpDate = expDate;
		CreatedOn = createdOn;
		CreatedBy = createdBy;
	}

	public String toString() {
		return "ID=" + id + "\n" + "nameoncard=" + nameoncard + "\n" + "CardType=" + cardtype + "\n" + "CardNumber="
				+ CardNumber + "\n" + "UnitPrice=" + UnitPrice + "\n" + "Quantity=" + Quantity + "\n" + "TotalPrice="
				+ TotalPrice + "\n" + "ExpDate=" + ExpDate + "\n" + "CreatedOn=" + CreatedOn + "\n" + "CreatedBy="
				+ CreatedBy;
	}

}

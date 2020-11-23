package com.cts.model;

public class TransactionDetails {
	public TransactionDetails() {
		// TODO Auto-generated constructor stub
	}
	private String cardType;
	private String nameOnCard;
	private String cardNumber;
	private int CVV;
	private String expirationDetails;

	public String getExpirationDetails() {
		return expirationDetails;
	}

	public void setExpirationDetails(String expirationDetails) {
		this.expirationDetails = expirationDetails;
	}

	public String getCardType() {
		return cardType;
	}

	@Override
	public String toString() {
		return "TransactionDetails [cardType=" + cardType + ", nameOnCard=" + nameOnCard + ", cardNumber=" + cardNumber
				+ ", CVV=" + CVV + ", expirationDetails=" + expirationDetails + "]";
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getNameOnCard() {
		return nameOnCard;
	}

	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public int getCVV() {
		return CVV;
	}

	public void setCVV(int cVV) {
		CVV = cVV;
	}
}
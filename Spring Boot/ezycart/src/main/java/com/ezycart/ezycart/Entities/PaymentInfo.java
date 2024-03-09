package com.ezycart.ezycart.Entities;

import jakarta.persistence.Column;

public class PaymentInfo {

  @Column(name = "cardholder_name")
  private String cardHolderName;

  @Column(name = "card_number")
  private String cardNumber;

  @Column(name = "expiration_date")
  private String expirationDate;

  @Column(name = "cvv")
  private String cvv;

  public PaymentInfo() {}

  public PaymentInfo(
    String cardHolderName,
    String cardNumber,
    String expirationDate,
    String cvv
  ) {
    this.cardHolderName = cardHolderName;
    this.cardNumber = cardNumber;
    this.expirationDate = expirationDate;
    this.cvv = cvv;
  }

  public String getCardHolderName() {
    return cardHolderName;
  }

  public void setCardHolderName(String cardHolderName) {
    this.cardHolderName = cardHolderName;
  }

  public String getCardNumber() {
    return cardNumber;
  }

  public void setCardNumber(String cardNumber) {
    this.cardNumber = cardNumber;
  }

  public String getExpirationDate() {
    return expirationDate;
  }

  public void setExpirationDate(String expirationDate) {
    this.expirationDate = expirationDate;
  }

  public String getCvv() {
    return cvv;
  }

  public void setCvv(String cvv) {
    this.cvv = cvv;
  }
}

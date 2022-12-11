package com.example.restApi.Models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Form {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String storeName;

    @Column
    private Date date;

    @Column
    private String servedBy;

    @Column
    private String email;

    @Column
    private String btBroadband;

    @Column
    private String btTvPackage;

    @Column
    private double totalPayment;

    @Column
    private String otherHandlyInformation;

    @Column
    private Date sportPackage;
    private double upfrontFee;
    private double monthlyCharge;
    private int installmentsOfPayment;
  
    public long getId() {
        return id;
    }

    public String getStoreName() {
      return storeName;
    }
  
    public void setStoreName(String storeName) {
      this.storeName = storeName;
    }
  
    public Date getDate() {
      return date;
    }
  
    public void setDate(Date date) {
      this.date = date;
    }
  
    public String getServedBy() {
      return servedBy;
    }
  
    public void setServedBy(String servedBy) {
      this.servedBy = servedBy;
    }
  
    public String getEmail() {
      return email;
    }
  
    public void setEmail(String email) {
      this.email = email;
    }
  
    public String getBtBroadband() {
      return btBroadband;
    }
  
    public void setBtBroadband(String btBroadband) {
      this.btBroadband = btBroadband;
    }
  
    public String getBtTvPackage() {
      return btTvPackage;
    }
  
    public void setBtTvPackage(String btTvPackage) {
      this.btTvPackage = btTvPackage;
    }
  
    public double getTotalPayment() {
    return totalPayment;
    }
  
    public void setTotalPayment(double totalPayment) {
    this.totalPayment = totalPayment;
    }
  
    public String getOtherHandlyInformation() {
    return otherHandlyInformation;
    }
  
    public void setOtherHandlyInformation(String otherHandlyInformation) {
    this.otherHandlyInformation = otherHandlyInformation;
    }
  
    public Date getSportPackage() {
    return sportPackage;
    }
  
    public void setSportPackage(Date sportPackage) {
    this.sportPackage = sportPackage;
    }   

    public double getUpfrontFee(){
        return upfrontFee;
    }

    public double getMonthlyCharge(){
        return monthlyCharge;
    }

    public int getInstallmentsOfPayment(){
        return installmentsOfPayment;
    }
}

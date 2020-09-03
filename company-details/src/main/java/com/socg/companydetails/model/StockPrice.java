package com.socg.companydetails.model;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StockPrice {
	@Id
	private Integer companyCode;
	private String stockExchange;
	private Integer currentPrice;
	private Date dateOfStock;
	private Time timeOfStock;
	public Integer getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(Integer companyCode) {
		this.companyCode = companyCode;
	}
	public String getStockExchange() {
		return stockExchange;
	}
	public void setStockExchange(String stockExchange) {
		this.stockExchange = stockExchange;
	}
	public Integer getCurrentPrice() {
		return currentPrice;
	}
	public void setCurrentPrice(Integer currentPrice) {
		this.currentPrice = currentPrice;
	}
	public Date getDateOfStock() {
		return dateOfStock;
	}
	public void setDateOfStock(Date dateOfStock) {
		this.dateOfStock = dateOfStock;
	}
	public Time getTimeOfStock() {
		return timeOfStock;
	}
	public void setTimeOfStock(Time timeOfStock) {
		this.timeOfStock = timeOfStock;
	}
	public StockPrice(Integer companyCode, String stockExchange, Integer currentPrice, Date dateOfStock,
			Time timeOfStock) {
		super();
		this.companyCode = companyCode;
		this.stockExchange = stockExchange;
		this.currentPrice = currentPrice;
		this.dateOfStock = dateOfStock;
		this.timeOfStock = timeOfStock;
	}
	public StockPrice() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}

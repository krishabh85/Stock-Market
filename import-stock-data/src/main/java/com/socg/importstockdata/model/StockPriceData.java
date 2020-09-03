package com.socg.importstockdata.model;

import java.sql.Date;
//import java.sql.LocalTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
//
//import lombok.Data;
//import lombok.Getter;
//import lombok.Setter;

@Entity
@Table(name="StockPriceData")
public class StockPriceData {
	
	@Id
	@Column(name="companyCode")
	private int companyCode;
	
	@Column(name="stockExchange")
	private String stockExchange;
	
	@Column(name="currentPrice")
	private Double currentPrice;
	
	@Column(name="dateOfStock")
	private Date dateOfStock;
	
	@Column(name="localTimeOfStock")
	private LocalTime localTimeOfStock;


	

	public int getCompanyCode() {
		return companyCode;
	}




	public void setCompanyCode(int companyCode) {
		this.companyCode = companyCode;
	}




	public String getStockExchange() {
		return stockExchange;
	}




	public void setStockExchange(String stockExchange) {
		this.stockExchange = stockExchange;
	}




	public Double getCurrentPrice() {
		return currentPrice;
	}




	public void setCurrentPrice(Double currentPrice) {
		this.currentPrice = currentPrice;
	}




	public Date getDateOfStock() {
		return dateOfStock;
	}




	public void setDateOfStock(Date dateOfStock) {
		this.dateOfStock = dateOfStock;
	}




	public LocalTime getLocalTimeOfStock() {
		return localTimeOfStock;
	}




	public void setLocalTimeOfStock(LocalTime localTimeOfStock) {
		this.localTimeOfStock = localTimeOfStock;
	}




	@Override
	  public String toString() {
	    return "StockPriceTable [companyCode =" + companyCode + ", stockExchange=" + stockExchange + ", currentPrice=" + currentPrice + ", dateOfStock=" + dateOfStock + ", localTimeOfStock=" + localTimeOfStock +"]";
	  }
	
	
	
}

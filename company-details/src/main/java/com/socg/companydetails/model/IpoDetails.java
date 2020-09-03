package com.socg.companydetails.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;

import javax.persistence.Id;

@Entity
public class IpoDetails {
	@Id
	private Integer ipoId;
	private String companyName;
	private String stockExchange;
	private Integer pricePerShare;
	private Integer totalShares;
	private LocalDateTime openDateTime;
	private String remarks;
	
	
	
	public IpoDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public IpoDetails(Integer ipoId, String companyName, String stockExchange, Integer pricePerShare,
			Integer totalShares, LocalDateTime openDateTime, String remarks) {
		super();
		this.ipoId = ipoId;
		this.companyName = companyName;
		this.stockExchange = stockExchange;
		this.pricePerShare = pricePerShare;
		this.totalShares = totalShares;
		this.openDateTime = openDateTime;
		this.remarks = remarks;
	}
	public Integer getIpoId() {
		return ipoId;
	}
	public void setIpoId(Integer ipoId) {
		this.ipoId = ipoId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getStockExchange() {
		return stockExchange;
	}
	public void setStockExchange(String stockExchange) {
		this.stockExchange = stockExchange;
	}
	public Integer getPricePerShare() {
		return pricePerShare;
	}
	public void setPricePerShare(Integer pricePerShare) {
		this.pricePerShare = pricePerShare;
	}
	public Integer getTotalShares() {
		return totalShares;
	}
	public void setTotalShares(Integer totalShares) {
		this.totalShares = totalShares;
	}
	public LocalDateTime getOpenDateTime() {
		return openDateTime;
	}
	public void setOpenDateTime(LocalDateTime openDateTime) {
		this.openDateTime = openDateTime;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	
}

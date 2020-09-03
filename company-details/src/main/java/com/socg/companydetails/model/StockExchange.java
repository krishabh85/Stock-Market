package com.socg.companydetails.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
//import org.springframework.boot.autoconfigure.domain.EntityScan;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
//@EntityScan
public class StockExchange {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer stockId;
	private String stockExchange;
	private String brief;
	private String contactAddress;
	private String remarks;
//	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
//	@JoinColumn(name="companyId")
//	private List<IpoDetails> ipoDetails;
	
	public StockExchange() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StockExchange(Integer stockId, String stockExchange, String brief, String contactAddress, String remarks) {
		super();
		this.stockId = stockId;
		this.stockExchange = stockExchange;
		this.brief = brief;
		this.contactAddress = contactAddress;
		this.remarks = remarks;
	}
	public Integer getStockId() {
		return stockId;
	}
	
//	public List<IpoDetails> getIpoDetails() {
//		return ipoDetails;
//	}
//	public void setIpoDetails(List<IpoDetails> ipoDetails) {
//		this.ipoDetails = ipoDetails;
//	}
	public void setStockId(Integer stockId) {
		this.stockId = stockId;
	}
	public String getStockExchange() {
		return stockExchange;
	}
	public void setStockExchange(String stockExchange) {
		this.stockExchange = stockExchange;
	}
	public String getBrief() {
		return brief;
	}
	public void setBrief(String brief) {
		this.brief = brief;
	}
	public String getContactAddress() {
		return contactAddress;
	}
	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	
}

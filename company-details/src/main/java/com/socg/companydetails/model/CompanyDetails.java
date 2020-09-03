package com.socg.companydetails.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;

//import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.data.annotation.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
//import java.lang.reflect.Array;

//import com.sun.xml.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;
@Entity
//@EntityScan
public class CompanyDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="companyId")
	private Integer companyId;
	private String companyName;
	private Integer turnover;	
	private String ceo;
	
	private String[] boardOfDirectors= new String[3];
//
	
//	@JoinTable(name="Company_Stock",
//				joinColumns= {
//						@JoinColumn(name = "companyId")
//				}
//			)
	@ManyToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL )
	@JoinColumn(name="companyId")
	private List<StockExchange> listedInStockExchanges;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="companyId")
	private List<IpoDetails> ipoDetails;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="companyId")
	private List<StockPrice> stockPrice;
	
	private Integer sectorId;
	private String writeUp;
	
	
	
	
	
	public CompanyDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public CompanyDetails(Integer companyId, String companyName, Integer turnover, String ceo,
			String[] boardOfDirectors, List<StockExchange> listedInStockExchanges, List<IpoDetails> ipoDetails,
			List<StockPrice> stockPrice, Integer sectorId, String writeUp) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
		this.turnover = turnover;
		this.ceo = ceo;
		this.boardOfDirectors = boardOfDirectors;
		this.listedInStockExchanges = listedInStockExchanges;
		this.ipoDetails = ipoDetails;
		this.stockPrice = stockPrice;
		this.sectorId = sectorId;
		this.writeUp = writeUp;
	}


	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Integer getTurnover() {
		return turnover;
	}

	public void setTurnover(Integer turnover) {
		this.turnover = turnover;
	}

	public String getCeo() {
		return ceo;
	}

	public void setCeo(String ceo) {
		this.ceo = ceo;
	}

	public String[] getBoardOfDirectors() {
		return boardOfDirectors;
	}

	public void setBoardOfDirectors(String[] boardOfDirectors) {
		this.boardOfDirectors = boardOfDirectors;
	}

	public List<StockExchange> getListedInStockExchanges() {
		return listedInStockExchanges;
	}

	public void setListedInStockExchanges(List<StockExchange> listedInStockExchanges) {
		this.listedInStockExchanges = listedInStockExchanges;
	}

	public List<IpoDetails> getIpoDetails() {
		return ipoDetails;
	}

	public void setIpoDetails(List<IpoDetails> ipoDetails) {
		this.ipoDetails = ipoDetails;
	}

	public Integer getSectorId() {
		return sectorId;
	}

	public void setSectorId(Integer sectorId) {
		this.sectorId = sectorId;
	}

	public String getWriteUp() {
		return writeUp;
	}

	public void setWriteUp(String writeUp) {
		this.writeUp = writeUp;
	}

	public List<StockPrice> getStockPrice() {
		return stockPrice;
	}

	public void setStockPrice(List<StockPrice> stockPrice) {
		this.stockPrice = stockPrice;
	}

	
	
	
	

	
	
	

	
}

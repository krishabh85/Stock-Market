package com.socg.companydetails.controller;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.socg.companydetails.model.CompanyDetails;
import com.socg.companydetails.model.StockExchange;
import com.socg.companydetails.model.StockPrice;
import com.socg.companydetails.service.CompanyDetailsService;
//import com.sun.el.stream.Optional;

//@Response
@RestController
public class CompanyDetailsController {
	@Autowired
	private CompanyDetailsService companyDetailsService;
	
	@GetMapping("/company/{companyId}")
	public Optional<CompanyDetails> getCompanyDetails(@PathVariable("companyId") Integer companyId ) {
		return companyDetailsService.findByCompanyId(companyId);
	}
	
	@GetMapping("/viewAllCompanies")
	public List<CompanyDetails> viewAllCompanyDetails(){
		return companyDetailsService.findAllCompanies();
	}
	
	@PostMapping(value="/updateCompanyDetails")
	public ResponseEntity<CompanyDetails> updateCompanyDetails(@RequestBody CompanyDetails companyDetails){
		return new ResponseEntity<>(companyDetailsService.updateCompanyDetails(companyDetails), HttpStatus.OK);
	}
	
	@GetMapping("/company/{companyId}/{fromPeriod}/{toPeriod}")
	public List<StockPrice> getStockPriceByCompanyId(@PathVariable("companyId") Integer companyId, @PathVariable("fromPeriod") Date fromPeriod, @PathVariable("toPeriod") Date toPeriod){
		Optional<CompanyDetails> companyDetails= companyDetailsService.findByCompanyId(companyId);
		return companyDetailsService.findStockPriceBycompanyId(companyId, fromPeriod, toPeriod);
	}
//	public ResponseEntity<Iterable<StockExchange>> getStockExchangeDetailsByCompanyId(@PathVariable("companyID") Integer companyId)
//	{
//		 Optional<CompanyDetails> companyDetails = companyDetailsService.findByCompanyId(companyId);
//		 return ResponseEntity.ok().body(companyDetails.get().getListedInStockExchanges());
//	}
	@PostMapping(value = "/addCompanyDetails")
	public ResponseEntity<CompanyDetails> createCompanyDetails(@RequestBody CompanyDetails companyDetails) {
		//TODO: process POST request
		
		return new ResponseEntity<>(companyDetailsService.createCompanyDetails(companyDetails), HttpStatus.CREATED);
	}

}	
	

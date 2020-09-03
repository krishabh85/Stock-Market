package com.socg.companydetails.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.socg.companydetails.model.StockPrice;
@Repository
public interface StockPriceRepository extends JpaRepository<StockPrice, Integer>{
//	public findByCompanyId() {
		
	
}

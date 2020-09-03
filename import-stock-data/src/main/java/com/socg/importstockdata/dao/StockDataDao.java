package com.socg.importstockdata.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.socg.importstockdata.model.StockPriceData;
@Repository
public interface StockDataDao extends JpaRepository<StockPriceData, Integer> {
	
}

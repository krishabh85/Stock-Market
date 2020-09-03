package com.socg.importstockdata.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.socg.importstockdata.dao.StockDataDao;
import com.socg.importstockdata.helper.ExcelHelper;
import com.socg.importstockdata.model.StockPriceData;

@Service
public class StockDataService {

	@Autowired
	private StockDataDao stockDataDao;
	
	public void save(MultipartFile multipartFile) {
		try {
			List<StockPriceData> stockPriceDatas= ExcelHelper.excelToStockPriceData(multipartFile.getInputStream());
			stockDataDao.saveAll(stockPriceDatas);
		}
		catch(IOException e){
			throw new RuntimeException("fail to store excel data: " + e.getMessage());
		}
	}
	public List<StockPriceData> getStockData(){
		return stockDataDao.findAll();
	}
}

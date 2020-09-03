package com.socg.importstockdata.controller;

import java.io.Console;
import java.util.List;

import javax.swing.text.html.ListView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.socg.importstockdata.helper.ExcelHelper;
import com.socg.importstockdata.message.ResponseMessage;
import com.socg.importstockdata.model.StockPriceData;
import com.socg.importstockdata.service.StockDataService;

@RestController
@RequestMapping("/excel")
public class StockDataController {

	@Autowired
	private StockDataService stockDataService;
	
	@PostMapping("/upload")
	public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("multipartFile") MultipartFile multipartFile){
		String message = "";
		if(ExcelHelper.hasExcelFormat(multipartFile)) {
			try {
				stockDataService.save(multipartFile);
				message= "Uploaded the file successfully: " + multipartFile.getOriginalFilename();
				return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
			}
			catch(Exception e){
				message= "Could not upload the file: " + multipartFile.getOriginalFilename() + "!";
				System.out.println(e.toString());
				return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
//				e.printStackTrace();
				
				
				
			}
		}
		message="Invaild Format";
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
	}
	
	@GetMapping("/stockdata")
	public ResponseEntity<List<StockPriceData>> getAllData(){
		List<StockPriceData> stockPriceDatas= stockDataService.getStockData();
		try {
		if (stockPriceDatas.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }

	      return new ResponseEntity<>(stockPriceDatas, HttpStatus.OK);
	    } 
		catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	
	
	
	
}

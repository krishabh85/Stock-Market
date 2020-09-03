package com.socg.importstockdata.helper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.socg.importstockdata.model.StockPriceData;

public class ExcelHelper {
	public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	  static String[] HEADERs = { "Company Code", "Stock Exchange", "Price Per Share(in Rs)", "Date", "Time" };
	  static String SHEET = "sample_stock_data";
	  
	  public static boolean hasExcelFormat(MultipartFile file) {

		    if (!TYPE.equals(file.getContentType())) {
		      return false;
		    }

		    return true;
		  }
	  public static List<StockPriceData> excelToStockPriceData(InputStream is) {
		    try {
		      Workbook workbook = new XSSFWorkbook(is);

		      Sheet sheet = workbook.getSheet(SHEET);
		      Iterator<Row> rows = sheet.iterator();

		      List<StockPriceData> stockPriceDatas = new ArrayList<StockPriceData>();

		      int rowNumber = 0;
		      while (rows.hasNext()) {
		        Row currentRow = rows.next();

		        // skip header
		        if (rowNumber == 0) {
		          rowNumber++;
		          continue;
		        }

		        Iterator<Cell> cellsInRow = currentRow.iterator();

		        StockPriceData stockPriceData = new StockPriceData();

		        int cellIdx = 0;
		        while (cellsInRow.hasNext()) {
		          Cell currentCell = cellsInRow.next();

		          switch (cellIdx) {
		          case 0:
		        	  stockPriceData.setCompanyCode((int) currentCell.getNumericCellValue());
//		        	  setCompanyCode((Integer) currentCell.getNumericCellValue());
		            break;

		          case 1:
		            stockPriceData.setStockExchange(currentCell.getStringCellValue());
		            break;

		          case 2:
		        	  stockPriceData.setCurrentPrice((Double) currentCell.getNumericCellValue());
		            break;

		          case 3:
		        	  stockPriceData.setDateOfStock((Date) currentCell.getDateCellValue());
		            break;
		          case 4:
		        	  stockPriceData.setLocalTimeOfStock(currentCell.getLocalDateTimeCellValue().toLocalTime());
		            break;

		          default:
		            break;
		          }

		          cellIdx++;
		        }

		        stockPriceDatas.add(stockPriceData);
		      }

		      workbook.close();

		      return stockPriceDatas;
		    } catch (IOException e) {
		      throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
		    }
		  }
		
}

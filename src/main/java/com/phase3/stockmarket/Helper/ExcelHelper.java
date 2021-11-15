package com.phase3.stockmarket.Helper;

import com.phase3.stockmarket.Entities.StockPrice;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelHelper {

    public static boolean checkExcelFormat(MultipartFile file) {

        String contentType = file.getContentType();

        if (contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
            return true;
        } else {
            return false;
        }

    }

    public static List<StockPrice> convertToStockPrice(InputStream is) {

        List<StockPrice> list = new ArrayList<>();

        try {

            XSSFWorkbook wb = new XSSFWorkbook(is);
            // XSSFSheet sheet = wb.getSheet("StockPrice");
            XSSFSheet sheet = wb.getSheetAt(0);

            int rowNum = 0;
            Iterator<Row> it = sheet.iterator();

            while (it.hasNext()) {
                Row row = it.next();
                if (rowNum == 0) {
                    rowNum++;
                    continue;
                }

                Iterator<Cell> cells = row.iterator();

                StockPrice stockPrice = new StockPrice();

                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

                if (row.getCell(0).getStringCellValue().equals(""))
                    break;

                int cid = 0;
                while (cells.hasNext()) {
                    Cell cell = cells.next();

                    switch (cid) {
                    case 0:
                        // System.out.println("cell input =>
                        // |"+cell.getStringCellValue().replaceAll("\u00A0", "")+"|");
                        stockPrice.setCompanyCode(Long.parseLong(cell.getStringCellValue().replaceAll("\u00A0", "")));
                        break;

                    case 1:
                        stockPrice.setExchange((String) cell.getStringCellValue().trim());
                        break;

                    case 2:
                        stockPrice.setPrice((double) cell.getNumericCellValue());
                        break;

                    case 3:
                        // System.out.println("input cell => |"+cell.getStringCellValue()+"|");
                        String text = (String) cell.getStringCellValue().trim();
                        java.util.Date date = sdf.parse(text);
                        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                        stockPrice.setDate(sqlDate);
                        break;

                    case 4:
                        String time = (String) cell.getStringCellValue().trim();
                        stockPrice.setTime(java.sql.Time.valueOf(time));
                        break;

                    default:
                        break;
                    }
                    cid++;
                }
                list.add(stockPrice);
            }
            wb.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}

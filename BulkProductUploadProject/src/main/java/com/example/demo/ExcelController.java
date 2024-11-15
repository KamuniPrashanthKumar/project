package com.example.demo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ExcelController {
    
    @Autowired
    private ExcelService service;
    
    
    
    
    @GetMapping("/fileUpload")
    public String fileUpload(Model model) {
        model.addAttribute("excelData", new ExcelData());
        return "fileUpload";
    }
    
   
    
    @PostMapping("/uploadExcel")
    public String uploadExcel(@RequestParam("excelFile") MultipartFile file, Model model) throws IOException {
        List<ExcelData> excelDataList = new ArrayList<>();
        XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
        XSSFSheet sheet = workbook.getSheetAt(0);
        
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            XSSFRow row = sheet.getRow(i);
            ExcelData data = new ExcelData();
            
            DataFormatter formatter = new DataFormatter();
            
            
            data.setProductId(formatter.formatCellValue(row.getCell(0)));

            data.setProductName(row.getCell(1).getStringCellValue());
          //  data.setPhone(row.getCell(2).getStringCellValue());
           data.setProductType(row.getCell(2).getStringCellValue());
            
          
           
            data.setPrice(formatter.formatCellValue(row.getCell(3)));
            excelDataList.add(data);
        }
        
        service.saveExcelData(excelDataList);
        //model.addAttribute("message", "Excel file uploaded successfully!");
        //return "excelUpload";
        List<ExcelData> excelDataList1 = service.getAllExcelData();
        model.addAttribute("excelDataList", excelDataList1);
        return "fileUpload";
        
    }
    
	
}

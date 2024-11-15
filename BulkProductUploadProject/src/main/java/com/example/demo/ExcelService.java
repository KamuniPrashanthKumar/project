package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExcelService {
    
    @Autowired
    private ExcelRepository repository;
    
    public void saveExcelData(List<ExcelData> excelDataList) {
        repository.saveAll(excelDataList);
    }
    
    public List<ExcelData> getAllExcelData() {
        return repository.findAll();
    }
}


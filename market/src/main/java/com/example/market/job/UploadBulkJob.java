package com.example.market.job;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.market.service.TransactionService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class UploadBulkJob {
    
    @Autowired
    private TransactionService transactionServiceImpl;

    @Scheduled(cron = "${cron.uploadBulkData}")
    public void doCreateFileAfas() throws UnsupportedEncodingException, IOException{
        log.info("Create Upload Bulk Job - Start");
        FileInputStream fis = new FileInputStream("src/main/resources/data/data_001.txt");
        log.info("Insert data start with input {}" , fis);
        transactionServiceImpl.insertBulk(fis);
        log.info("Create Upload Bulk Job - End");
    }

}

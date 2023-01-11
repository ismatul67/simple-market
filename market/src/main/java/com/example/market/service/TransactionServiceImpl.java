package com.example.market.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.market.model.entity.Transaction;
import com.example.market.model.request.TransactionRequest;
import com.example.market.model.response.TransactionResponse;
import com.example.market.repository.TransactionRepository;
import com.example.market.util.DateUtility;

@Service
public class TransactionServiceImpl implements TransactionService{

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public String insertBulk(InputStream inputStream) throws UnsupportedEncodingException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        String line = null;
        while ((line = br.readLine()) != null) {
        String[] values = line.split("\\|");

        if (values.length<4) continue; // problem !!!  

        String name=values[0];
        String dob=values[1];
        String amount=values[2];
        String product=values[3];

        Transaction transaction = new Transaction();
        transaction.setName(name);
        transaction.setPaymentAmount(Long.valueOf(amount));
        transaction.setProductName(product);
        transaction.setDob(DateUtility.convertStringToDate("yyyy-MM-dd", dob));
        transactionRepository.save(transaction);

        System.out.println(name + "\t" + dob + "\t" + amount + "\t" +     product);
        }
        br.close();
        return "Success Insert Bulk Data";
    }

    @Override
    public String insertData(TransactionRequest request) {
        
        Transaction transaction = new Transaction();
        transaction.setName(request.getName());
        transaction.setPaymentAmount(request.getPaymentAmount());
        transaction.setProductName(request.getProductName());
        transaction.setDob(DateUtility.convertStringToDate("yyyy-MM-dd", request.getDob()));
        transactionRepository.save(transaction);
        return "Success Insert Data";
    }

    @Override
    public List<TransactionResponse> findAllTransaction() {
        List<TransactionResponse> result = new ArrayList<>();
        transactionRepository.findAll().forEach(data ->{
            TransactionResponse transactionResponse = TransactionResponse.builder()
            .dob(DateUtility.customDateFormat("yyyy-MM-dd", data.getDob()))
            .id(data.getId())
            .paymentAmount(data.getPaymentAmount())
            .name(data.getName())
            .productName(data.getProductName())
            .build();
            result.add(transactionResponse);
        });
        return result;
    }
    
}

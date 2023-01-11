package com.example.market.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.market.model.request.TransactionRequest;
import com.example.market.model.response.RestResponse;
import com.example.market.service.TransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionServiceImpl;

    @PostMapping(value="/v1/upload-data")
    public ResponseEntity<RestResponse> processUpload(@RequestParam MultipartFile file) throws UnsupportedEncodingException, IOException {
        String result = transactionServiceImpl.insertBulk(file.getInputStream());
        RestResponse response = new RestResponse(null, result);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @PostMapping("/v1/insert-data")
    public ResponseEntity<RestResponse> register (@RequestBody TransactionRequest transactionRequest){
        String result = transactionServiceImpl.insertData(transactionRequest);
        RestResponse response = new RestResponse(null, result);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @GetMapping("/v1/readCustomer")
    public ResponseEntity<RestResponse> readData (){
        RestResponse response = new RestResponse(transactionServiceImpl.findAllTransaction(), "Here your data");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
}

package com.example.market.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;


import com.example.market.model.request.TransactionRequest;
import com.example.market.model.response.TransactionResponse;

public interface TransactionService {
    
    String insertBulk(InputStream inputStream) throws UnsupportedEncodingException, IOException;
    String insertData(TransactionRequest request);
    List<TransactionResponse> findAllTransaction();
    
}

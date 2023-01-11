package com.example.market.model.response;


import lombok.*;


@Getter
@Setter
@Builder
public class TransactionResponse {

    private String id;
    private String name;
    private String dob;
    private Long paymentAmount;
    private String productName;
    
}

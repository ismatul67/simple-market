package com.example.market.model.request;

import lombok.*;


@Getter
@Setter
public class TransactionRequest {
    private String name;
    private String dob;
    private Long paymentAmount;
    private String productName;
}

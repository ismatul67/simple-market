package com.example.market.model.response;

import lombok.*;


@Getter
@Setter
public class RestResponse {
  
    private Object data;
    
    private String message;
        
    public RestResponse(Object data, String message) {
        this.data = data;
        this.message = message;
    }
    
       public RestResponse() {
    }
  }

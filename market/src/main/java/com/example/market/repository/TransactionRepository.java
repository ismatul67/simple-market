package com.example.market.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.market.model.entity.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository <Transaction, String> {
    
}

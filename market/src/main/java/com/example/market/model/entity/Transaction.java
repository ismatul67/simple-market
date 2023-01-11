package com.example.market.model.entity;


import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import lombok.*;
import java.util.Date;


@Entity
@Table(name = "transaction")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(generator = "transaction_id", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "transaction_id", strategy = "uuid")
    @Column(name = "transaction_id", updatable = false, nullable = false)
    private String id;

    @Column(name = "name", length = 30)
    private String name;

    @Column(name = "dob")
    private Date dob;

    @Column(name = "payment_amount")
    private Long paymentAmount;

    @Column(name = "product_name", length = 50)
    private String productName;

    
}

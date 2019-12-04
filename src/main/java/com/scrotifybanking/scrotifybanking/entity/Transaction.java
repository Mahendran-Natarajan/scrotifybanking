package com.scrotifybanking.scrotifybanking.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import javax.persistence.*;

import lombok.*;

@Entity
@Table(name = "transaction")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Transaction implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name = "transaction_id", insertable = false, nullable = false)
  private Integer transactionId;

  @Column(name = "to_account_no")
  private Integer toAccountNo;

  /*@Column(name = "from_account_no")
  private Integer fromAccountNo;*/

  @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinColumn(name = "accountNo")
  private Account account;

  @Column(name = "transaction_date")
  private LocalDate transactionDate;

  @Column(name = "amount")
  private Double amount;


  
}
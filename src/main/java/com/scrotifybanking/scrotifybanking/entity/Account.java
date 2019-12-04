package com.scrotifybanking.scrotifybanking.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

import com.sun.tracing.dtrace.ArgsAttributes;
import lombok.*;

@Entity
@Table(name = "account")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Account implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(insertable = false, name = "account_no", nullable = false)
  private Integer accountNo;

  @Column(name = "account_type")
  private String accountType;

  @Column(name = "account_status")
  private String accountStatus;

//  @Column(name = "customer_id")
//  private String customerId;

  @Column(name = "available_balance")
  private Double availableBalance;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "customerId")
  private Customer customer;

  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "account")
  private List<Transaction> transactionList;



}
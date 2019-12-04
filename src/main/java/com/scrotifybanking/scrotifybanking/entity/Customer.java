package com.scrotifybanking.scrotifybanking.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.*;

import lombok.*;

@Table(name = "customer")
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Customer implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @Column(insertable = false, name = "customer_id", nullable = false)
  private String customerId;

  @Column(name = "customer_name", nullable = false)
  private String customerName;

  @Column(name = "customer_email")
  private String customerEmail;

  @Column(name = "customer_password")
  private String customerPassword;

  @Column(name = "account_type")
  private String accountType;

  @Column(name = "customer_dob")
  private Date customerDob;

  @Column(name = "customer_mobileno")
  private Integer customerMobileno;

  @Column(name = "customer_city")
  private String customerCity;

  @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<Account> accountList;
  
}
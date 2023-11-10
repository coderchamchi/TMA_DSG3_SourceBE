package com.bezkoder.springjwt.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "User")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "userid")
  @JsonIgnore
  private Long userId;

  @Column(name = "Username", nullable = false, unique = true)
  private String username;

  @Column(name = "Userpassword", nullable = false)
  @JsonIgnore
  private String password;

  @Column(name = "Createdate")
  @JsonIgnore
  private LocalDate created;

  @Column(name = "Updatedate")
  @JsonIgnore
  private LocalDate updated;

  @Column(name = "Email", nullable = false, unique = true)
  private String email;

  @Column(name ="Phone")
  private String phone;

  @Column(name = "Address")
  private String address;

  @Column(name = "Birthday")
  private LocalDate birthday;

  @ManyToMany(fetch = FetchType.LAZY) // lấy user thì lấy luôn quyền của nó
  @JoinTable( name = "Userrole",
          joinColumns = @JoinColumn(name = "Userid"),
          inverseJoinColumns = @JoinColumn(name = "Roleid")
  )
  @JsonIgnore
  private Set<Role> listRole = new HashSet<>();

  @OneToMany(mappedBy = "user")
  @JsonIgnore
  private List<Bill> listBill;

//  @OneToOne(mappedBy = "customer")
//  @JsonIgnore
//  private ShoppingCart shoppingCart;


  public User(String username, String encode, String email,LocalDate birthday) {
    this.username = username;
    this.password = encode;
    this.email = email;
    this.birthday=birthday;
  }

  public User(String username, String password, LocalDate created, LocalDate updated, String email, String phone, String address, LocalDate birthday) {
    this.username = username;
    this.password = password;
    this.created = created;
    this.updated = updated;
    this.email = email;
    this.phone = phone;
    this.address = address;
    this.birthday = birthday;
  }

  public Long getId() {
    return userId;
  }

  public void setId(Long id) {
    this.userId = userId;
  }
}
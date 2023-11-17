package com.bezkoder.springjwt.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

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
  @Column(name = "id")
  @JsonIgnore
  private Long userId;

  @Column(name = "fullname", nullable = false, unique = true)
  private String username;

  @Column(name = "password", nullable = false)
  @JsonIgnore
  private String password;

  @Column(name = "created_at")
  @JsonIgnore
  private LocalDate created;

  @Column(name = "updated_at")
  @JsonIgnore
  private LocalDate updated;

  @NaturalId
  @Column(name = "email", nullable = false, unique = true)
  private String email;

  @Column(name ="phone_number")
  private String phone;

  @Column(name = "address")
  private String address;

  @Column(name = "birthday")
  private LocalDate birthday;

  @Column(name="deleted")
  private boolean deleted;

  @ManyToMany(fetch = FetchType.LAZY) // lấy user thì lấy luôn quyền của nó
  @JoinTable( name = "userrole",
          joinColumns = @JoinColumn(name = "user_id"),
          inverseJoinColumns = @JoinColumn(name = "role_id")
  )
  @JsonIgnore
  private Set<Role> listRole = new HashSet<>();

  @OneToMany(mappedBy = "user")
  @JsonIgnore
  private List<ShoppingCartItem> shoppingCart = new ArrayList<>();
  // =new Arraylist<>() là để tránh tình trạng null exception khi thao tác với class shoppingcartitem mà chưa khởi tạo

  //  @OneToMany(mappedBy = "user")
  //  @JsonIgnore
  //  private List<Bill> listBill;

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
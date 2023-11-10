package com.bezkoder.springjwt.entities;

import com.bezkoder.springjwt.entities.ERole;

import javax.persistence.*;

@Entity
@Table(name = "Role")
public class Role {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name ="Roleid")
  private int roleId;

  @Enumerated(EnumType.STRING)
  @Column(name = "Rolename")
  private ERole roleName;

  public ERole getRoleName() {
    return roleName;
  }

  public void setRoleName(ERole roleName) {
    this.roleName = roleName;
  }
}
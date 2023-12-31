package com.example.test.test.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "user_account")
public class UserAccount {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column
  private String name;
  @Column
  private String phone;
  @Column
  @Enumerated(EnumType.STRING)
  private Role role;
  @OneToMany(mappedBy = "userAccount", fetch = FetchType.LAZY)
  @JsonManagedReference
  private List<Studio> studios;

  public UserAccount(Long id, String name, String phone, Role role, List<Studio> studios) {
    this.id = id;
    this.name = name;
    this.phone = phone;
    this.role = role;
    this.studios = studios;
  }

  public UserAccount() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }

  public List<Studio> getStudios() {
    return studios;
  }

  public void setStudios(List<Studio> studios) {
    this.studios = studios;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserAccount that = (UserAccount) o;
    return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(
        phone, that.phone) && role == that.role && Objects.equals(studios, that.studios);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, phone, role, studios);
  }

  @Override
  public String toString() {
    return "UserAccount{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", phone='" + phone + '\'' +
        ", role=" + role +
        ", studios=" + studios +
        '}';
  }
}

package com.example.test.test.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "studio")
public class Studio {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column
  private String name;
  @Column
  private String phone;
  @Column
  private String address;
  @Column(name = "user_account_id")
  private Long userAccountId;
  @ManyToOne
  @JoinColumn(name = "user_account_id", updatable = false, insertable = false)
  @JsonBackReference
  private UserAccount userAccount;
  @Column
  @OneToMany(mappedBy = "studio", fetch = FetchType.LAZY)
  @JsonManagedReference
  private List<Location> locations;

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

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Long getUserAccountId() {
    return userAccountId;
  }

  public void setUserAccountId(Long userAccountId) {
    this.userAccountId = userAccountId;
  }

  public UserAccount getUserAccount() {
    return userAccount;
  }

  public void setUserAccount(UserAccount userAccount) {
    this.userAccount = userAccount;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Studio studio = (Studio) o;
    return Objects.equals(id, studio.id) && Objects.equals(name, studio.name)
        && Objects.equals(phone, studio.phone) && Objects.equals(address, studio.address)
        && Objects.equals(userAccountId, studio.userAccountId)
        && Objects.equals(userAccount,
        studio.userAccount)
        ;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, phone, address, userAccountId
        , userAccount
    );
  }

  @Override
  public String toString() {
    return "Studio{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", phone='" + phone + '\'' +
        ", address='" + address + '\'' +
        ", userAccountId=" + userAccountId +
        ", userAccount=" + userAccount +
        '}';
  }
}

package com.example.test.test.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "location")
public class Location {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column
  private String name;
  @Column(name = "studio_id")
  private Long studioId;
  @ManyToOne
  @JoinColumn(name = "studio_id", updatable = false, insertable = false)
  @JsonBackReference
  private Studio studio;

  public Location(Long id, String name, Long studioId, Studio studio) {
    this.id = id;
    this.name = name;
    this.studioId = studioId;
    this.studio = studio;
  }

  public Location() {
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

  public Long getStudioId() {
    return studioId;
  }

  public void setStudioId(Long studioId) {
    this.studioId = studioId;
  }

  public Studio getStudio() {
    return studio;
  }

  public void setStudio(Studio studio) {
    this.studio = studio;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Location location = (Location) o;
    return Objects.equals(id, location.id) && Objects.equals(name, location.name)
        && Objects.equals(studioId, location.studioId) && Objects.equals(studio, location.studio);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, studioId, studio);
  }

  @Override
  public String toString() {
    return "Location{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", studioId=" + studioId +
        ", studio=" + studio +
        '}';
  }
}

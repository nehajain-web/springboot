package com.example.demo.entity;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class product {

  @javax.persistence.Id
  private Integer Id;
  private String Name;
  private String Desc;
  private Integer Price;

  public product(Integer id, String name, String desc, Integer price) {
    Id = id;
    Name = name;
    Desc = desc;
    Price = price;
  }

  public product() {
  }

  public Integer getId() {
    return Id;
  }

  public void setId(Integer id) {
    Id = id;
  }

  public String getName() {
    return Name;
  }

  public void setName(String name) {
    Name = name;
  }

  public String getDesc() {
    return Desc;
  }

  public void setDesc(String desc) {
    Desc = desc;
  }

  public Integer getPrice() {
    return Price;
  }

  public void setPrice(Integer price) {
    Price = price;
  }
}

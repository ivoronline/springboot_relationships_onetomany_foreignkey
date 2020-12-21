package com.ivoronline.springboot_relationships_onetomany_foreignkey.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {

  //PRIMARY KEY
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Integer id;

  //FOREIGN KEY
  public Integer authorId;

  //DATA
  public String  title;

}

package com.ms.postcards.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PostcardTag extends BaseEntity {
  @ManyToOne(cascade = CascadeType.PERSIST)
  @JoinColumn
  @JsonIgnore
  protected Postcard postcard;
}

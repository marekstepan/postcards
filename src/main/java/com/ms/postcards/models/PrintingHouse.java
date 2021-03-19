package com.ms.postcards.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.sql.Timestamp;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PrintingHouse extends BaseEntity {

  private Timestamp created;
  private Timestamp edited;
  private int name;
  private String note;
  @OneToMany(mappedBy = "PrintingHouse")
  private Set<Postcard> postcards;
}

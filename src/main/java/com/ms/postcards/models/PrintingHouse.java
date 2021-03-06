package com.ms.postcards.models;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "printing_house")
public class PrintingHouse extends BaseEntity {

  @NotNull
  private int name;
  private String note;
  @OneToMany(mappedBy = "printingHouse")
  private Set<Postcard> postcards;
}

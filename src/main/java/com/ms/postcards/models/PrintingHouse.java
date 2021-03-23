package com.ms.postcards.models;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PrintingHouse extends BaseEntity {

  @NotNull
  private int name;
  private String note;
  @OneToMany(mappedBy = "printingHouse")
  private Set<Postcard> postcards;
}

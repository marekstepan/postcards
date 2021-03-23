package com.ms.postcards.models;

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
public class Orientation extends BaseEntity {
  private String value;
  @OneToMany(mappedBy = "orientation")
  private Set<Postcard> postcards;
  @OneToMany(mappedBy = "orientation")
  private Set<Shot> shots;
}

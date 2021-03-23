package com.ms.postcards.models;

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
@Table(name = "printing_technique")
public class PrintingTechnique extends BaseEntity {
  private String value;
  @OneToMany(mappedBy = "printingTechnique")
  private Set<Postcard> postcard;
}

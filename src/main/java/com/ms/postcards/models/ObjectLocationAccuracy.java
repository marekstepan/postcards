package com.ms.postcards.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "object_location_accuracie")
public class ObjectLocationAccuracy extends BaseEntity {
  private String value;
  @OneToMany(mappedBy = "objectLocationAccuracy")
  private List<Locality> localities;
}

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
@Table(name = "photographer_location_accuracy")
public class PhotographerLocationAccuracy extends BaseEntity {
  private String value;
  @OneToMany(mappedBy = "photographerLocationAccuracy")
  private List<Locality> localities;

}

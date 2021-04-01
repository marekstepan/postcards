package com.ms.postcards.models;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.geo.Point;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "localitie")
public class Locality extends BaseEntity {

  @NotNull
  @Column(name = "object_location", columnDefinition = "Point")
  private Point objectLocation;
  @Column(name = "photographer_location", columnDefinition = "Point")
  private Point photographerLocation;
  @OneToMany(mappedBy = "locality")
  private Set<Shot> shots;
  @ManyToOne
  @JoinColumn(name = "object_location_accuracy_id")
  private ObjectLocationAccuracy objectLocationAccuracy;
  @ManyToOne
  @JoinColumn(name = "photographer_location_accuracy_id")
  private PhotographerLocationAccuracy photographerLocationAccuracy;
}

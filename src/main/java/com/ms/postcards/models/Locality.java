package com.ms.postcards.models;

import com.sun.istack.NotNull;
import org.springframework.data.geo.Point;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "localities")
public class Locality extends BaseEntity {

  @NotNull
  private Timestamp created;
  @NotNull
  private Timestamp edited;
  @NotNull
  private Point objectLocation;
  private Point photographerLocation;
  @OneToMany(mappedBy = "locality")
  private Set<Shot> shots;
}

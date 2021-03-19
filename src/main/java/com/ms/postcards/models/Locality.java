package com.ms.postcards.models;

import org.springframework.data.geo.Point;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "localities")
public class Locality extends BaseEntity {

  private Timestamp created;
  private Timestamp edited;
  private Point objectLocation;
  private Point photographerLocation;
}

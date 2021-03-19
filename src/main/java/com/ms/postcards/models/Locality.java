package com.ms.postcards.models;

import org.springframework.data.geo.Point;

import javax.persistence.Entity;

@Entity
public class Locality extends BaseEntity {
  private Point objectLocation;
  private Point photographerLocation;
}

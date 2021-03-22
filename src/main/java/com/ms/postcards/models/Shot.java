package com.ms.postcards.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Shot extends BaseEntity {

  @NotNull
  private Timestamp created;
  @NotNull
  private Timestamp edited;
  private String object;
  private int objectType;
  private int imageOrientation;
  private String note;
  @ManyToOne(cascade = CascadeType.PERSIST)
  @JoinColumn(name="postcard_id")
  @JsonIgnore
  private Postcard postcard;
  @ManyToOne
  @JoinColumn(name="photographer_id")
  private Photographer photographer;
  @ManyToOne
  @JoinColumn(name="locality_id")
  private Locality locality;
}

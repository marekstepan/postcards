package com.ms.postcards.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Shot extends BaseEntity {

  private String object;
  private String note;
  @ManyToOne(cascade = CascadeType.PERSIST)
  @JoinColumn(name = "postcard_id")
  @JsonIgnore
  private Postcard postcard;
  @ManyToOne
  @JoinColumn(name = "photographer_id")
  private Photographer photographer;
  @ManyToOne
  @JoinColumn(name = "locality_id")
  private Locality locality;
  @ManyToOne
  @JoinColumn(name = "object_type_id")
  private ObjectType objectType;
  @ManyToOne
  @JoinColumn(name = "image_orientation_id")
  private Orientation orientation;
}

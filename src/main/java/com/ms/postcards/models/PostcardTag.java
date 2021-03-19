package com.ms.postcards.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PostcardTag extends BaseEntity {
  @ManyToOne(cascade = CascadeType.PERSIST)
  @JoinColumn
  @JsonIgnore
  protected Postcard postcard;
  @ManyToMany(mappedBy = "postcardTags")
  private Set<Postcard> postcards = new HashSet<>();
}

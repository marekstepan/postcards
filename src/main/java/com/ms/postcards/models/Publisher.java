package com.ms.postcards.models;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.sql.Timestamp;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Publisher extends BaseEntity {

  @NotNull
  private Timestamp created;
  @NotNull
  private Timestamp edited;
  @NotNull
  private int name;
  private String note;
  @OneToMany(mappedBy = "publisher")
  private Set<Postcard> postcards;
}

package com.ms.postcards.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Postcard extends BaseEntity {

  private Timestamp created;
  private Timestamp edited;
  @ManyToOne
  @JoinColumn(name="user_id")
  private User user;
  private String frontTitle;
  private String frontSubtitle;
  private int shotsCount;
  private int publicationYearIntStart;
  private int publicationYearIntEnd;
  private int condition;
  private int format;
  private int orientation;
  private Boolean written;
  private Boolean stamped;
  private Boolean mailed;
  private int printingTechnique;
  private int genre;
  private int pcsDuplicates;
  private int pcsForSale;
  private String backTitle;
  private String backSubtitle;
  private String imagePath;
  private String note;
  @OneToMany(mappedBy = "postcard")
  private List<Shot> shots;
  private String addresseeMunicipality;
  private int addresseeZip;
  @ManyToOne
  @JoinColumn(name="owner_id")
  private Owner owner;
  @ManyToOne
  @JoinColumn(name="printinghouse_id")
  private PrintingHouse printingHouse;
  @ManyToOne
  @JoinColumn(name="publisher_id")
  private Publisher publisher;
  @ManyToMany(cascade = { CascadeType.ALL })
  @JoinTable(
      name = "Postcard_PostcardTag",
      joinColumns = { @JoinColumn(name = "postcard_id") },
      inverseJoinColumns = { @JoinColumn(name = "postcardtag_id") }
  )
  Set<PostcardTag> postcardTags = new HashSet<>();





}

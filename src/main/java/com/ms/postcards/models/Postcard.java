package com.ms.postcards.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Postcard extends BaseEntity{

  private Timestamp created;
  private Timestamp edited;
  private Timestamp deleted;
  private String editor;
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
  private String note;
  @OneToMany(mappedBy = "postcard")
  private List<PostcardTag> postcardTags;
  @OneToMany(mappedBy = "postcard")
  private List<Shot> shots;
  private String addresseeMunicipality;
  private int addresseeZip;





}

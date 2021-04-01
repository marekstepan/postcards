package com.ms.postcards.models;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Postcard extends BaseEntity {

  @ManyToOne
  @JoinColumn(name = "user_id")
  @NotNull
  private User user;
  @Column(name = "front_title")
  private String frontTitle;
  @Column(name = "front_subtitle")
  private String frontSubtitle;
  @Column(name = "shots_count")
  private int shotsCount;
  @Column(name = "publication_year_int_start")
  private int publicationYearIntStart;
  @Column(name = "publication_year_int_end")
  private int publicationYearIntEnd;
  private Boolean written;
  private Boolean stamped;
  private Boolean mailed;
  @Column(name = "pcs_duplicates")
  private int pcsDuplicates;
  @Column(name = "pcs_for_sale")
  private int pcsForSale;
  @Column(name = "back_title")
  private String backTitle;
  @Column(name = "back_subtitle")
  private String backSubtitle;
  @Column(name = "image_path")
  private String imagePath;
  private String note;
  @OneToMany(mappedBy = "postcard")
  private List<Shot> shots;
  @Column(name = "addressee_zip")
  private int addresseeZip;
  @ManyToOne
  @JoinColumn(name = "owner_id")
  private Owner owner;
  @ManyToOne
  @JoinColumn(name = "printinghouse_id")
  private PrintingHouse printingHouse;
  @ManyToOne
  @JoinColumn(name = "publisher_id")
  private Publisher publisher;
  @ManyToOne
  @JoinColumn(name = "condition_id")
  private Condition condition;
  @ManyToOne
  @JoinColumn(name = "format_id")
  private Format format;
  @ManyToOne
  @JoinColumn(name = "genre_id")
  private Genre genre;
  @ManyToOne
  @JoinColumn(name = "addressee_municipality_id")
  private Municipality municipality;
  @ManyToOne
  @JoinColumn(name = "orientation_id")
  private Orientation orientation;
  @ManyToOne
  @JoinColumn(name = "printing_technique_id")
  private PrintingTechnique printingTechnique;

  @ManyToMany(cascade = { CascadeType.ALL })
  @JoinTable(
      name = "postcards_postcardtags",
      joinColumns = @JoinColumn(name = "postcard_id"),
      inverseJoinColumns = @JoinColumn(name = "postcardtag_id")
  )
  Set<PostcardTag> postcardTags;





}

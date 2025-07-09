package com.kaib.tt.catalog.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Immutable data structure used internally to represent {@code Track} data retrieved from or persisted to the
 * database.
 *
 * <p>This Data Transfer Object (DTO) serves to decouple the persistence layer from the service logic, allowing for
 * safe and testable business operations without exposing JPA entities directly.
 */
@Entity
public class TrackEntity {

  /**
   * The artist who recorded the track.
   */
  private String artist;

  /**
   * The unique identifier in the database.  Tells JPA/Hibernate to let the database column itself auto-increment the
   * primary key value.  {@code GenerationType.INCREMENT} is more standard, but this approach lets up create some H2
   * database tests with less effort, as it supports {@code GenerationType.Identity} without the extra code needed
   * for the {@code GenerationType.Increment} strategy.  This is, after all, a demonstration project whose database
   * isn't distributed, requiring UUIDs.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /**
   * The track title.
   */
  private String title;

  /**
   * Instantiates a new Track entity instance.
   */
  public TrackEntity() {
    super();
  }

  /**
   * Gets the unique identifier for this track.
   */
  public Long getId() {
    return this.id;
  }

  /**
   * Sets the unique identifier for this track.
   *
   * @param newId the unique identifier to set
   */
  public void setId(Long newId) {
    this.id = newId;
  }

  /**
   * Gets the artist who recorded this track.
   *
   * @return the artist
   */
  public String getArtist() {

    return this.artist;
  }

  /**
   * Sets the artist who recorded this track.
   *
   * @param newArtist the artist to set
   */
  public void setArtist(final String newArtist) {

    this.artist = newArtist;
  }

  /**
   * Gets the track title.
   *
   * @return the track title
   */
  public String getTitle() {

    return this.title;
  }

  /**
   * Sets the track title.
   *
   * @param newTitle the track title to set
   */
  public void setTitle(final String newTitle) {

    this.title = newTitle;
  }

  @Override
  public boolean equals(final Object other) {

    if (this == other) {
      return true;
    }
    if (other == null || this.getClass() != other.getClass()) {
      return false;
    }
    final var that = (TrackEntity) other;
    return new EqualsBuilder()
    .append(this.artist, that.artist)
    .append(this.title, that.title)
    .isEquals();
  }

  @Override
  public int hashCode() {

    return new HashCodeBuilder(19, 37)
        .append(this.artist)
        .append(this.title)
        .hashCode();
  }

  @Override
  public String toString() {

    return new ToStringBuilder(ToStringStyle.SIMPLE_STYLE)
        .append("id", this.id)
        .append("artist", this.artist)
        .append("title", this.title)
        .toString();
  }


}

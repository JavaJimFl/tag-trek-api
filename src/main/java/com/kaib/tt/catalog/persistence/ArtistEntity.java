/*
 * Copyright (c) 2025. Jim Kaib, Jr.
 * mailto:jkaibjr AT gmail DOT com
 *
 * This file is part of the TagTrek project.
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 */
package com.kaib.tt.catalog.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.util.UUID;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
public class ArtistEntity {

  /**
   * The unique identifier in the database.
   */
  @Id
  @GeneratedValue
  private UUID id;

  /**
   * The artist name.
   */
  private String name;

  /**
   * Instantiates a new Artist entity instance.
   */
  public ArtistEntity() {
    super();
  }

  /**
   * Gets the unique identifier for this artist.
   *
   * @return the unique identifier
   */
  public UUID getId() {
    return this.id;
  }

  /**
   * Sets the unique identifier for this artist.
   *
   * @param newId the unique identifier to set
   */
  public void setId(UUID newId) {
    this.id = newId;
  }

  /**
   * Gets the artist name.
   *
   * @return the artist name
   */
  public String getName() {
    return this.name;
  }

  /**
   * Sets the artist name.
   *
   * @param newName the artist name to set
   */
  public void setName(String newName) {
    this.name = newName;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (other == null || getClass() != other.getClass()) {
      return false;
    }
    final ArtistEntity that = (ArtistEntity) other;
    return new EqualsBuilder()
        .append(this.name, that.name)
        .isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder()
        .append(this.name)
        .toHashCode();
  }

  @Override
  public String toString() {

    return new ToStringBuilder(ToStringStyle.SIMPLE_STYLE)
        .append("id", this.id)
        .append("name", this.name)
        .toString();
  }
}

/*
 * Copyright (c) 2025. Jim Kaib, Jr.
 * mailto:jkaibjr AT gmail DOT com
 *
 * This file is part of the TagTrek project.
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 */
package com.kaib.tt.catalog.domain;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;

/**
 * Record that represents an artist identifier.  Could be a solo act, a band, even an orchestra.
 *
 * @param id the unique identifier for the artist, but not the database surrogate key
 *
 * @author Jim Kaib
 */
public record ArtistId(@NotNull UUID id) {

  /**
   * Gets the unique identifier for this artist.
   *
   * @return the unique identifier
   */
  public static ArtistId newID() {

    return new ArtistId(UUID.randomUUID());
  }
}

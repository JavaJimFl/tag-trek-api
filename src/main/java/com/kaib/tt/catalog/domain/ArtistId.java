/*
 * Copyright (c) 2025. Jim Kaib, Jr.
 * mailto:jkaibjr AT gmail DOT com
 *
 * This file is part of the TagTrek project.
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 */
package com.kaib.tt.catalog.domain;

import jakarta.validation.constraints.NotBlank;
import java.util.UUID;

public record ArtistId(@NotBlank UUID id) {

  public static ArtistId newID() {

    return new ArtistId(UUID.randomUUID());
  }
}

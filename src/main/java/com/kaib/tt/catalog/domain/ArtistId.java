package com.kaib.tt.catalog.domain;

import jakarta.validation.constraints.NotBlank;
import java.util.UUID;

public record ArtistId(@NotBlank UUID id) {

  public static ArtistId newID() {

    return new ArtistId(UUID.randomUUID());
  }
}

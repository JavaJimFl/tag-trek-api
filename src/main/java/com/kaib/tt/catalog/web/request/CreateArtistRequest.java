package com.kaib.tt.catalog.web.request;

import jakarta.validation.constraints.NotBlank;

public record CreateArtistRequest(@NotBlank String name){}
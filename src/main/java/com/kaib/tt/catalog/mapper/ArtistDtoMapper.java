/*
 * Copyright (c) 2025. Jim Kaib, Jr.
 * mailto:jkaibjr AT gmail DOT com
 *
 * This file is part of the TagTrek project.
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 */
package com.kaib.tt.catalog.mapper;

import com.kaib.tt.catalog.domain.Artist;
import com.kaib.tt.catalog.dto.ArtistDto;
import org.apache.commons.lang3.Validate;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

/**
 * Maps {@link Artist} domain objects to {@link ArtistDto} data transfer objects.
 *
 * @author Jim Kaib
 */
@Mapper(
    componentModel = MappingConstants.ComponentModel.SPRING,
    uses = {ArtistDtoMapper.class},
    injectionStrategy = org.mapstruct.InjectionStrategy.CONSTRUCTOR
)
public interface ArtistDtoMapper {

  /**
   * Converts a {@link Artist} to an {@link ArtistDto}.
   *
   * @param artist the entity to convert
   * @return the converted ArtistDto
   */
  default ArtistDto from(Artist artist) {

    Validate.notNull(artist, "The artist can't be null");

    final var artistDto = new ArtistDto();
    artistDto.setId(artist.artistId().id());
    artistDto.setName(artist.name());

    return artistDto;
  }
}

package com.kaib.tt.catalog.mapper;

import com.kaib.tt.catalog.domain.Artist;
import com.kaib.tt.catalog.dto.ArtistDto;
import org.apache.commons.lang3.Validate;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

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

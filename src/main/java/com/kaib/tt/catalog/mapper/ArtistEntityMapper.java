/*
 * Copyright (c) 2025. Jim Kaib, Jr.
 * mailto:jkaibjr AT gmail DOT com
 *
 * This file is part of the TagTrek project.
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 */
package com.kaib.tt.catalog.mapper;

import com.kaib.tt.catalog.domain.Artist;
import com.kaib.tt.catalog.domain.ArtistId;
import com.kaib.tt.catalog.persistence.ArtistEntity;
import org.apache.commons.lang3.Validate;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Javadoc;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

/**
 * MapStruct mapper for converting between {@link Artist} and {@link ArtistEntity} instances.
 *
 * @author Jim Kaib
 */
@Javadoc("""
    Mapper that converts between {@link Artist} and {@link ArtistEntity} instances.
    
    @author Jim Kaib
    """
)
@Mapper(
    componentModel = MappingConstants.ComponentModel.SPRING,
    injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface ArtistEntityMapper {

  /**
   * Converts a {@link ArtistEntity} to a {@link Artist}.
   *
   * @param artistEntity the entity to convert
   * @return the converted Artist
   */
  default Artist from(ArtistEntity artistEntity) {

    Validate.notNull(artistEntity, "The artist entity can't be null");

    return new Artist(new ArtistId(artistEntity.getId()), artistEntity.getName());
  }

  /**
   * Converts a {@link Artist} to a {@link ArtistEntity}.
   *
   * @param artist the Artist to convert
   * @return the converted ArtistEntity
   */
  @InheritInverseConfiguration
  default ArtistEntity from(Artist artist) {

    Validate.notNull(artist, "The artist can't be null");

    final var artistEntity = new ArtistEntity();
    artistEntity.setId(artist.artistId().id());
    artistEntity.setName(artist.name());

    return artistEntity;
  }
}

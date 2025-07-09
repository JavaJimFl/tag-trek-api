package com.kaib.tt.catalog.mapper;

import com.kaib.tt.catalog.domain.Artist;
import com.kaib.tt.catalog.domain.ArtistId;
import com.kaib.tt.catalog.persistence.ArtistEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(
    componentModel = MappingConstants.ComponentModel.SPRING,
    uses = {ArtistEntityMapper.class},
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

    if (artistEntity == null) {
      return null;
    }

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
    if (artist == null) {
      return null;
    }

    final var artistEntity = new ArtistEntity();
    artistEntity.setId(artist.artistId().id());
    artistEntity.setName(artist.name());

    return artistEntity;
  };
}

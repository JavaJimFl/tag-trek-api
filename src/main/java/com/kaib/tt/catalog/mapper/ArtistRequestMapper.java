package com.kaib.tt.catalog.mapper;

import com.kaib.tt.catalog.domain.Artist;
import com.kaib.tt.catalog.domain.ArtistId;
import com.kaib.tt.catalog.web.request.CreateArtistRequest;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(
    componentModel = MappingConstants.ComponentModel.SPRING,
    uses = {ArtistRequestMapper.class},
    injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface ArtistRequestMapper {

  /**
   * Converts a {@link CreateArtistRequest} to a {@link Artist}.
   *
   * @param request the create artist request to convert
   * @return the converted create artist request
   */
  default Artist from(CreateArtistRequest request) {

    return new Artist(ArtistId.newID(), request.name());
  }
}

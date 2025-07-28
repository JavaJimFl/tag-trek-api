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
import com.kaib.tt.catalog.web.request.CreateArtistRequest;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Javadoc;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

/**
 * MapStruct mapper for converting between {@link Artist} and {@link CreateArtistRequest} instances.
 *
 * @author Jim Kaib
 */
@Javadoc("""
    Mapper that converts between {@link Artist} and {@link CreateArtistRequest} instances.
    
    @author Jim Kaib
    """
)
@Mapper(
    componentModel = MappingConstants.ComponentModel.SPRING,
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

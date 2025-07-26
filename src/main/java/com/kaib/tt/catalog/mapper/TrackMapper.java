/*
 * Copyright (c) 2025. Jim Kaib, Jr.
 * mailto:jkaibjr AT gmail DOT com
 *
 * This file is part of the TagTrek project.
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 */
package com.kaib.tt.catalog.mapper;

import com.kaib.tt.catalog.domain.Track;
import com.kaib.tt.catalog.persistence.TrackEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Javadoc;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Javadoc(
    """
    Mapper interface for converting between {@link TrackDto} and {@link Track}.
    This interface uses MapStruct to generate the implementation at compile time.
    
    @author Jim Kaib
    """
)
@Mapper(
    componentModel = MappingConstants.ComponentModel.SPRING,
    uses = {TrackMapper.class},
    injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface TrackMapper {

  /**
   * Converts a {@link TrackEntity} to a {@link Track}.
   *
   * @param trackEntity the DTO to convert
   * @return the converted Track
   */
  Track from(TrackEntity trackEntity);

  /**
   * Converts a {@link Track} to a {@link TrackEntity}.
   *
   * @param track the Track to convert
   * @return the converted TrackDto
   */
  @InheritInverseConfiguration
  TrackEntity from(Track track);
}

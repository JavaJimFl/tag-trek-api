package com.kaib.tag_trek.track;

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
   * Converts a {@link TrackDto} to a {@link Track}.
   *
   * @param trackDto the DTO to convert
   * @return the converted Track
   */
  Track toTrack(TrackDto trackDto);

  /**
   * Converts a {@link Track} to a {@link TrackDto}.
   *
   * @param track the Track to convert
   * @return the converted TrackDto
   */
  @InheritInverseConfiguration
  TrackDto fromTrack(Track track);
}

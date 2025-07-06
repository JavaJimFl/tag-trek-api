package com.kaib.tag_trek.track;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Performs automated tests on the {@link TrackMapper} class.
 *
 * @author Jim Kaib
 */
public class TrackMapperTest {

  /**
   * The test Track instance.
   */
  private Track testTrack;

  /**
   * The test Track DTO instance.
   */
  private TrackDto testTrackDto;

  /**
   * The unit under test.
   */
  private TrackMapper uut;

  /**
   * Sets up the test fixture prior to each test.
   */
  @BeforeEach
  public void setUp() {

    this.testTrack = TrackMother.defaultTrack();
    this.testTrackDto = TrackMother.defaultTrackDto();

    this.uut = new TrackMapperImpl();
  }

  @Test
  @DisplayName("Verify that the TrackMapper converts a TrackDto to a Track correctly")
  public void testDtoToTrack1() {

    // Arrange.
    final Track expected = TrackMother.defaultTrack();

    // Act.
    final var actual = this.uut.toTrack(this.testTrackDto);

    // Assert.
    Assertions.assertThat(actual)
        .as("The TrackMapper did not convert the DTO to a Track correctly")
        .isEqualTo(expected);
  }

  @Test
  @DisplayName("Verify that the TrackMapper converts a Track to a TrackDto correctly")
  public void testTrackToDto1() {

    // Arrange.
    final TrackDto expected = TrackMother.defaultTrackDto();

    // Act.
    final TrackDto actual = this.uut.fromTrack(this.testTrack);

    // Assert.
    Assertions.assertThat(actual)
        .as("The TrackMapper did not convert the Track to a DTO correctly")
        .isEqualTo(expected);
  }
}

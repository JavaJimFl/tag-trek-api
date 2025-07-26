package com.kaib.tt.catalog.mapper;

import com.kaib.tt.catalog.domain.Track;
import com.kaib.tt.catalog.persistence.TrackEntity;
import com.kaib.tt.support.test.TrackMother;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Performs automated tests on the {@link TrackMapper} class.
 *
 * @author Jim Kaib
 */
final class TrackMapperTest {

  /**
   * The test Track instance.
   */
  private Track testTrack;

  /**
   * The test Track DTO instance.
   */
  private TrackEntity testTrackEntity;

  /**
   * The unit under test.
   */
  private TrackMapper uut;

  /**
   * Sets up the test fixture prior to each test.
   */
  @BeforeEach
  void setUp() {

    this.testTrack = TrackMother.defaultTrack();
    this.testTrackEntity = TrackMother.defaultTrackEntity();

    this.uut = new TrackMapperImpl();
  }

  @Test
  @DisplayName("Verify that the TrackMapper converts a TrackEntity to a Track correctly")
  void testFromTrackEntity1() {

    // Arrange.
    final Track expected = TrackMother.defaultTrack();

    // Act.
    final var actual = this.uut.from(this.testTrackEntity);

    // Assert.
    Assertions.assertThat(actual)
        .as("The TrackMapper did not convert the DTO to a Track correctly")
        .isEqualTo(expected);
  }

  @Test
  @DisplayName("Verify that the TrackMapper converts a Track to a TrackEntity correctly")
  void testFromTrack1() {

    // Arrange.
    final TrackEntity expected = TrackMother.defaultTrackEntity();

    // Act.
    final TrackEntity actual = this.uut.from(this.testTrack);

    // Assert.
    Assertions.assertThat(actual)
        .as("The TrackMapper did not convert the Track to a DTO correctly")
        .isEqualTo(expected);
  }
}

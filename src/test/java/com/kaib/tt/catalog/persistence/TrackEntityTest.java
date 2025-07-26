package com.kaib.tt.catalog.persistence;

import com.jparams.verifier.tostring.ToStringVerifier;
import com.kaib.tt.support.test.TrackMother;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Performs automated tests on the {@link TrackEntity} class.
 *
 * @author Jim Kaib
 */
final class TrackEntityTest {

  /**
   * The unit under test.
   */
  private TrackEntity uut;

  /**
   * Sets up the test fixture prior to each test.
   */
  @BeforeEach
  void setUp() {

    this.uut = TrackMother.defaultTrackEntity();
  }

  @Test
  @DisplayName("Verify that the artist getter and setter are wired correctly")
  void testGetArtist1() {

    // Arrange.
    final String expected = TrackMother.TEST_ARTIST;

    // Act.
    final String actual = this.uut.getArtist();

    // Assert.
    Assertions.assertThat(actual)
        .as("The artist getter and setter weren't wired correctly")
        .isEqualTo(expected);
  }

  @Test
  @DisplayName("Verify that the ID getter and setter are wired correctly")
  void testGetId1() {

    // Arrange.
    final Long expected = TrackMother.TEST_ID;

    // Act.
    final Long actual = this.uut.getId();

    // Assert.
    Assertions.assertThat(actual)
        .as("The ID getter and setter weren't wired correctly")
        .isEqualTo(expected);
  }

  @Test
  @DisplayName("Verify that the title getter and setter are wired correctly")
  void testGetTitle1() {

    // Arrange.
    final String expected = TrackMother.TEST_TITLE;

    // Act.
    final String actual = this.uut.getTitle();

    // Assert.
    Assertions.assertThat(actual)
        .as("The title getter and setter weren't wired correctly")
        .isEqualTo(expected);
  }

  @Test
  @DisplayName("Verify object equality")
  void testEquals1() {

    EqualsVerifier.forClass(TrackEntity.class)
        .usingGetClass()
        .suppress(Warning.INHERITED_DIRECTLY_FROM_OBJECT)
        .verify();
  }

  @Test
  @DisplayName("Verify the toString output is correct")
  void testToString1() {

    ToStringVerifier.forClass(TrackEntity.class).verify();
  }
}

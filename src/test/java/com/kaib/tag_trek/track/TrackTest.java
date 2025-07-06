package com.kaib.tag_trek.track;


import com.jparams.verifier.tostring.ToStringVerifier;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TrackTest {

  /**
   * The unit under test
   */
  private Track uut;

  /**
   * Sets up the test fixture prior to each test.
   */
  @BeforeEach
  void setUp() {
    this.uut = TrackMother.defaultTrack();
  }

  @Test
  @DisplayName("Verify that the Track artist is correct")
  void testGetArtist1() {

    // Arrange.
    final String expected = TrackMother.TEST_ARTIST;

    // Act.
    final String actual = this.uut.artist();

    // Assert.
    Assertions.assertThat(actual)
        .as("Track artist incorrect")
        .isEqualTo(expected);
  }

  @Test
  @DisplayName("Verify that the Track ID is correct")
  void testGetId1() {

    // Arrange.
    final Long expected = TrackMother.TEST_ID;

    // Act.
    final Long actual = this.uut.id();

    // Assert.
    Assertions.assertThat(actual)
        .as("Track ID incorrect")
        .isEqualTo(expected);
  }

  @Test
  @DisplayName("Verify that the Track title is correct")
  void testGetTitle1() {

    // Arrange.
    final String expected = TrackMother.TEST_TITLE;

    // Act.
    final String actual = this.uut.title();

    // Assert.
    Assertions.assertThat(actual)
        .as("Track title incorrect")
        .isEqualTo(expected);
   }

   @Test
   @DisplayName("Verify that the Track equals() method works correctly")
  void testEquals1() {

     // Act and Assert.
     EqualsVerifier.forClass(Track.class).verify();
   }

  @Test
  void testToString1() {

  // Act and Assert.
    ToStringVerifier.forClass(Track.class)
        .verify();

  }


}
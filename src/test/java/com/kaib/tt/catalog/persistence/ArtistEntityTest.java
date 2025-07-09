package com.kaib.tt.catalog.persistence;

import com.jparams.verifier.tostring.ToStringVerifier;
import com.kaib.tt.support.test.ArtistMother;
import java.util.UUID;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Performs automated tests on the {@code ArtistEntity} class.
 *
 * @author Jim Kaib
 */
public class ArtistEntityTest {

  /**
   * The unit under test.
   */
  private ArtistEntity uut;

  /**
   * Sets up the test fixture prior to each test.
   */
  @BeforeEach
  void setUp() {

    this.uut = ArtistMother.defaultArtistEntity();
  }

  @Test
  @DisplayName("Verify that the ArtistEntity ID getter and setter are wired correctly")
  void testGetId1() {

    // Arrange.
    final UUID expected = ArtistMother.TEST_ARTIST_UUID;

    // Act.
    final UUID actual = this.uut.getId();

    // Assert.
   Assertions.assertThat(actual)
        .as("The ID getter and setter weren't wired correctly")
        .isEqualTo(expected);
  }

  @Test
  @DisplayName("Verify that the ArtistEntity name getter and setter are wired correctly")
  void testGetName1() {

    // Arrange.
    final String expected = ArtistMother.TEST_ARTIST_NAME;

    // Act.
    final String actual = this.uut.getName();

    // Assert.
    Assertions.assertThat(actual)
        .as("The name getter and setter weren't wired correctly")
        .isEqualTo(expected);
  }

  @Test
  @DisplayName("Verify object equality")
  void testEquals1() {

    EqualsVerifier.forClass(ArtistEntity.class)
        .usingGetClass()
        .suppress(Warning.INHERITED_DIRECTLY_FROM_OBJECT)
        .verify();
  }

  @Test
  @DisplayName("Verify the toString output is correct")
  void testToString1() {

    ToStringVerifier.forClass(ArtistEntity.class).verify();
  }
}

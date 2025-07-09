package com.kaib.tt.catalog.mapper;

import com.kaib.tt.catalog.domain.Artist;
import com.kaib.tt.catalog.persistence.ArtistEntity;
import com.kaib.tt.support.test.ArtistMother;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Performs automated tests on the {@link ArtistEntityMapper} class.
 *
 * @author Jim Kaib
 */
final class ArtistEntityMapperTest {

  /**
   * The test Artist instance.
   */
  private Artist testArtist;

  /**
   * The test ArtistEntity instance.
   */
  private ArtistEntity testArtistEntity;

  /**
   * The unit under test.
   */
  private ArtistEntityMapper uut;

  /**
   * Sets up the test fixture prior to each test.
   */
  @BeforeEach
  void setUp() {

    this.testArtist = ArtistMother.defaultArtist();
    this.testArtistEntity = ArtistMother.defaultArtistEntity();

    this.uut = new ArtistEntityMapperImpl();
  }

  @Test
  @DisplayName("Verify that the ArtistEntityMapper converts an ArtistEntity to an Artist correctly")
  void testFromArtistEntity1() {

    // Arrange.
    final var expected = this.testArtist;

    // Act.
    final var actual = this.uut.from(this.testArtistEntity);

    // Assert.
    Assertions.assertThat(actual)
        .as("The ArtistEntityMapper did not convert the ArtistEntity to an Artist correctly")
        .isEqualTo(expected);
  }
}
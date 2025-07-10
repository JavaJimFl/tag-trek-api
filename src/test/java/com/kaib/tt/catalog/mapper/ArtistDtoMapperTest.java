package com.kaib.tt.catalog.mapper;

import com.kaib.tt.catalog.domain.Artist;
import com.kaib.tt.support.test.ArtistMother;
import com.kaib.tt.catalog.dto.ArtistDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Performs automated tests on the {@link ArtistDtoMapper} class.
 *
 * @author Jim Kaib
 */
final class ArtistDtoMapperTest {

  /**
   * The test Artist DTO instance.
   */
  private ArtistDto testArtistDto;

  /**
   * The test Artist instance.
   */
  private Artist testArtist;

  /**
   * The unit under test.
   */
  private ArtistDtoMapper uut;

  /**
   * Sets up the test fixture prior to each test.
   */
  @BeforeEach
  void setUp() {

    this.testArtist = ArtistMother.defaultArtist();
    this.testArtistDto = ArtistMother.defaultArtistDto();

    this.uut = new ArtistDtoMapperImpl();
  }

  @Test
  @DisplayName("Verify that the Artist is converted to an ArtistDto correctly")
  void testFromArtist1() {

    // Arrange.
    final var expected = this.testArtistDto;

    // Act.
    final var actual = this.uut.from(this.testArtist);

    // Assert.
    Assertions.assertThat(actual)
        .as("The ArtistDtoMapper did not convert the Artist to an ArtistDto correctly")
        .isEqualTo(expected);
  }

  @Test
  @DisplayName("Verify a NullPointerException is thrown when the artist to map is null")
  void testFromArtist2() {

    // Arrange.
    final String expected = "The artist can't be null";

    // Act.
    final Throwable actual = Assertions.catchThrowable(() -> this.uut.from(null));

    // Assert.
    Assertions.assertThat(actual)
        .as("A NullPointerException should have been thrown when the artist to map was null")
        .isInstanceOf(NullPointerException.class)
        .hasMessageContaining(expected);
  }
}
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
  @DisplayName("Verify a NullPointerException is thrown when the artist entity to map is null")
  void testFromArtistEntity1() {

    // Arrange.
    final String expected = "The artist entity can't be null";

    // Act.
    final Throwable actual = Assertions.catchThrowable(() -> this.uut.from((ArtistEntity) null));

    // Assert.
    Assertions.assertThat(actual)
        .as("A NullPointerException should have been thrown when the artist to map was null")
        .isInstanceOf(NullPointerException.class)
        .hasMessageContaining(expected);
  }

  @Test
  @DisplayName("Verify that the ArtistEntityMapper converts an ArtistEntity to an Artist correctly")
  void testFromArtistEntity2() {

    // Arrange.
    final var expected = this.testArtist;

    // Act.
    final var actual = this.uut.from(this.testArtistEntity);

    // Assert.
    Assertions.assertThat(actual)
        .as("The ArtistEntityMapper did not convert the ArtistEntity to an Artist correctly")
        .isEqualTo(expected);
  }

  @Test
  @DisplayName("Verify a NullPointerException is thrown when the artist entity to map is null")
  void testFromArtist1() {

    // Arrange.
    final String expected = "The artist can't be null";

    // Act.
    final Throwable actual = Assertions.catchThrowable(() -> this.uut.from((Artist) null));

    // Assert.
    Assertions.assertThat(actual)
        .as("A NullPointerException should have been thrown when the artist to map was null")
        .isInstanceOf(NullPointerException.class)
        .hasMessageContaining(expected);
  }

  @Test
  @DisplayName("Verify that the ArtistEntityMapper converts an Artist to an ArtistEntity correctly")
  void testFromArtist2() {

    // Arrange.
    final var expected = this.testArtistEntity;

    // Act.
    final var actual = this.uut.from(this.testArtist);

    // Assert.
    Assertions.assertThat(actual)
        .as("The ArtistEntityMapper did not convert the Artist to an ArtistEntity correctly")
        .isEqualTo(expected);
  }

  // The arist ID doesn't participate in the equality check, so we need to test it separately.
  @Test
  @DisplayName("Verify the artist ID is mapped correctly")
  void setTestArtist3() {

    // Arrange.
    final var expected = ArtistMother.TEST_ARTIST_UUID;

    // Act.
    final var actual = this.uut.from(this.testArtist).getId();

    // Assert.
    Assertions.assertThat(actual)
        .as("The ArtistEntityMapper did not map the artist ID correctly")
        .isEqualTo(expected);

  }

}
package com.kaib.tt.catalog.mapper;

import com.kaib.tt.catalog.domain.Artist;
import com.kaib.tt.catalog.web.request.CreateArtistRequest;
import com.kaib.tt.support.test.ArtistMother;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Performs automated tests on the {@link ArtistRequestMapper} class.
 *
 * @author Jim Kaib
 */
final class ArtistRequestMapperTest {

  /**
   * The test CreateArtistRequest instance.
   */
  private CreateArtistRequest testCreateArtistRequest;

  /**
   * The test Artist instance.
   */
  private Artist testArtist;

  /**
   * The unit under test.
   */
  private ArtistRequestMapper uut;

  /**
   * Sets up the test fixture prior to each test.
   */
  @BeforeEach
  void setUp() {

    this.testCreateArtistRequest = ArtistMother.defaultCreateArtistRequest();
    this.testArtist = ArtistMother.defaultArtist();

    this.uut = new ArtistRequestMapperImpl();
  }

  @Test
  @DisplayName("Verify that the CreateArtistRequestMapper maps the AristId in AN ArtistRequest to an Artist correctly")
  void testFromCreateArtistRequest1() {

    // Arrange.
    final String expected = "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[1-5][0-9a-fA-F]{3}-[89abAB][0-9a-fA-F]{3}-[0-9a-fA-F]{12}$";

    // Act.
    final var artist = this.uut.from(this.testCreateArtistRequest);
    final String actual = artist.artistId().id().toString();

    // Assert.
    Assertions.assertThat(actual)
        .as("The TrackMapper did not convert the CreateArtistRequest to an Artist correctly")
        .matches(expected);
  }

  @Test
  @DisplayName("Verify that the CreateArtistRequestMapper maps the ArtistName in an ArtistRequest to an Artist"
      + " correctly")
  void testFromCreateArtistRequest2() {

    // Arrange.
    final String expected = this.testCreateArtistRequest.name();

    // Act.
    final var artist = this.uut.from(this.testCreateArtistRequest);
    final String actual = artist.name();

    // Assert.
    Assertions.assertThat(actual)
        .as("The TrackMapper did not convert the CreateArtistRequest to an Artist correctly")
        .isEqualTo(expected);
  }
}
package com.kaib.tt.catalog.service;

import com.kaib.tt.catalog.domain.Artist;
import com.kaib.tt.catalog.mapper.ArtistEntityMapper;
import com.kaib.tt.catalog.mapper.ArtistEntityMapperImpl;
import com.kaib.tt.catalog.persistence.ArtistEntity;
import com.kaib.tt.catalog.persistence.ArtistRepository;
import com.kaib.tt.support.test.ArtistMother;
import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * Performs automated tests on the {@code ArtistService} class.
 *
 * @author Jim Kaib
 */
@ExtendWith(MockitoExtension.class)
final class ArtistServiceTest {

  /**
   * The mock that simulates the behavior of the artist repository.
   */
  @Mock
  private ArtistRepository mockArtistRepository;

  /**
   * The test artist.
   */
  private Artist testArtist;

  /**
   * The test artist JPA entity.
   */
  private ArtistEntity testArtistEntity;

  /**
   * The test mapper that converts artist entities to artist domain objects.
   */
  private ArtistEntityMapper testArtistEntityMapper;

  /**
   * The unit under test.
   */
  private ArtistService uut;

  /**
   * Sets up the test fixture prior to each test.
   */
  @BeforeEach
  void setUp() {

    this.testArtist = ArtistMother.defaultArtist();
    this.testArtistEntity = ArtistMother.defaultArtistEntity();
    this.testArtistEntityMapper = new ArtistEntityMapperImpl();
    this.uut = new ArtistService(this.mockArtistRepository, this.testArtistEntityMapper);
  }

  @Test
  @DisplayName("Verify a NullPointerException is thrown when the artist to create is null")
  void testCreate1() {

    // Arrange.
    final String expected = "The artist can't be null";

    // Act.
    final Throwable actual = Assertions.catchThrowable(() -> this.uut.create(null));

    // Assert.
    Assertions.assertThat(actual)
        .as("A NullPointerException should have been thrown when the artist to create was null")
        .isInstanceOf(NullPointerException.class)
        .hasMessageContaining(expected);
  }

  @ParameterizedTest
  @ValueSource(strings = {"", " "})
  @DisplayName("Verify an IllegalArgumentException is thrown when the artist name is null or empty")
  void testCreate2(final String testArtistName) {

    // Arrange.
    this.testArtist = ArtistMother.builder().withName(testArtistName).buildArtist();
    final String expected = "The artist name can't be null, empty, or blank";

    // Act.
    final Throwable actual = Assertions.catchThrowable(() -> this.uut.create(this.testArtist));

    // Assert.
    Assertions.assertThat(actual)
        .as("An IllegalArgumentException should have been thrown when the artist name was null or empty")
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining(expected);
  }

  @Test
  @DisplayName("Verify that the ArtistService creates an artist correctly")
  void testCreate3() {

    // Arrange.
    final var expected = this.testArtist;
    Mockito.when(this.mockArtistRepository.save(this.testArtistEntity))
        .thenReturn(this.testArtistEntity);

    // Act.
    final var actual = this.uut.create(this.testArtist);

    // Assert.
    Assertions.assertThat(actual)
        .as("The ArtistService did not create the artist correctly")
        .isEqualTo(expected);
  }

  @Test
  @DisplayName("Verify a NullPointerException is thrown when the artist ID used for the search is null")
  void testFindById1() {

    // Arrange.
    final String expected = "The artist ID can't be null";

    // Act.
    final Throwable actual = Assertions.catchThrowable(() -> this.uut.findById(null));

    // Assert.
    Assertions.assertThat(actual)
        .as("A NullPointerException should have been thrown when the artist ID used for the search was null")
        .isInstanceOf(NullPointerException.class)
        .hasMessageContaining(expected);
  }

  @Test
  @DisplayName("Verify that the ArtistService finds an artist by ID correctly")
  void testFindById2() {

    // Arrange.
    final var testArtistId = ArtistMother.TEST_ARTIST_UUID;
    final var expected = Optional.of(this.testArtist);
    final var expectedArtistEntity = this.testArtistEntity;
    Mockito.when(this.mockArtistRepository.findById(testArtistId))
        .thenReturn(Optional.of(expectedArtistEntity));

    // Act.
    final var actual = this.uut.findById(testArtistId);

    // Assert.
    Assertions.assertThat(actual)
        .as("The ArtistService did not find the artist by ID correctly")
        .isEqualTo(expected);
  }

  @Test
  @DisplayName("Verify an empty Optional is returned when the artist ID used for the search is not found")
  void testFindById3() {

    // Arrange.
    final var testArtistId = ArtistMother.TEST_ARTIST_UUID;
    Mockito.when(this.mockArtistRepository.findById(testArtistId))
        .thenReturn(Optional.empty());

    // Act.
    final var actual = this.uut.findById(testArtistId);

    // Assert.
    Assertions.assertThat(actual)
        .as("The ArtistService should have returned an empty Optional when the artist ID was not found")
        .isEmpty();
  }
}

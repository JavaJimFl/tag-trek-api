package com.kaib.tt.support.test;

import com.kaib.tt.catalog.domain.Artist;
import com.kaib.tt.catalog.domain.ArtistId;
import com.kaib.tt.catalog.dto.ArtistDto;
import com.kaib.tt.catalog.persistence.ArtistEntity;
import com.kaib.tt.catalog.web.request.CreateArtistRequest;
import java.util.UUID;

/**
 * Factory class for creating test instances of:
 *
 * <ul>
 *   <li>{@code Artist}</li>
 *   <li>{@code ArtistEntity}</li>
 *   <li>{@code ArtistDto}</li>
 *   <li>{@code CreateArtistRequest}</li>
 * </ul>
 * <p>
 * Which use the same default values for properties such as name and ID.
 *
 * <p>This class provides a fluent API to build instances with default values or custom attributes, facilitating
 * unit testing and ensuring consistency across tests.
 *
 * @author Jim Kaib
 */
public class ArtistMother {

  /**
   * The default test artist name.
   */
  public static final String TEST_ARTIST_NAME = "testArtistName";

  /**
   * The default test artist ID string value.
   */
  public static final String TEST_ARTIST_UUID_STR = "739a956e-d67b-40fc-94e2-03f35425fb0c";

  /**
   * The default test artist ID.
   */
  public static final UUID TEST_ARTIST_UUID =  UUID.fromString(TEST_ARTIST_UUID_STR);

  /**
   * The default test artist ID object.
   */
  public static final ArtistId TEST_ARTIST_ID_OBJECT = new ArtistId(TEST_ARTIST_UUID);

  /**
   * Creates a new {@link Builder} instance for constructing {@link ArtistEntity} and {@link Artist} objects.
   *
   * @return a new {@link Builder} instance
   */
  public static Builder builder() {

    return new Builder();
  }

  /**
   * Creates a default {@link ArtistEntity} instance with predefined values.
   *
   * @return a {@link ArtistEntity} instance with default values
   */
  public static ArtistEntity defaultArtistEntity() {

    return builder().buildDefaultEntity();
  }

  /**
   * Creates a default {@link CreateArtistRequest} instance with predefined values.
   *
   * @return a {@link CreateArtistRequest} instance with default values
   */
  public static CreateArtistRequest defaultCreateArtistRequest() {

    return builder().buildCreateArtistRequest();
  }

  /**
   * Creates a default {@link Artist} instance with predefined values.
   *
   * @return a {@link Artist} instance with default values
   */
  public static Artist defaultArtist() {

    return builder().buildArtist();
  }

  /**
   * Creates a default {@link ArtistDto} instance with predefined values.
   *
   * @return a {@link ArtistDto} instance with default values
   */
  public static ArtistDto defaultArtistDto() {

    return builder().buildArtistDto();
  }

  /**
   * Builder class for constructing {@link ArtistEntity} and {@link Artist} objects with customizable properties.
   */
  public static class Builder {

    /**
     * The test artist name.
     */
    private String name = TEST_ARTIST_NAME;

    /**
     * The test artist ID.
     */
    private final UUID id = TEST_ARTIST_UUID;

    /**
     * The test artist ID object.
     */
    private ArtistId artistId = TEST_ARTIST_ID_OBJECT;

    /**
     * Adds a new artist name to the builder before returning it.
     *
     * @return the current {@link Builder} instance for method chaining
     */
    public Builder withName(final String newName) {

      this.name = newName;
      return this;
    }

    /**
     * Adds a new artist ID to the builder before returning it.
     *
     * @return the current {@link Builder} instance for method chaining
     */
    public Builder withArtistId(final ArtistId newId) {

      this.artistId = newId;
      return this;
    }

    /**
     * Builds a default {@link ArtistEntity} instance with the current properties of the builder.
     *
     * @return a new {@link ArtistEntity} instance
     */
    public ArtistEntity buildDefaultEntity() {

      final var artistEntity = new ArtistEntity();
      artistEntity.setName(name);
      artistEntity.setId(id);

      return artistEntity;
    }

    /**
     * Builds a default {@link ArtistDto} instance with the current properties of the builder.
     *
     * @return a new {@link ArtistDto} instance
     */
    public ArtistDto buildArtistDto() {

      final var artistDto = new ArtistDto();
      artistDto.setName(name);
      artistDto.setId(id);

      return artistDto;
    }

    /**
     * Builds a default {@link Artist} instance with the current properties of the builder.
     *
     * @return a new {@link Artist} instance
     */
    public Artist buildArtist() {

      return new Artist(this.artistId, this.name);
    }

    /**
     * Builds a default {@link CreateArtistRequest} instance with the current properties of the builder.
     *
     * @return a new {@link CreateArtistRequest} instance
     */
    public CreateArtistRequest buildCreateArtistRequest() {

      return new CreateArtistRequest(this.name);
    }
  }
}


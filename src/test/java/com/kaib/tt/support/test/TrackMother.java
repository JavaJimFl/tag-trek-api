package com.kaib.tt.support.test;

import com.kaib.tt.catalog.domain.Track;
import com.kaib.tt.catalog.persistence.TrackEntity;

/**
 * Factory class for creating test instances of {@link Track} and {@link TrackEntity}.
 *
 * <p>This class provides a fluent API to build instances with default values or custom attributes, facilitating
 * unit testing and ensuring consistency across tests.
 *
 * @author Jim Kaib
 */
public class TrackMother {

  /**
   * Default track artist name used in tests.
   */
  public static final String TEST_ARTIST = "testArtist";

  /**
   * Default track ID used in tests.
   */
  public static final Long TEST_ID = 1L;

  /**
   * Default track title used in tests.
   */
  public static final String TEST_TITLE = "testTitle";

  /**
   * Creates a new {@link Builder} instance for constructing {@link TrackEntity} and {@link Track} objects.
   *
   * @return a new {@link Builder} instance
   */
  public static Builder builder() {

    return new Builder();
  }

  /**
   * Creates a default {@link TrackEntity} instance with predefined values.
   *
   * @return a {@link TrackEntity} instance with default values
   */
  public static TrackEntity defaultTrackEntity() {
    return builder().buildDefaultTrackEntity();
  }

  /**
   * Creates a default {@link Track} instance with predefined values.
   *
   * @return a {@link Track} instance with default values
   */
  public static Track defaultTrack() {
    return builder().buildDefaultTrack();
  }

  /**
   * Builder class for constructing {@link TrackEntity} and {@link Track} instances with customizable properties.
   */
  static class Builder {

    /**
     * The default artist name for the track.
     */
    private String artist = TEST_ARTIST;

    /**
     * The default ID for the track.
     */
    private Long id = TEST_ID;

    /**
     * The default title for the track.
     */
    private String title = TEST_TITLE;

    /**
     * Adds a new artist to the builder before returning it.
     *
     * @param newArtist the artist to set
     * @return the current {@link Builder} instance for method chaining
     */
    public Builder withArtist(String newArtist) {

      this.artist = newArtist;
      return this;
    }


    /**
     * Adds a new ID to the builder before returning it.
     *
     * @param newId the ID to set
     * @return the current {@link Builder} instance for method chaining
     */
    public Builder withId(Long newId) {

      this.id = newId;
      return this;
    }

    /**
     * Adds a new title to the builder before returning it.
     *
     * @param newTitle the title to set
     * @return the current {@link Builder} instance for method chaining
     */
    public Builder withTitle(String newTitle) {
      this.title = newTitle;
      return this;
    }

    /**
     * Builds a default {@link TrackEntity} instance with the current values set in the builder.
     *
     * @return a {@link TrackEntity} instance with the specified attributes
     */
    public TrackEntity buildDefaultTrackEntity() {

      final var trackDto = new TrackEntity();
      trackDto.setArtist(this.artist);
      trackDto.setId(this.id);
      trackDto.setTitle(this.title);

      return trackDto;
    }

    /**
     * Builds a default {@link Track} instance with the current values set in the builder.
     *
     * @return a {@link Track} instance with the specified attributes
     */
    public Track buildDefaultTrack() {

      return new Track(this.id, this.title, this.artist);
    }
  }
}

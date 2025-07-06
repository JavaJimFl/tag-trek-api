package com.kaib.tag_trek.track;

/**
 * Factory class for creating test instances of {@link Track} and {@link TrackDto}.
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
   * Creates a new {@link Builder} instance for constructing {@link TrackDto} and {@link Track} objects.
   *
   * @return a new {@link Builder} instance
   */
  public static Builder builder() {
    return new Builder();
  }

  /**
   * Creates a default {@link TrackDto} instance with predefined values.
   *
   * @return a {@link TrackDto} instance with default values
   */
  public static TrackDto defaultTrackDto() {
    return builder().buildDefaultDto();
  }

  /**
   * Creates a default {@link Track} instance with predefined values.
   *
   * @return a {@link Track} instance with default values
   */
  public static Track defaultTrack() {
    return builder().buildDefaultTrack();
  }


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

    public Builder withArtist(String newArtist) {

      this.artist = newArtist;
      return this;
    }

    public Builder withId(Long newId) {

      this.id = newId;
      return this;
    }

    public Builder withTitle(String newTitle) {
      this.title = newTitle;
      return this;
    }

    public TrackDto buildDefaultDto() {

      final var trackDto = new TrackDto();
      trackDto.setArtist(this.artist);
      trackDto.setId(this.id);
      trackDto.setTitle(this.title);

      return trackDto;
    }

    public Track buildDefaultTrack() {

      return new Track(this.id, this.title, this.artist);
    }
  }
}

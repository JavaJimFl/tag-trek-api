package com.kaib.tt.catalog.domain;

/**
 * Record that represents an artist.  Could be a solo act, a band, even an orchestra

 * @param artistId the unique identifier for the artist, typically the database surrogate key
 * @param name the artist name
 *
 * @author Jim Kaib
 */
public record Artist(ArtistId artistId, String name) {}

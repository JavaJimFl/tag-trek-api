package com.kaib.tt.catalog.domain;

/**
 * Record that represents an album track.  Typically, a song.

 * @param id the unique identifier for the track, typically the database surrogate key
 * @param title the track title
 * @param artist the artist who recorded the track
 *
 * @author Jim Kaib
 */
public record Track(Long id, String title, String artist) {
}
package com.kaib.tt.catalog.service;

import com.kaib.tt.catalog.domain.Track;
import com.kaib.tt.catalog.persistence.TrackRepository;

public class TrackService {


  private final TrackRepository trackRepository;

  public TrackService(final TrackRepository trackRepository) {
    this.trackRepository = trackRepository;
  }


  public Iterable<Track> getAllTracks() {

return null;
  }
}

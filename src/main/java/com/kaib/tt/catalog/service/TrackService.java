/*
 * Copyright (c) 2025. Jim Kaib, Jr.
 * mailto:jkaibjr AT gmail DOT com
 *
 * This file is part of the TagTrek project.
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 */
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

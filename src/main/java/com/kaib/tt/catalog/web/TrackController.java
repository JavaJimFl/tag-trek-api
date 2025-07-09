package com.kaib.tt.catalog.web;

import com.kaib.tt.catalog.domain.Track;
import com.kaib.tt.catalog.service.TrackService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController // Uncomment this line to enable the controller
@RequestMapping("/tracks")
public class TrackController {


  private final TrackService trackService;

  /**
   * Instantiate a new TrackController using the provided TrackService.
   *
   * @param trackService the service to use for track operations
   */
  public TrackController(TrackService trackService) {
    this.trackService = trackService;
  }

  @GetMapping
  public Iterable<Track> getAllTracks() {

    final Iterable<Track> tracks = trackService.getAllTracks();
    return trackService.getAllTracks();
  }

}

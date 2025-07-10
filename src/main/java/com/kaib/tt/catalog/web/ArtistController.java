package com.kaib.tt.catalog.web;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.kaib.tt.catalog.domain.Artist;
import com.kaib.tt.catalog.dto.ArtistDto;
import com.kaib.tt.catalog.mapper.ArtistDtoMapper;
import com.kaib.tt.catalog.mapper.ArtistRequestMapper;
import com.kaib.tt.catalog.service.ArtistService;
import com.kaib.tt.catalog.web.request.CreateArtistRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.Optional;
import java.util.UUID;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/artists")
public class ArtistController {

  /**
   * The service used to perform CRUD operations on artists.
   */
  private final ArtistService artistService;

  /**
   * The mapper used to convert create artist requests to artist domain instances.
   */
  private final ArtistRequestMapper artistRequestMapper;

  /**
   * The mapper used to convert artist domain instances to artist DTOs.
   */
  private final ArtistDtoMapper artistDtoMapper;

  /**
   * Instantiate a new ArtistController using the provided ArtistService.
   *
   * @param artistService       the service to use for artist operations
   * @param artistRequestMapper the mapper to convert create artist requests to artist domain instances
   * @param artistDtoMapper     the mapper to convert artist domain instances to artist DTOs
   */
  public ArtistController(final ArtistService artistService, final ArtistRequestMapper artistRequestMapper,
      final ArtistDtoMapper artistDtoMapper) {

    this.artistService = artistService;
    this.artistRequestMapper = artistRequestMapper;
    this.artistDtoMapper = artistDtoMapper;
  }

  @PostMapping
  public ResponseEntity<EntityModel<ArtistDto>> createArtist(@RequestBody @Valid CreateArtistRequest request) {

    final var artist = this.artistRequestMapper.from(request);
    final var saved = artistService.create(artist);
    final var artistDto = this.artistDtoMapper.from(saved);

    final var model = EntityModel.of(artistDto)
        .add(linkTo(methodOn(ArtistController.class).getArtist(artistDto.getId()))
            .withSelfRel());

    return ResponseEntity.created(model.getRequiredLink("self").toUri())
        .body(model);
  }

  @GetMapping("/{id}")
  public ResponseEntity<EntityModel<ArtistDto>> getArtist(@PathVariable final UUID id) {

    return this.artistService.findById(id).map(artist ->
    {
      final var artistDto = this.artistDtoMapper.from(artist);
      final var model = EntityModel.of(artistDto)
          .add(linkTo(methodOn(ArtistController.class).getArtist(id)).withSelfRel());

      return ResponseEntity.ok(model);
    }).orElseGet(() -> ResponseEntity.notFound().build());
  }
}

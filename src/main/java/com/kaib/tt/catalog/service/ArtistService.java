package com.kaib.tt.catalog.service;

import com.kaib.tt.catalog.domain.Artist;
import com.kaib.tt.catalog.mapper.ArtistEntityMapper;
import com.kaib.tt.catalog.persistence.ArtistEntity;
import com.kaib.tt.catalog.persistence.ArtistRepository;
import jakarta.validation.Valid;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service for managing artists in the catalog.
 * <p>
 * This service provides methods to create and find artists. It uses an {@link ArtistRepository} for data access and an
 * {@link ArtistEntityMapper} to convert between domain objects and persistence entities.
 * <p>
 * It's pretty anemic, but there may be opportunities to add more business logic in the future.
 */
@Service
public class ArtistService {

  /**
   * The repository used to perform CRUD operations on artists.
   */
  private final ArtistRepository repository;

  /**
   * The mapper used to convert artist entities to artist domain objects.
   */
  private final ArtistEntityMapper entityMapper;

  /**
   * Instantiate a new ArtistService using the provided ArtistRepository.
   *
   * @param artistRepository   the repository to use for artist operations
   * @param artistEntityMapper the mapper to convert artist entities to artist domain objects
   */
  public ArtistService(final ArtistRepository artistRepository,
      final ArtistEntityMapper artistEntityMapper) {

    this.repository = artistRepository;
    this.entityMapper = artistEntityMapper;
  }

  /**
   * Creates a new artist from the provided request.
   *
   * @param artist the artist to create, which must be valid according to the validation rules defined in the Artist
   *               class.
   * @return the created Artist
   */
  @Transactional
  public Artist create(@Valid Artist artist) {

    final ArtistEntity artistEntity = this.entityMapper.from(artist);
    final ArtistEntity saved = this.repository.save(artistEntity);

    return this.entityMapper.from(saved);
  }

  /**
   * Finds an artist by its unique identifier.
   *
   * @param id the unique identifier of the artist to find
   * @return an Optional containing the found Artist, or an empty Optional if no artist with the given ID exists
   */
  @Transactional(readOnly = true)
  public Optional<Artist> findById(final UUID id) {

    final Optional<ArtistEntity> entity = this.repository.findById(id);

    return entity.map(this.entityMapper::from);
  }
}

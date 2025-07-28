/*
 * Copyright (c) 2025. Jim Kaib, Jr.
 * mailto:jkaibjr AT gmail DOT com
 *
 * This file is part of the TagTrek project.
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 */
package com.kaib.tt.catalog.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for managing TrackEntity objects.
 *
 * <p>Provides methods to perform CRUD operations on tracks.
 *
 * @author Jim Kaib, Jr.
 */
public interface TrackRepository extends JpaRepository<TrackEntity, Long> {

}

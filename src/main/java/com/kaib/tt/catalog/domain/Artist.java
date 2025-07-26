/*
 * Copyright (c) 2025. Jim Kaib, Jr.
 * mailto:jkaibjr AT gmail DOT com
 *
 * This file is part of the TagTrek project.
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 */
package com.kaib.tt.catalog.domain;

/**
 * Record that represents an artist.  Could be a solo act, a band, even an orchestra

 * @param artistId the unique identifier for the artist, typically the database surrogate key
 * @param name the artist name
 *
 * @author Jim Kaib
 */
public record Artist(ArtistId artistId, String name) {}

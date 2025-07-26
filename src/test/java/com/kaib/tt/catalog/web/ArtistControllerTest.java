package com.kaib.tt.catalog.web;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kaib.tt.catalog.domain.Artist;
import com.kaib.tt.catalog.dto.ArtistDto;
import com.kaib.tt.catalog.mapper.ArtistDtoMapper;
import com.kaib.tt.catalog.mapper.ArtistRequestMapper;
import com.kaib.tt.catalog.service.ArtistService;
import com.kaib.tt.catalog.web.request.CreateArtistRequest;
import com.kaib.tt.support.test.ArtistMother;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * Performs automated tests on the {@link ArtistController} class.
 *
 * @author Jim Kaib
 */
@AutoConfigureMockMvc
@WebMvcTest(ArtistController.class)
final class ArtistControllerTest {

  /**
   * The mock Spring Model-View-Controller (MVC) instance used to perform requests and verify responses.
   */
  @Autowired
  private MockMvc mockMvc;

  /**
   * The mock that simulates the behavior of the artist service.
   */
  @MockBean
  private ArtistService mockArtistService;

  /**
   * The mock that simulates the behavior of the create artist request to artist mapper.
   */
  @MockBean
  private ArtistRequestMapper mockArtistRequestMapper;

  /**
   * The mock that simulates the behavior of the artist to artist DTO mapper.
   */
  @MockBean
  private ArtistDtoMapper mockArtistDtoMapper;

  /**
   * The Jackson ObjectMapper used to serialize and deserialize JSON.
   */
  @Autowired
  private ObjectMapper objectMapper;

  /**
   * The test Artist instance used for input and creation.
   */
  private Artist testArtistInput;

  /**
   * The test Artist instance that simulates the created artist.
   */
  private Artist testArtistCreated;

  /**
   * The test Artist DTO instance.
   */
  private ArtistDto testArtistDto;

  /**
   * The test Artist ID.
   */
  private UUID testArtistId;

  /**
   * The test create artist request instance.
   */
  private CreateArtistRequest testCreateArtistRequest;

  /**
   * Sets up the test fixture prior to each test.
   */
  @BeforeEach
  void setUp() {

    this.testArtistId = ArtistMother.TEST_ARTIST_UUID;
    this.testArtistInput = ArtistMother.builder().withArtistId(null).buildArtist();
    this.testArtistCreated = ArtistMother.defaultArtist();
    this.testArtistDto = ArtistMother.defaultArtistDto();
    this.testCreateArtistRequest = ArtistMother.defaultCreateArtistRequest();
  }

  @Test
  @DisplayName("Verify a successful response (200) is returned when retrieving an existing artist")
  void testGetArtist1() throws Exception {

    // Given.
    final var expectedArtistName = ArtistMother.TEST_ARTIST_NAME;
    final var expectedArtistId = ArtistMother.TEST_ARTIST_UUID_STR;
    final var expectedHateoasLink = "http://localhost/artists/739a956e-d67b-40fc-94e2-03f35425fb0c";
    given(this.mockArtistService.findById(this.testArtistId)).willReturn(Optional.of(this.testArtistCreated));
    given(this.mockArtistDtoMapper.from(this.testArtistCreated)).willReturn(this.testArtistDto);

    // When/Then.
    mockMvc.perform(get("/artists/{id}", this.testArtistId))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.name").value(expectedArtistName))
        .andExpect(jsonPath("$.id").value(expectedArtistId))
        .andExpect(jsonPath("$._links.self.href").value(expectedHateoasLink));
  }

  @Test
  @DisplayName("Verify a not found (404) response is returned when retrieving an artist and the artist is not found")
  void testGetArtist2() throws Exception {

    // Given.
    final var expectedArtistId = ArtistMother.TEST_ARTIST_UUID_STR;
    given(this.mockArtistService.findById(this.testArtistId)).willReturn(Optional.empty());

    // When/Then.
    mockMvc.perform(MockMvcRequestBuilders.get("/artists/{id}", this.testArtistId))
        .andExpect(status().isNotFound());
  }

  @Test
  @DisplayName("Verify a bad request (400) response is returned when retrieving an artist and the artist ID is invalid")
  void testGetArtist3() throws Exception {

    // Given.
    final var invalidArtistId = "invalid-uuid";

    // When/Then.
    mockMvc.perform(MockMvcRequestBuilders.get("/artists/{id}", invalidArtistId))
        .andExpect(status().isBadRequest());
  }

  @Test
  @DisplayName("Verify that the ArtistController returns a 400 when creating an artist and the artist ID is blank")
  void testCreateArtist1() throws Exception {

    // Given.
    final String testArtistId = " ";

    // When/Then.
    mockMvc.perform(MockMvcRequestBuilders.post("/artists", testArtistId))
        .andExpect(status().isBadRequest());
  }

  @Test
  @DisplayName("Verify a successful response is returned when the artist is created")
  void testCreateArtist2() throws Exception {

    // Given.
    final var expectedArtistName = ArtistMother.TEST_ARTIST_NAME;
    final var expectedArtistId = ArtistMother.TEST_ARTIST_UUID_STR;
    final var expectedHateoasLink = "http://localhost/artists/739a956e-d67b-40fc-94e2-03f35425fb0c";
    given(this.mockArtistRequestMapper.from(this.testCreateArtistRequest)).willReturn(this.testArtistInput);
    given(this.mockArtistService.create(this.testArtistInput)).willReturn(this.testArtistCreated);
    given(this.mockArtistDtoMapper.from(this.testArtistCreated)).willReturn(this.testArtistDto);

    // When/Then.
    mockMvc.perform(post("/artists")
            .contentType("application/json")
            .content(this.objectMapper.writeValueAsString(this.testCreateArtistRequest)))
        .andExpect(status().isCreated())
        .andExpect(header().string("Location", expectedHateoasLink))
        .andExpect(jsonPath("$.name").value(expectedArtistName))
        .andExpect(jsonPath("$.id").value(expectedArtistId))
        .andExpect(jsonPath("$._links.self.href").value(expectedHateoasLink));
  }
}
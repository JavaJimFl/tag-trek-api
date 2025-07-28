package com.kaib.tt;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Performs automated tests on the {@link TagTrekApplication} class.
 *
 * <p>This class is used to verify that the Spring application context loads correctly.
 *
 * @author Jim Kaib, Jr.
 */
@SpringBootTest
class TagTrekApplicationTests {


  @DisplayName("Verify that the Spring application context loads correctly")
  @Test
  void testContextLoads() {
    // This test will pass if the application context loads successfully.
    // No additional assertions are needed.
  }

}

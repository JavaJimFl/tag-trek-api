/*
 * Copyright (c) 2025. Jim Kaib, Jr.
 * mailto:jkaibjr AT gmail DOT com
 *
 * This file is part of the TagTrek project.
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 */
package com.kaib.tt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The main application class for the TagTrek application.
 * <p>
 * This class serves as the entry point for the Spring Boot application.
 * </p>
 */
@SpringBootApplication
public class TagTrekApplication {

  /**
   * The main method that starts the Spring Boot application.
   *
   * @param args command line arguments (not used)
   */
  public static void main(String[] args) {
    SpringApplication.run(TagTrekApplication.class, args);
  }

}

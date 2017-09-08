/*
 * Copyright 2015, Optimal Payments PLC, 2 Place Alexis Nihon, suite 700, Westmount, Quebec, Canada
 * All rights reserved.
 * 
 * This software is the confidential and proprietary information of Optimal Payments PLC
 * ("Confidential Information"). You shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement you entered into with Optimal
 * Payments.
 */

package com.online.dataplatformeureka;

import static com.google.common.io.Resources.getResource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ResourceBanner;
import org.springframework.boot.SpringApplication;
import org.springframework.core.env.Environment;
import org.springframework.core.io.UrlResource;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Helper class for Spring Boot application startup. Copied from framework to avoid using framework
 * as a dependency just for this class. Adding framework adds liquibase dependencies.
 */
public final class StartupHelper {

  public static final Logger logger = LoggerFactory.getLogger(StartupHelper.class);

  /**
   * Private constructor.
   */
  private StartupHelper() {
  }

  /**
   * Print out the final message after starting up.
   * 
   * @param applicationName String
   */
  public static void launch(@SuppressWarnings("rawtypes") Class bootRunClass, String[] args,
      String applicationName) throws UnknownHostException {
    SpringApplication app = new SpringApplication(bootRunClass);
    app.setBanner(new ResourceBanner(new UrlResource(getResource("banner.txt"))));
    Environment env = app.run(args).getEnvironment();

    logger.info(
        "Access URLs:\n----------------------------------------------------------\n\t" + "***** "
            + applicationName + " ***** \n\n\t" + "Local: \t\thttp://127.0.0.1:{}\n\t"
            + "External: \thttp://{}:{}\n\t"
            + "Profiles: \t{}\n----------------------------------------------------------",
        env.getProperty("server.port"), InetAddress.getLocalHost().getHostAddress(),
        env.getProperty("server.port"), env.getProperty("SPRING_PROFILES_ACTIVE"));

    logger.info(applicationName + " has started");
  }
}
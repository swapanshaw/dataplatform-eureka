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

public final class StartupLauncher {

  public static final Logger logger = LoggerFactory.getLogger(StartupLauncher.class);

  /**
   * Private constructor.
   */
  private StartupLauncher() {
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

    logger.info(env.getProperty("server.port"), InetAddress.getLocalHost().getHostAddress(),
        env.getProperty("server.port"), env.getProperty("SPRING_PROFILES_ACTIVE"));

    logger.info(applicationName + " has started");
  }
}
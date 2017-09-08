package com.online.dataplatformeureka;

import java.net.UnknownHostException;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DataplatformEurekaApplication {

	public static void main(String[] args) throws UnknownHostException {
		StartupLauncher.launch(DataplatformEurekaApplication.class, args, "Discovery Application");
	}
}

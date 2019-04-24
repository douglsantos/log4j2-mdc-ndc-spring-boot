package com.github.douglsantos;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ComponentScan(basePackages = {
		"com.github.douglsantos"
})
@SpringBootApplication
public class Log4j2MdcNdcSpringBootApplication {
	 private static final Logger LOG = LogManager.getLogger(Log4j2MdcNdcSpringBootApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(Log4j2MdcNdcSpringBootApplication.class, args);
	}

	@GetMapping("/ok/{caller}")
	public HttpStatus ok(@RequestHeader String requestId, @PathVariable String caller) {
		LOG.info("Request received. PathVariable is: [{}]", caller);

		return HttpStatus.OK;
	}
}

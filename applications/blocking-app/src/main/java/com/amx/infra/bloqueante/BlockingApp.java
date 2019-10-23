package com.amx.infra.bloqueante;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class BlockingApp {

  public static void main(String[] args) {
    SpringApplication.run(BlockingApp.class, args);
  }

  private static final String DELAY_SERVICE_URL = "http://192.10.24.4:30004";

  private final RestTemplate client;

  public BlockingApp(RestTemplateBuilder builder) {
    client = builder.rootUri(DELAY_SERVICE_URL).build();
  }

  @RequestMapping("/")
  public String home() {
 	return "Hello soy la aplicación BLOQUEANTE";
  }

  @GetMapping("/{delayMillis}")
  public String get(@PathVariable String delayMillis) {
    String result = client.getForObject("/" + delayMillis, String.class);
    return "Blocking:" + result;
  }
}

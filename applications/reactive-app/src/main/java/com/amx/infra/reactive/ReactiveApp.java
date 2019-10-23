package com.amx.infra.reactive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@SpringBootApplication
@RestController
public class ReactiveApp {

  public static void main(String[] args) {
    SpringApplication.run(ReactiveApp.class, args);
  }

  private static final String DELAY_SERVICE_URL = "http://192.10.24.4:30004";

  private final WebClient client = WebClient.create(DELAY_SERVICE_URL);

  @RequestMapping("/")
  public String home() {
      return "Hola soy la aplicación REACTIVA";
  }

  @GetMapping("/{delayMillis}")
  public Mono<String> get(@PathVariable String delayMillis) {
    return client.get()
        .uri("/api/" + delayMillis)
        .retrieve()
        .bodyToMono(String.class)
        .map(s -> "Reactive:" + s);
  }

  @GetMapping("api-async/colaboradores")
  public Mono<String> getAsyncColaboradores() {
    return client.get()
        .uri("/api/empleados")
        .retrieve()
        .bodyToMono(String.class)
        .map(s -> "Reactive:" + s);
  }

}

package com.amx.infra.directorio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.Duration;

@SpringBootApplication
@RestController
@EnableSwagger2
public class ColaboradorApiService {

  public static void main(String[] args) {
    SpringApplication.run(ColaboradorApiService.class, args);
  }

  @GetMapping("/api/{delayMillis}")
  public Mono<String> get(@PathVariable int delayMillis) {
    return Mono.just("OK")
        .delayElement(Duration.ofMillis(delayMillis));
  }
}

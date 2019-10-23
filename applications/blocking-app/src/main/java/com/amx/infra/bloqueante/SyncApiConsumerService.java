package com.amx.infra.bloqueante;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SyncApiConsumerService{

   private final RestTemplate restTemplate;

   public SyncApiConsumerService(RestTemplateBuilder builder) {
      restTemplate = builder.rootUri("http://192.10.24.4:30004").build();
   }

   @RequestMapping(value = "/api-sync/colaboradores")
   public String getColaboradoresList() {
      HttpHeaders headers = new HttpHeaders();
      String respuesta = null;
      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
      HttpEntity <String> entity = new HttpEntity<String>(headers);
      System.out.println("Entramos metod GET cliente API.");
      respuesta = restTemplate.exchange("http://192.10.24.4:30004/api/empleados", HttpMethod.GET, entity, String.class).getBody();
      System.out.println("Response: " + respuesta); 
      return respuesta;
   }
}

package com.city.connected.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


public interface CityRoutesResource {
    String sourceDestination(@RequestParam String origin, @RequestParam String destination) throws IOException;
}

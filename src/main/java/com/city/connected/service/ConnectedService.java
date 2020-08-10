package com.city.connected.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;


public interface ConnectedService {

    String sourceDestination( String origin, String destination) throws IOException;
}

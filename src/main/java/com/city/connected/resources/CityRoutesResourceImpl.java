package com.city.connected.resources;

import com.city.connected.service.ConnectedServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class CityRoutesResourceImpl implements CityRoutesResource{

        private final Logger log = LoggerFactory.getLogger(CityRoutesResourceImpl.class);

    @Autowired
    ConnectedServiceImpl connectedServiceImpl;

    @GetMapping("/connected")
    public String sourceDestination(@RequestParam  String origin,@RequestParam String destination)  {
        log.debug("CityRoutesResourceImpl sourceDestination : start");

        return connectedServiceImpl.sourceDestination(origin.trim(), destination.trim());
    }
}

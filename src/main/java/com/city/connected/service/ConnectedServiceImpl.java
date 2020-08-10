package com.city.connected.service;

import com.city.connected.helper.ConnectedServiceHelper;
import io.micrometer.core.instrument.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ConnectedServiceImpl implements ConnectedService {
    private final Logger log = LoggerFactory.getLogger(ConnectedServiceImpl.class);

    @Autowired
    ConnectedServiceHelper helper;

    @Override
    public String sourceDestination(String origin, String destination)  {
       log.debug("ConnectedServiceImpl sourceDestination : start");
       // Read all city routes, get all Origin City connected routes
       String isConnectedYesNo= helper.findPathExist(origin,destination);
       if(StringUtils.isBlank(isConnectedYesNo)){
           isConnectedYesNo="no";
       }
        log.debug("ConnectedServiceImpl sourceDestination : end");
       return isConnectedYesNo;
    }
}

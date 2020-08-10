package com.city.connected.helper;

import io.micrometer.core.instrument.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

@Component
public class ConnectedServiceHelper {

    private final Logger log = LoggerFactory.getLogger(ConnectedServiceHelper.class);

    protected LinkedHashSet<String> readTextCityFile() throws IOException {
        log.debug("ConnectedServiceHelper readTextCityFile : start");
        LinkedHashSet<String> readAllPaths = new LinkedHashSet<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(new ClassPathResource("city.txt").getInputStream()));
        Scanner sc = new Scanner(reader);
        while (sc.hasNextLine()) {
            String route = sc.nextLine().trim();
            readAllPaths.add(route);
        }
        log.debug("ConnectedServiceHelper readTextCityFile : end");
        return readAllPaths;
    }

    private Set<String> getUniqueMiddleCity(Set<String> storeAllPaths, String City1, String City2) {
        log.debug("ConnectedServiceHelper getUniqueMiddleCity : start");
        Set<String> uniqueMiddleCities = new LinkedHashSet<>();
        for (String eachPath : storeAllPaths) {
            String[] record = eachPath.split(",");
            if (StringUtils.isNotBlank(City1)) {
                if (eachPath.contains(City1)) {
                    if (record[0].trim().equalsIgnoreCase(City1.trim())) {
                        uniqueMiddleCities.add(record[1].trim());
                    } else if (record[1].trim().equalsIgnoreCase(City1.trim())) {
                        uniqueMiddleCities.add(record[0].trim());
                    }
                }
            } else if (StringUtils.isNotBlank(City2)){
                if(eachPath.contains(City2)){
                    if(record[0].trim().equalsIgnoreCase(City2.trim())){
                        uniqueMiddleCities.add(record[1].trim());
                    }else if(record[1].trim().equalsIgnoreCase(City2.trim())){
                        uniqueMiddleCities.add(record[0].trim());
                    }
                }
            }
        }
        log.debug("ConnectedServiceHelper getUniqueMiddleCity : end");
        return uniqueMiddleCities;
    }

    public String findPathExist(String City1, String City2){
        log.debug("ConnectedServiceHelper findPathExist : start");
        String isConnectedYesNo="";
        try {
            // read text file
            LinkedHashSet<String> storeAllPaths= readTextCityFile();

            // Get routes from Source and Destination
            // Get routes from Source and Destination
            Set<String> sourcePaths = getUniqueMiddleCity(storeAllPaths,City1,null);
            Set<String> destinationPaths = getUniqueMiddleCity(storeAllPaths,null,City2);

           // System.out.println( " ==sourcePaths=> "+ sourcePaths);
           // System.out.println( " ==destinationPaths=> "+ destinationPaths);

            if(destinationPaths.contains(City1) && sourcePaths.contains(City2)){
                isConnectedYesNo="yes";
            } else {

                String result = sourceSetCheck(sourcePaths, destinationPaths, City2);
                if (result.equalsIgnoreCase("NO")) {
                    result = sourceSetCheck(destinationPaths, sourcePaths, City1);
                }
                isConnectedYesNo = result;
            }
            log.debug("ConnectedServiceHelper findPathExist : end");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isConnectedYesNo;
    }

    private String sourceSetCheck(Set<String> sourcePaths,Set<String> destinationPaths, String City2){
        log.debug("ConnectedServiceHelper sourceSetCheck : start");
        String result="";
        for(String eachLinkedCity: sourcePaths){
            if(destinationPaths.contains(eachLinkedCity)){
                System.out.println( "S Yes "+eachLinkedCity+" linked" + destinationPaths +" "+City2);
                result="Yes";
                break;
            }else {
                System.out.println("No "+eachLinkedCity+" linked"+ destinationPaths);
                result="No";
            }
        }
        log.debug("ConnectedServiceHelper sourceSetCheck : end");
        return result;
    }
}

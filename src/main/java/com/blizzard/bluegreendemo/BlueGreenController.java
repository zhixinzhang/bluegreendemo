package com.blizzard.bluegreendemo;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlueGreenController {

    @RequestMapping("/bluegreenapi/tz")
    public ResponseEntity<Object> singleAPICall(@RequestParam(defaultValue = "America/Los_Angeles") String timeZone){
        Map<String, String> curTime = new HashMap<>();        
        String datePattern = "dd/MM/yyyy HH:mm:ss";
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(datePattern);

        LocalDateTime localDateAndTime = LocalDateTime.now(ZoneId.of(timeZone));
        System.out.println("Current time in timeZone: " + localDateAndTime.toLocalTime());

        String currentTime = localDateAndTime.format(dateFormatter);
        long returnTime = System.currentTimeMillis();

        curTime.put("Current time", currentTime);
        curTime.put("Enviroment", "new Blue (Prod)");
        curTime.put("TTLB", String.valueOf(returnTime));
        // curTime.put("Enviroment", "new Green (Test)");
        return new ResponseEntity<>(curTime, HttpStatus.OK);
    }
}

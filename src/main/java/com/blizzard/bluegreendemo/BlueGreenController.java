package com.blizzard.bluegreendemo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlueGreenController {

    @RequestMapping("/bluegreenapi")
    public ResponseEntity<Object> singleAPICall(){
        Map<String, String> curTime = new HashMap<>();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
        Date date = new Date();  
        System.out.println(formatter.format(date));  
        
        String requestTime = formatter.format(date);
        long returnTime = System.currentTimeMillis();

        curTime.put("Current time", requestTime);
        // curTime.put("Enviroment", "Blue (Prod)");
        curTime.put("TTLB", String.valueOf(returnTime));
        curTime.put("Enviroment", "Green (Test)");
        return new ResponseEntity<>(curTime, HttpStatus.OK);
    }

    @RequestMapping("/bluegreenapi/multiplecalls")
    public ResponseEntity<Object> multipleCalls(){
        Map<String, String> curTime = new HashMap<>();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
        for (int i = 0; i < 10; i++){
            Date date = new Date();  
            System.out.println(formatter.format(date));  
            
            String requestTime = formatter.format(date);
            curTime.put("Current time", requestTime);
        } 
        
        return new ResponseEntity<>(curTime, HttpStatus.OK);
        // return curTime;
    }
}

package com.blizzard.bluegreendemo;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MultipleAPICall {
    private static final String localURL = "http://localhost:8080/bluegreenapi";
    private static final String awsCloudURL = "http://localhost:8080/bluegreenapi";

    public static void main(String[] args) throws IOException, InterruptedException {
        poolTask();
    }

    // This is a task that is scheduled at a fixed frequency, creating 10 core threads with a 2-second delay for the first execution and every 3 seconds for subsequent executions.
    private static void poolTask() throws IOException, InterruptedException{
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(10); 

        pool.scheduleAtFixedRate(() -> { 
            try {
                callXTimesPerSecond();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            } 
        }, 1000, 500, TimeUnit.MILLISECONDS); 
    }

    private static void callXTimesPerSecond () throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(localURL))
                .build();

        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
    }
}

package com.blizzard.bluegreendemo;

import java.io.IOException;

import org.apache.hc.core5.http.HttpStatus;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.springframework.boot.test.context.SpringBootTest;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;



@SpringBootTest
public class APITest {
    private final String demoURL = "http://localhost:8080/bluegreenapi";

    @Test
    public void TTLDC_OneSuccess() throws ClientProtocolException, IOException {
    
        // Given
        HttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(demoURL);
        httpClient.execute(httpGet, response -> {
            assertThat(response.getStatusLine().getStatusCode()).isEqualTo(HttpStatus.SC_OK);
            return response;
        });
    }

    @Test
    public void TTLDC_XSuccess() throws ClientProtocolException, IOException {
    
        for (int i = 0; i < 1000; i++){
            HttpClient httpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(demoURL);
            HttpResponse response = httpClient.execute(httpGet);
            
            System.out.println("testing " + i + " " + response.getStatusLine().getStatusCode());
            assertThat(response.getStatusLine().getStatusCode()).isEqualTo(HttpStatus.SC_OK);
            
        }
    }
}

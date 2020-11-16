package com.lyadev.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Spotify {

    public String getName(String trackid) throws IOException {
       // String Name = null;
       // String[] str = url.split("/");
        String testurl = "https://api.spotify.com/v1/tracks/" + trackid;
        System.out.println(testurl);
        URL trackurl = new URL(testurl);
        HttpURLConnection connection = (HttpURLConnection) trackurl.openConnection();

        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/json");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Authorization", "Bearer BQAiPRiaLpTMbs3oGVkRxb7bScFlfv5igjU_4tij5cPIqp8QKlwH1zCE0jGmaID5qvs1-NMpDAin7auXkVsyY_A39zIZhdKOEz9hi39A0sGgFNCI3Y2u1RM0W7il7Rjq4yLdd0fXiYSZ-syDKBQlSEM_e7p6EV0ekwdaQgg");

        String test = "";

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        String output;
        StringBuffer response = new StringBuffer();

        while ((output = in.readLine()) != null ){
            response.append(output);
        }
        in.close();


return response.toString();
    }
}

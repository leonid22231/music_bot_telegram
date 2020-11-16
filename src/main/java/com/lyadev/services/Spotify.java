package com.lyadev.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Spotify {

    public String getName(String url) throws IOException {
        String Name = null;
        URL trackurl = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) trackurl.openConnection();

        connection.setRequestMethod("GET");

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

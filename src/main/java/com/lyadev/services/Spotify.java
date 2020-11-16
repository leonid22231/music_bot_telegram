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

        connection.setRequestProperty("Authorization", "Bearer BQB_P5FdxLWcLQuu81CjXxB20LvLStOrBoDKRSG-FFcu5YzjutwgLnQYOUysnpflm3nvUG5OjKe7-1l0rTwsrTuyqTamDpPNt066KOuLSo6PuLsZC_pcW7w-8IN7WCdWiK0mjarctLP3OeiJpJZoqVl983vEPSiOZu4ow_U");

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

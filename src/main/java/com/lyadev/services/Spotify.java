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

        connection.setRequestProperty("Authorization", "Bearer BQDWX6ZA_Fu1ehQde_5mzZwCC-c-zkYSDdNoF-yiX9GtodF8x3buMYM-_rgNMFW0y13zTjTfIN_7HaKwMN26xeVPdqPp8xc5CusM57U-b5dkQpLvhRMrw019rFNJt4sW7cZfw1y0gT60-s0--kRijc-NLJnGxwmW9IodDzk");

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

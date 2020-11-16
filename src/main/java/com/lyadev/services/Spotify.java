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
        String testurl = " \" " + url + "\" -H \"Accept: application/json\" -H \"Content-Type: application/json\" -H \"Authorization: Bearer BQBvgLRnzfliQ4V8d63ACw2dJPEh0k42rQ9DShrJH8NGWvruKXUgH70AIV2icd-2S8dvgBqdyvQLa3fwZEETSDAOSrtNqdp36cHJmsIAMwk3Sqx-k4fa1KeJvRdov7SCllYjxjvvUzAjYMtZeE7p9yNGUrIjkvIr1U7x6oA";
        URL trackurl = new URL(testurl);
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

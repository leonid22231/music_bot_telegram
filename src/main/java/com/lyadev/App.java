package com.lyadev;

import com.lyadev.BD.bd;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.generics.Webhook;
import org.telegram.telegrambots.generics.WebhookBot;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.sql.SQLException;
import java.util.List;


/**
 * Hello world!
 *
 */
public class App
{
private static String SpotifyClientID = "4d4f47f7f1294b2fb5119cf4928966c1";
private static String SpotifyClientSecret = "f438908d11784af798afacbbb751d9fd";
private static String SpotifyURL = "https://accounts.spotify.com/authorize";
    public static void main( String[] args ) throws SQLException, ClassNotFoundException, URISyntaxException {
        System.out.println("Starting...");
        bd.Conn();
        bd.CreateDB();
        try {
            URL surl = new URL(SpotifyURL);
            HttpURLConnection connection = (HttpURLConnection) surl.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("client_id",SpotifyClientID);
            connection.setRequestProperty("response_type","code");
            connection.setRequestProperty("redirect_uri","");

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String output;
            StringBuffer response = new StringBuffer();

            while ((output = in.readLine()) != null ){
                response.append(output);
            }
            in.close();
            System.out.println(response.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ApiContextInitializer.init();
        TelegramBotsApi botapi = new TelegramBotsApi();
        try {
            botapi.registerBot(new Bot());
        }catch (TelegramApiRequestException e){
            e.printStackTrace();
        }
        System.out.println("Hello, logs!");
    }



    }


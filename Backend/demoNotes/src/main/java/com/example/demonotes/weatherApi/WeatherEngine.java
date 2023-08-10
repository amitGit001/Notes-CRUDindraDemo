package com.example.demonotes.weatherApi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherEngine {

    public static void main(String[] args) {
        String apiUrl = "https://api.open-meteo.com/v1/forecast?latitude=23.2599&longitude=77.4126&hourly=temperature_2m,weathercode&forecast_days=1"; // Replace with the actual API endpoint
        try {
            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // Set request method (GET, POST, PUT, DELETE, etc.)
            conn.setRequestMethod("GET");

            // Set headers or authentication tokens if required
            // conn.setRequestProperty("Authorization", "Bearer YOUR_ACCESS_TOKEN");

            int responseCode = conn.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                System.out.println("API Response: " + response.toString());
                // Process the API response here
            } else {
                System.err.println("API Request failed with status code: " + responseCode);
                // Handle other error cases
            }
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

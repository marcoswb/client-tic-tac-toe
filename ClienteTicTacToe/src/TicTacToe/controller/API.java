package TicTacToe.controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class API {
    
    private static final String BASE_URL = "http://127.0.0.1:5000/register";
    
    public boolean CreateUser(String name, String nickname, String password) throws Exception {       
        String jsonBody = "{\"name\": \""+ name +"\", \"nickname\": \""+ nickname +"\", \"password\": \""+ password + "\"}";
        
        URL urlObj = new URL(BASE_URL);
        HttpURLConnection connection = (HttpURLConnection) urlObj.openConnection();
        
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);
        
        try (DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream())) {
            outputStream.writeBytes(jsonBody);
            outputStream.flush();
        }
        
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
        }
        
        connection.disconnect();
        return true;
    }
}

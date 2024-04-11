package TicTacToe.utils;

import org.json.JSONException;
import org.json.JSONObject;


public class ResponseModel {
    private int responseCode;
    private String responseText = "";

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public void setResponseText(String responseText) throws JSONException {
        this.responseText = getMessageKey(responseText);
    }
    
    public int getResponseCode() {
        return responseCode;
    }

    public String getResponseText() {
        return responseText;
    }
    
    private String getMessageKey(String body) throws JSONException{
        String message = "";
        JSONObject obj = new JSONObject(body);
        System.out.println(obj.getString("message"));
        message = obj.getString("message");
        
        return message;
    }
    
}

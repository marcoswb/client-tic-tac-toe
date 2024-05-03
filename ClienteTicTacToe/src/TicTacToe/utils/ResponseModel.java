package TicTacToe.utils;

import org.json.JSONException;
import org.json.JSONObject;


public class ResponseModel {
    private int responseCode;
    private Object responseText = "";

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public void setResponseText(String responseText) throws JSONException {
        this.responseText = getMessageKey(responseText, "message");
    }
    
    public void setData(String responseText, String keySearch) throws JSONException {
        this.responseText = getMessageKey(responseText, keySearch);
    }
    
    public int getResponseCode() {
        return responseCode;
    }

    public Object getResponseText() {
        return responseText;
    }
    
    private Object getMessageKey(String body, String keySearch) throws JSONException{
        String message = "";
        JSONObject obj = new JSONObject(body);
        message = obj.get(keySearch).toString();
        
        return message;
    }
    
}

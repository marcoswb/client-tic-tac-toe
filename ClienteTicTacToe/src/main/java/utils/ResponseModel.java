package utils;


import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    public String getMessageKey(String body, String keySearch){
        String message = "";
        JSONObject obj = null;
        try {
            obj = new JSONObject(body);
        } catch (JSONException ex) {
            Logger.getLogger(ResponseModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            message = obj.get(keySearch).toString();
        } catch (JSONException ex) {
            Logger.getLogger(ResponseModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return message;
    }
    
}

package utils;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;


public class ResponseModel {
    private int responseCode;
    private Object responseText = "";
    private String body = "";
    private static final Logger LOGGER = LogManager.getLogger();

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

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
    
    public String getMessageKey(String body, String keySearch){
        String message = "";
        JSONObject obj = null;
        try {
            obj = new JSONObject(body);
        } catch (JSONException ex) {
            LOGGER.error("Erro na função getMessageKey 1 `{}`", ex.getMessage());
        }
        try {
            message = obj.get(keySearch).toString();
        } catch (JSONException ex) {
            LOGGER.error("Erro na função getMessageKey 2 `{}`", ex.getMessage());
        }
        
        return message;
    }
    
}

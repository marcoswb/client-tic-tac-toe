package TicTacToe.utils;


public class ResponseModel {
    public int responseCode;
    public String responseText = "";

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public void setResponseText(String responseText) {
        this.responseText = responseText;
    }
    
    public int getResponseCode() {
        return responseCode;
    }

    public String getResponseText() {
        return responseText;
    }
    
}

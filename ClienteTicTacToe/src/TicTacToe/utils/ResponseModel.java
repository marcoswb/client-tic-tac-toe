package TicTacToe.utils;


public class ResponseModel {
    private int responseCode;
    private String responseText = "";

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

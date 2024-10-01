package utils;

public class JsonData {

    private String json = "";

    public void addKeyJson(String key, String value) {
        if (json.equals("")) {
            json = "\"" + key + "\": \"" + value + "\"";
        } else {
            json += ",\"" + key + "\": \"" + value + "\"";
        }
    }

    public String getJson() {
        return "{" + json + "}";
    }
}

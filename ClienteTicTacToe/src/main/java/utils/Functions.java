package utils;

public class Functions {

    public boolean IsNull(String value) {
        String formated_value = value.trim();

        return formated_value.equals("");
    }
}

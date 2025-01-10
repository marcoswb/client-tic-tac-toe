package utils;

public class Functions {

    public boolean IsNull(String value) {
        String formated_value = value.trim();
        if(value.startsWith("Informe s")){
            return true;
        }

        return formated_value.equals("");
    }
}

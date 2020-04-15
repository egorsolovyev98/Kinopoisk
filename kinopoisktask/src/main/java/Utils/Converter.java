package Utils;

public class Converter {

    public static int parseInt(String value)
    {
        value = value.substring(1, value.length() - 1).replaceAll(" ", "");
        return Integer.parseInt(value);
    }
}

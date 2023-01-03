package Projecto.utils;

public class Validations {

    public static boolean isValidateIsoDate(String text) {
        return text != null && text.isBlank() && text.trim().matches("^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$");
    }

    public static boolean isNotBlank(String txt) {
        return txt != null && txt.isBlank();
    }

}

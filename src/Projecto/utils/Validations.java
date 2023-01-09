package Projecto.utils;

/**
 *
 * Classe que gere algumas das validações de dados
 * @author Joana Ramalho
 * @author Tiago Sousa
 */
public class Validations {

    /**
     * Método que valida uma data no formato LocalDate
     * @param text recebe uma String que representa a data
     * @return true se for compatível com formato LocalDate
     */
    public static boolean isValidateIsoDate(String text) {
        return text != null && !text.isBlank() && text.trim().matches("^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$");
    }

    /**
     * Método que valida se a String txt está vazia
     * @param txt recebe uma String que representa o texto inserido pelo utilizador
     * @return true se a String estiver vazia
     */
    public static boolean isNotBlank(String txt) {
        return txt != null && txt.isBlank();
    }

}

package utils;

import exception.BadNumberValue;

/**
 * Класс для проверки на валидацию
 */
public class Validator {

    /**
     * Проверяет строку на наличие в ней цифровых символов
     * @param input проверяемая строка
     * @return строка в случае успешной проверки, исключение в случае неуспешной
     */
    public static String validateInputNumber (String input) {
        if (input.matches("^\\d+$")) {
            return input; }
        else {
            throw new BadNumberValue("Number is have bad value: " + input); }
        }

    /**
     * Проверяет строку на наличие в ней операции вычисления
      * @param input проверяемая строка
     * @return строка в случае успешной проверки, исключение в случае неуспешной
     */
    public static String validateInputOperation (String input) {
        if (input.matches("[\\*\\+\\-\\/]?")) {
            return input; }
        else {
            throw new BadNumberValue("Operation is have bad value: " + input); }
        }

}

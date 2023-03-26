package calculator.exception;

/**
 * Исключение в случае вееденого невалидного значения
 */
public class BadNumberValue extends RuntimeException{
    public BadNumberValue (String message) {
        super(message);
    }
}

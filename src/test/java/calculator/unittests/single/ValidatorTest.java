package single;

import calculator.exception.BadNumberValue;
import io.qameta.allure.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Validator;
import static org.testng.Assert.assertEquals;

/**
 * Набор отдельных тестов для класс валидотор
 */
@Epic("Тесты на класс валидатор")
@Feature("Single тесты")
public class ValidatorTest {

    /**
     * Создание переменной класса валидатор
     */
    Validator validator;

    /**
     * Метод, который выполняется перед каждым тестом, создает объект класса
     */
    @BeforeMethod
    public void setUp () {
    validator = new Validator(); }

    /**
     * Позитивная проверка ввода числа
     */
    @Test
    @Story("Тестирование валидации цифры")
    @Severity(SeverityLevel.BLOCKER)
    public void testInputNumberPositive() {
        String testNumber = "3";
        assertEquals(validator.validateInputNumber(testNumber), "3");
    }

    /**
     * Негативная проверка ввода числа
     */
    @Test(expectedExceptions = BadNumberValue.class)
    @Story("Тестирование валидации цифры")
    @Severity(SeverityLevel.CRITICAL)
    public void testInputNumberNegative() {
        String testNumber = "a";
        validator.validateInputNumber(testNumber);
    }

    /**
     * Позитивная проверка ввода операции вычисления
     */
    @Test
    @Story("Тестирование валидации операции вычисления")
    @Severity(SeverityLevel.NORMAL)
    public void testInputOperPositive() {
        String testNumber = "+";
        assertEquals(validator.validateInputOperation(testNumber), "+");
    }

    /**
     * Негативная проверка ввода операции вычисления
     */
    @Test(expectedExceptions = BadNumberValue.class)
    @Story("Тестирование валидации оперции вычисления")
    public void testInputOperNegative() {
        String testNumber = "4";
        validator.validateInputOperation(testNumber);
    }
}

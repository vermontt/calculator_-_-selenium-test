package single;

import exception.BadNumberValue;
import io.qameta.allure.*;
import model.Concatenator;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Validator;

import static org.testng.Assert.assertEquals;

/**
 * Набор отдельных тестов для класса конкатенатор
 */
@Epic("Тесты на класс конкатенатор")
@Feature("Single тесты")
public class ConcatenatorTest {

    /**
     * Создание переменной класса конкатенатор
     */
    private Concatenator concatenator;

    /**
     * Метод, который выполняется перед каждым тестом, создает объект класса
     */
    @BeforeMethod
    public void setUp () {
        concatenator = new Concatenator(); }

    /**
     * Позитивная проверка сложения
     */
    @Test
    @Story("Тест метода сложение")
    @Severity(SeverityLevel.CRITICAL)
    public void testPlusStringPositive() {
        String testNumber1 = "1";
        String testNumber2 = "5";
        assertEquals (concatenator.plusString(testNumber1, testNumber2), "6");
    }

    /**
     * Негативная проверка сложения
     */
    @Test(expectedExceptions = NumberFormatException.class)
    @Story("Тест метода сложение")
    @Severity(SeverityLevel.NORMAL)
    public void testPlusStringNegative() {
        String testNumber1 = "F";
        String testNumber2 = "5";
        concatenator.plusString(testNumber1, testNumber2);
    }

    /**
     * Позитивная проверка вычитания
     */
    @Test
    @Story("Тест метода вычитание")
    @Severity(SeverityLevel.CRITICAL)
    public void testMinusStringPositive() {
        String testNumber1 = "1";
        String testNumber2 = "5";
        assertEquals (concatenator.minusString(testNumber1, testNumber2), "-4");
    }

    /**
     * Негативная проверка вычитания
     */
    @Test(expectedExceptions = NumberFormatException.class)
    @Story("Тест метода вычитание")
    @Severity(SeverityLevel.NORMAL)
    public void testMinusStringNegative() {
        String testNumber1 = "t";
        String testNumber2 = "5";
        concatenator.minusString(testNumber1, testNumber2);
    }

    /**
     * Позитивная проверка умножения
     */
    @Test
    @Story("Тест метода умножение")
    @Severity(SeverityLevel.BLOCKER)
    public void testMultiStringPositive() {
        String testNumber1 = "1";
        String testNumber2 = "5";
        assertEquals (concatenator.multiplictionString(testNumber1, testNumber2), "5");
    }

    /**
     * Негативная проверка умножения
     */
    @Test(expectedExceptions = NumberFormatException.class)
    @Story("Тест метода умножение")
    @Severity(SeverityLevel.CRITICAL)
    public void testMultiStringNegative() {
        String testNumber1 = "h";
        String testNumber2 = "5";
        concatenator.multiplictionString(testNumber1, testNumber2);
    }

    /**
     * Позитивная проверка деления
     */
    @Test
    @Story("Тест метода деление")
    public void testDivisionStringPositive() {
        String testNumber1 = "10";
        String testNumber2 = "5";
        assertEquals (concatenator.divisionString(testNumber1, testNumber2), "2");
    }

    /**
     * Негативная проверка деления
     */
    @Test(expectedExceptions = NumberFormatException.class)
    @Story("Тест метода деление")
    public void testDivisionStringNegative() {
        String testNumber1 = "r";
        String testNumber2 = "5";
        concatenator.divisionString(testNumber1, testNumber2);
    }

    /**
     * Негативная проверка деления на 0
     */
    @Test(expectedExceptions = BadNumberValue.class)
    @Story("Тест метода деление")
    public void testDivisionZero(){
        String testNumber1 = "10";
        String testNumber2 = "0";
        concatenator.divisionString(testNumber1, testNumber2);
    }

}

package parametrized;

import calculator.exception.BadNumberValue;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.Validator;

import static org.testng.Assert.assertEquals;

/**
 * Набор тестов с DataProvider для класса Validator
 */
@Epic("Тесты на класс валидатор")
@Feature("Параметризованные тесты")
public class ValidatorDataProvider {

    /**
     * Создание объекта класса валидатор
     */
    private Validator validator;

    /**
     * Метод, который выполняется перед каждым тестом, создает объект класс
     */
    @BeforeMethod
    public void setUp () {
        validator = new Validator(); }

    /**
     * DataProvider с тестовыми данными для проведения позитивных и негативных проверок валидации числа
     * @return двумерный массив объектов
     */
    @DataProvider
    public Object[][] getValidatorPositiveNegativeParams () {
        return new Object[][]{
                {new String[] {"1", "d"}, "1"},
                {new String[] {"5", "+"}, "5"}
        };
    }

    /**
     * Параметризованный позитивный тест
     * @param num тестовые данные
     * @param res ожидаемый результат
     */
    @Test(dataProvider = "getValidatorPositiveNegativeParams")
    @Story("Позитивные тесты на валидацию цифры")
    public void testPositiveNumberValidator (String[] num, String res) {
        assertEquals(validator.validateInputNumber(num[0]), res);
    }

    /**
     * Параметризованный негативный тест
     * @param num тестовые данные
     * @param res не используется в методе, но передается от DataProvider, чтобы не создавать отдельный DataProvider
     */
    @Test(dataProvider = "getValidatorPositiveNegativeParams", expectedExceptions = BadNumberValue.class)
    @Story("Негативные тесты на валидацию цифры")
    public void testNegativeNumberValidator (String[] num, String res) {
        validator.validateInputNumber(num[1]);
    }

    /**
     * DataProvider с тестовыми данными для проведения позитивных и негативных проверок валидации операции вычисления
     * @return двумерный массив объектов
     */
    @DataProvider
    public Object[][] getValidatorPositiveNegativeOper () {
        return new Object[][]{
                {new String[] {"+", "d"}, "+"},
                {new String[] {"/", "66"}, "/"}
        };
    }

    /**
     * Параметризированный позитивный тест
     * @param num тестовые данные
     * @param res ожидаемый результат
     */
    @Test(dataProvider = "getValidatorPositiveNegativeOper")
    @Story("Позитивные тесты на валидацию операции вычисления")
    @Description(useJavaDoc = true)
    public void testPositiveOperValidator (String[] num, String res) {
        assertEquals(validator.validateInputOperation(num[0]), res);
    }

    /**
     * Параметризированный негативный тест
     * @param num тестовые данные
     * @param res не используется в методе, но передается, чтобы не создавать новый DataProvider
     */
    @Test(dataProvider = "getValidatorPositiveNegativeOper", expectedExceptions = BadNumberValue.class)
    @Story("Негативные тесты на валидацию операции вычисления")
    public void testNegativeOperValidator (String[] num, String res) {
        validator.validateInputOperation(num[1]);
    }



}

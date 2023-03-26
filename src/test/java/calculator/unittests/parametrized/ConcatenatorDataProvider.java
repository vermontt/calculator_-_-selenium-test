package parametrized;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import model.Concatenator;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Набор тестов с DataProvider для класса Concatenator
 */
@Epic("Тесты на класс конкатенатор")
@Feature("Параметризованные тесты")
public class ConcatenatorDataProvider {

    /**
     * Создание объекта класса конкатенатор
     */
    private Concatenator concatenator;

    /**
     * Метод, который выполняется перед каждым тестом, создает объект класса
     */
    @BeforeMethod
    public void setUp () {
        concatenator = new Concatenator(); }

    /**
     * DataProvider с тестовыми данными для проведения позитивных проверок вычисления
     * @return двумерный массив обектов
     */
    @DataProvider
    public Object[][] getTestAndExpectedData () {
        return new Object[][]{
                {new String[] {"1", "2"}, new String[] {"3", "-1", "2", "0"}},
                {new String[] {"3","10"}, new String[] {"13", "-7", "30", "0"}}
        };
    }

    /**
     * Параметризованный позитивный тест сложения
     * @param number тестовые данные
     * @param res ожидаемый результат
     */
    @Test(dataProvider = "getTestAndExpectedData")
    @Story("Позитивные тесты функции сложения")
    @Description(useJavaDoc = true)
    public void testPlusStringDataProvider(String[] number, String[] res) {
        assertEquals(concatenator.plusString(number[0], number[1]), res[0]);}

    /**
     * Параметризованный позитивный тест вычитания
     * @param number тестовые данные
     * @param res ожидаемый результат
     */
    @Test(dataProvider = "getTestAndExpectedData")
    @Story("Позитивные тесты функции вычитания")
    @Description(useJavaDoc = true)
    public void testMinusStringDataProvider(String[] number, String[] res) {
        assertEquals(concatenator.minusString(number[0], number[1]), res[1]);}

    /**
     * Параметризованный позитивный тест умножения
     * @param number тестовые данные
     * @param res ожидаемый результат
     */
    @Test(dataProvider = "getTestAndExpectedData")
    @Story("Позитивные тесты функции умножения")
    public void testMultiStringDataProvider(String[] number, String[] res) {
        assertEquals(concatenator.multiplictionString(number[0], number[1]), res[2]);}

    /**
     * Параметризованный позитивный тест деления
     * @param number тестовые данные
     * @param res ожидаемый результат
     */
    @Test(dataProvider = "getTestAndExpectedData")
    @Story("Позитивные тесты функции деления")
    public void testDivisionStringDataProvider(String[] number, String[] res) {
        assertEquals(concatenator.divisionString(number[0], number[1]), res[3]);}

    /**
     * DataProvider с тестовыми данными для проведения негативных проверок вычисления
     * @return двумерный массив объектов
     */
    @DataProvider
    public Object[][] getTestAndExpectedDataNegative () {
        return new Object[][]{
                {new String[] {"hhh", "2"}},
                {new String[] {"3jj","10"}},
                {new String[] {"+++","10"}}
        };
    }

    /**
     * Параметризованный негативный тест сложения
     * @param number тестовые данные
     */
    @Test(dataProvider = "getTestAndExpectedDataNegative", expectedExceptions = NumberFormatException.class)
    @Story("Негативные тесты функции сложения")
    public void testPlusStringDataProviderNegative(String[] number) {
        concatenator.plusString(number[0], number[1]);}

    /**
     * Параметризованный негативный тест вычитания
     * @param number тестовые данные
     */
    @Test(dataProvider = "getTestAndExpectedDataNegative", expectedExceptions = NumberFormatException.class)
    @Story("Негативные тесты функции вычитания")
    public void testMinusStringDataProviderNegative(String[] number) {
        concatenator.minusString(number[0], number[1]);}

    /**
     * Параметризованный негативный тест умножения
     * @param number тестовые данные
     */
    @Test(dataProvider = "getTestAndExpectedDataNegative", expectedExceptions = NumberFormatException.class)
    @Story("Негативные тесты функции умножения")
    public void testMultiStringDataProviderNegative(String[] number) {
        concatenator.multiplictionString(number[0], number[1]);}

    /**
     * Параметризованный негативный тест деления
     * @param number тестовые данные
     */
    @Test(dataProvider = "getTestAndExpectedDataNegative", expectedExceptions = NumberFormatException.class)
    @Story("Негативные тесты функции деления")
    public void testDivisionStringDataProviderNegative(String[] number) {
        concatenator.divisionString(number[0], number[1]);}

}

package selenium;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import selenium.BaseTest;
import selenium.pages.HomePage;


/**
 * Класс, в котором проводятся тесты сайта Авито
 */
@Epic("Тест сайта Авито")
public class TestAvito extends BaseTest {

    /**
     * Тест, выводящий при поиске товара 5 первых значений цены
     */
    @Test
    @Story("Тест вывода значений цены первых пяти товаров")
    public void testAvitoSearchPage() throws InterruptedException {

        //Создание экземпляра класса страницы HomePage
        HomePage avitoPage = new HomePage(driver);
        Actions actions = new Actions(driver);

        // Выбор категорию “Оргтехника и расходники”
        avitoPage.clickOptions(avitoPage.allCategory);
        actions.moveToElement(avitoPage.electronicCategory).perform();
        avitoPage.clickOptions(avitoPage.categoryOfficeEquipment);

        //В поле поиска написать “Принтер”
        avitoPage.inputText(avitoPage.searchField, "Принтер\n");

        // Активировать чекбокс “только с фото”
        avitoPage.clickOptions(avitoPage.photoCheckbox);

        // Кликнуть по выпадающему списку регионов
        avitoPage.clickOptions(avitoPage.selectRegion);

        //	Ввести регион “Владивосток”
        avitoPage.clickOptions(avitoPage.inputRegion);
        // avitoPage.inputText(avitoPage.inputRegion, "Владивосток");
        Thread.sleep(3000);
        // Выбрать первый предложенный сайтом вариант выбора региона
        avitoPage.clickOptions(avitoPage.proposedRegion);

        //	Нажать на кнопку “Показать n объявлений”
        avitoPage.clickOptions(avitoPage.showAds);

        //	В выпадающем списке сортировки выбрать “Дороже”
        // avitoPage.clickOptions(avitoPage.expensively);

        //	Вывести в консоль значение цены первых 5 товаров
        avitoPage.getPriceList(5);
    }
}

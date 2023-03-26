package selenium.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.utils.Screen;
import selenium.utils.Waiters;

/**
 * Класс взаимодействия со страницей
 */
public class HomePage {

    /**
     * Создание экземпляра класса вебдрайвер
     */
    private final WebDriver driver;

    /**
     * Конструктор класса HomePage
     * @param driver экземпляр драйвера
     */
    public HomePage(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Элемент DOM дерева, отвечающий за вывод всех категорий
    @FindBy(xpath = "//div/button[@data-marker=\"top-rubricator/all-categories\"]")
    public WebElement allCategory;

    //Элемент DOM дерева, отвечающий за категорию "Электроника"
    @FindBy(xpath = "//div[@data-marker='top-rubricator/root-category-26195']")
    public WebElement electronicCategory;

    //Элемент DOM дерева, отвечающий за вывод категории Оргтехника
    @FindBy(xpath = "//div/a/strong[@data-name='Оргтехника и расходники']")
    public WebElement categoryOfficeEquipment;

    //Элемент DOM дерева, отвечающий за поиск объявлений по слову
    @FindBy(xpath = "//div//input[@data-marker=\"search-form/suggest\"]")
    public WebElement searchField;

    //Элемент DOM дерева, отвечающий за функцию: чекбокс "Только с фото"
    @FindBy(xpath = "//div//span[@class=\"checkbox-label-OmC9T text-text-LurtD text-size-s-BxGpL text-color-default-_QyDA\"]")
    public WebElement photoCheckbox;

    //Элемент DOM дерева, отвечающий за поле выбора региона поиска
    @FindBy(xpath = "//div[@data-marker=\"search-form/change-location\"]")
    public WebElement selectRegion;

    //Элемент DOM дерева, отвечающий за строку ввода региона поиска
    @FindBy(xpath = "//div[@data-marker=\"popup-location/region\"]")
    public WebElement inputRegion;

    //Элемент DOM дерева, отвечающий за первый предложенный сайтом вариант региона поиска
    @FindBy(xpath = "//div/ul/li[@data-marker=\"suggest(0)\"]")
    public WebElement proposedRegion;

    //Элемент DOM дерева, отвечающий за кнопку "Показать объявления", находящуюся в поле выбора региона
    @FindBy(xpath = "//div/button/span[@class=\"button-textBox-_SF60\"")
    public WebElement showAds;

    //Элемент DOM дерева, отвечающий за функцию списка сортировки по параметру "Дороже"
    @FindBy(xpath = "//*[@id=\"app\"]/div/div[3]/div[3]/div[3]/div[1]/div[2]/select/option[3]")
    public WebElement expensively;

    /**
     * Метод клика по функции сайта
     * @param element искомый элемет в DOM
     * @return страницу
     */
    @Step("Клик по функции")
    public HomePage clickOptions(WebElement element) {
        Waiters.waitUntilVisible(driver, element);
        element.click();
        Screen.makeScreenshot(driver);
        return this;
    }

    /**
     * Метод ввода текста в соответствующее поле сайта
     * @param element строка ввода
     * @param text текст ввода
     * @return страницу
     */
    @Step("Ввод текста")
    public HomePage inputText(WebElement element, String text) {
        Waiters.waitUntilVisible(driver, element);
        element.sendKeys(text);
        Screen.makeScreenshot(driver);
        return this;
    }

    /**
     * Метод, получающий аргумент "цена" у искомого  конкретного товара
     * @param number номер товара по порядку
     * @return аргумент "цена" искомого товара
     */
    private WebElement getPriceArgument(int number) {
        return driver.findElement(By.xpath("//div[@class='items-items-kAJAg']/div["+ number +"]/div//meta[@itemprop='price']"));
    }

    /**
     * Метод, выводящий в консоль значение цены заданного количества товаров
     * @param count количество товаров
     */
    @Step("Получение списка цен на товары")
    public void getPriceList(int count) {
        for(int i = 1; i <= count; i++) {
            System.out.println(getPriceArgument(i).getAttribute("content"));
        }
    }
}
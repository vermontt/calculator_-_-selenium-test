package selenium;

import selenium.config.BaseConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * Общий класс с настройками для всех тестов
 */
public class BaseTest {

    /**
     * Переменная с экземпляром драйвера
     */
    protected WebDriver driver;

    /**
     * Экземпляр конфигурации с общими параметрами
     */
    private final BaseConfig config = ConfigFactory.create(BaseConfig.class, System.getenv());

    /**
     * Общие настройки для всех тестов, перед выполнением каждого
     */
    @BeforeMethod
    public void setUp() {

        //Установка свойств вебдрайвера, пути к нему
        System.setProperty(config.driverProperty(), config.driverPath());

        ChromeOptions chromeOptions = new ChromeOptions();

        chromeOptions.addArguments("--remote-allow-origins=*","ignore-certificate-errors");

        driver = new ChromeDriver(chromeOptions);


        //Создание экземпляра драйвера
    //    driver = new ChromeDriver();

        //Открытие стартовой страницы, с которой будут стартовать тесты
        driver.get(config.url());

        //Открытие браузеры в расширенном окне
        driver.manage().window().maximize();

  //    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2)); - строка для неявного ожидания!
    }

    /**
     * Общие методы для всех тестов, после выполнения каждого
     */
    @AfterMethod
        public void tearDown () {
            driver.close();
    }

}

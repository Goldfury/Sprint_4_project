import org.junit.Assert;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@RunWith(Parameterized.class)
public class Praktikum {

    private WebDriver driver;

    private final String name;
    private final String surname;
    private final String address;
    private final String phoneNumber;
    private final String date;
    private final String comment;

        public Praktikum(String name, String surname, String address, String phoneNumber, String date, String comment) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.comment = comment;
    }

    // Тестовые данные
    @Parameterized.Parameters
    public static Object[][] getCredentials() {
        return new Object[][] {
                { "Акылбек", "Акылбек", "Астана", "87055463022", "21.07.2001", "Классный самокат" },
                { "Нурсултан", "Арманов", "Алматы", "87073332211", "21.04.1995", "что то новое"},
        };
    }

    //тут проверяется код с параметризацией
    @Test
    public void praktikumTest() {
            driver = new ChromeDriver();
            driver.get("https://qa-scooter.praktikum-services.ru/");
        driver.findElement(By.xpath("//button[@class= 'Button_Button__ra12g']")).click();
        driver.findElement(By.xpath("//input[@placeholder='* Имя']")).sendKeys(name);
        driver.findElement(By.xpath("//input[@placeholder='* Фамилия']")).sendKeys(surname);
        driver.findElement(By.xpath("//input[contains(@placeholder, 'куда')]")).sendKeys(address);
        //тут должен быть выбор станции
        driver.findElement(By.xpath("//input[@placeholder = '* Станция метро']")).click();
        driver.findElement(By.cssSelector(".Order_SelectOption__82bhS.select-search__option")).click();
        driver.findElement(By.xpath("//input[contains(@placeholder, 'курьер')]")).sendKeys(phoneNumber);
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM' and text()='Далее']")));
        //вторая часть формы
        driver.findElement(By.xpath("//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM' and text()='Далее']")).click();
        driver.findElement(By.xpath("//input[contains(@placeholder, '* Когда привезти самокат')]")).sendKeys(date);
        //нужен для того чтобы найти в календаре день заказа и кликнуть так как  след поле оно блокирует
        driver.findElement(By.xpath("//div[text()='21']")).click();
        driver.findElement(By.className("Dropdown-placeholder")).click();
        driver.findElement(By.className("Dropdown-option")).click();
        driver.findElement(By.xpath("//label[@for = 'grey']")).click();
        driver.findElement(By.xpath("//input[contains(@placeholder, 'Комментарий для курьера')]")).sendKeys(comment);
        driver.findElement(By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']")).click();
        driver.findElement(By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']")).click();
    }

    //тут просто проверяется код на заказ
    @Test
    public void createOrder() {
        // создали драйвер для браузера Chrome
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
//        driver = new ChromeDriver(options);
        driver = new ChromeDriver();
        // перешли на страницу тестового приложения
        //тест работает но не дошло до страницы подтверждения заказа
        driver.get("https://qa-scooter.praktikum-services.ru/");
        SamokatOrderPage objSamokatOrderPage = new SamokatOrderPage(driver);
        objSamokatOrderPage.fillSamokatOrderForm();
        //Проверка которая должна сломаться так как в Хроме не выходит что Заказ оформлен
        String confirmText = driver.findElement(By.xpath("//div[@class = 'Order_ModalHeader__3FDaJ']")).getText();
        String expected = "Заказ оформлен";
        Assert.assertEquals("Окно подтверждения заказа не открылось", expected, confirmText);
    }

    //В данном тесте проверяется только большая кнопка на странице со сравнением с текстом, так как в header уже идет проверка в формировании заказа
    @Test
    public void checkBigOrderbutton(){
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        SamokatOrderPage objSamokatOrderPage = new SamokatOrderPage(driver);
        objSamokatOrderPage.checkBigOrderButton();
    }

    @Test
    //Проверка Выпадающего список в разделе «Вопросы о важном». в самом в методе вставлена 8 методов которые проверяют каждую кнопку
    public void checkTextInDropdown(){
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        SamokatHomePageTest objSamokatHomePageTest = new SamokatHomePageTest(driver);
        objSamokatHomePageTest.accordionTextComparison();

    }

    @After
    public void tearDown() {
        // Закрой браузер
        driver.quit();
    }
}
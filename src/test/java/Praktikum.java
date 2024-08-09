import org.junit.Assert;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.After;
import org.junit.Test;


public class Praktikum {

    private WebDriver driver;




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
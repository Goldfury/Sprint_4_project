import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//@RunWith(Parameterized.class)
public class SamokatOrderPage {

    private WebDriver driver;
    //локаторы для кнопок
    private final By headerMakeOrderButton = By.xpath("//button[@class= 'Button_Button__ra12g']");
    private final By bigMakeOrderButton = By.xpath("//div[@class='Home_FinishButton__1_cWm']/button");

    // локаторы для полей персональных данных для заказа
    private final By nameField = By.xpath("//input[@placeholder='* Имя']");
    private final By surnameField = By.xpath("//input[@placeholder='* Фамилия']");
    private final By addressField = By.xpath("//input[contains(@placeholder, 'куда')]");
        //Выпадающий список с метро
    private final By deliveryAddressField = By.xpath("//input[@placeholder = '* Станция метро']");
    private final By deliveryAddressFieldOption = By.cssSelector(".Order_SelectOption__82bhS.select-search__option");
    private final By phoneNumberField = By.xpath("//input[contains(@placeholder, 'курьер')]");

    //локаторы для второй части заказа
    private final By deliverDateField = By.xpath("//input[contains(@placeholder, '* Когда привезти самокат')]");
        //Количество дней аренды
    private final By rentDaysField = By.className("Dropdown-placeholder");
    private final By rentDaysFieldDropdownOption = By.className("Dropdown-option");
    //Локатор для выбора цвета самоката
    private final By blackSamokat = By.xpath("//label[@for = 'black']");
    private final By greySamokat = By.xpath("//label[@for = 'grey']");

    private final By commentForCourier = By.xpath("//input[contains(@placeholder, 'Комментарий для курьера')]");

    //Локатор для кнопки далее в форме заказа
    private final By nextFormButton = By.xpath("//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM' and text()='Далее']");

    //Локатор для кнопки заказа
    private final By makeOrderFormButton = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']");

    //Локатор кнопки для подтверждения заказа
    private final By confirmOrderButton = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");


    public SamokatOrderPage(WebDriver driver){
        this.driver = driver;
    }



//    public SamokatOrderPage(WebDriver driver, String name, String surname, String address, String phoneNumber, String date, String comment) {
//        this.name = name;
//        this.surname = surname;
//        this.address = address;
//        this.phoneNumber = phoneNumber;
//        this.date = date;
//        this.comment = comment;
//    }
//
//    // Тестовые данные
//    @Parameterized.Parameters
//    public static Object[][] getCredentials() {
//        return new Object[][] {
//                { "Акылбек", "Акылбек", "Астана", "87055463022", "21.07.2001", "Классный самокат" },
//                { "Нурсултан", "Арманов", "Алматы", "87073332211", "21.04.1995", "что то новое"},
//        };
//    }

    private String name = "Акылбек";
    private String surname = "Акылбек";
    private String address = "Астана";
    private String phoneNumber = "87055463022";
    private String date = "21.07.2001";
    private String comment = "Классный самокат" ;

    //заполнение формы заказа
    public void fillSamokatOrderForm(){
        driver.findElement(headerMakeOrderButton).click();
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(surnameField).sendKeys(surname);
        driver.findElement(addressField).sendKeys(address);
        //тут должен быть выбор станции
        driver.findElement(deliveryAddressField).click();
        driver.findElement(deliveryAddressFieldOption).click();
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(nextFormButton));
        //вторая часть формы
        driver.findElement(nextFormButton).click();
        driver.findElement(deliverDateField).sendKeys(date);
        //нужен для того чтобы найти в календаре день заказа и кликнуть так как  след поле оно блокирует
        driver.findElement(By.xpath("//div[text()='21']")).click();
        driver.findElement(rentDaysField).click();
        driver.findElement(rentDaysFieldDropdownOption).click();
        driver.findElement(blackSamokat).click();
        driver.findElement(commentForCourier).sendKeys(comment);
        driver.findElement(makeOrderFormButton).click();
        driver.findElement(confirmOrderButton).click();
    }

    //проверка большой кнопки в body
    public void checkBigOrderButton(){
        WebElement element = driver.findElement(bigMakeOrderButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(bigMakeOrderButton));
        driver.findElement(bigMakeOrderButton).click();
        String titleOfTheForm = driver.findElement(By.xpath("//div[@class= 'Order_Header__BZXOb']")).getText();
        String expected = "Для кого самокат";
        Assert.assertEquals("Окно не открылось", expected, titleOfTheForm);


    }
}





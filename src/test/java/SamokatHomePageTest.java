import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SamokatHomePageTest {

    private final WebDriver driver;

    //Здесь будут находится заголовки выпадающего списка
    private final By FAQItem = By.id("accordion__heading-0");
    private final By FAQItem1 = By.id("accordion__heading-1");
    private final By FAQItem2 = By.id("accordion__heading-2");
    private final By FAQItem3 = By.id("accordion__heading-3");
    private final By FAQItem4 = By.id("accordion__heading-4");
    private final By FAQItem5 = By.id("accordion__heading-5");
    private final By FAQItem6 = By.id("accordion__heading-6");
    private final By FAQItem7 = By.id("accordion__heading-7");

    //Здесь будут находится ответы выпадающего списка
    private final By FAQAnswerText = By.id("accordion__panel-0");
    private final By FAQAnswerText1 = By.id("accordion__panel-1");
    private final By FAQAnswerText2 = By.id("accordion__panel-2");
    private final By FAQAnswerText3 = By.id("accordion__panel-3");
    private final By FAQAnswerText4 = By.id("accordion__panel-4");
    private final By FAQAnswerText5 = By.id("accordion__panel-5");
    private final By FAQAnswerText6 = By.id("accordion__panel-6");
    private final By FAQAnswerText7 = By.id("accordion__panel-7");

    //Тексты в выпадающем списке

    private String text = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    private String text1 = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    private String text2 = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    private String text3 = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    private String text4 = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    private String text5 = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    private String text6 = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    private String text7 = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";

    private final By headerMakeOrderButton = By.xpath("//button[@class= 'Button_Button__ra12g']");
    private final By bigMakeOrderButton = By.xpath("//div[@class='Home_FinishButton__1_cWm']/button");

    public void clickHeaderMakeOrderButton() {
        driver.findElement(headerMakeOrderButton).click();
    }

    public SamokatHomePageTest(WebDriver driver) {
        this.driver = driver;
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

    public void compareFirstPanel() {
        WebElement element = driver.findElement(FAQItem);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(FAQItem).click();
        String f = driver.findElement(FAQAnswerText).getText();
        Assert.assertEquals("Текст 1 не сходится", text, f);
    }

    public void compareSecondPanel() {
        WebElement element = driver.findElement(FAQItem1);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(FAQItem1).click();
        String f1 = driver.findElement(FAQAnswerText1).getText();
        Assert.assertEquals("Текст 2 не сходится", text1, f1);
    }

    public void compareThirdPanel() {
        WebElement element = driver.findElement(FAQItem2);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(FAQItem2).click();
        String f2 = driver.findElement(FAQAnswerText2).getText();
        Assert.assertEquals("Текст 3 не сходится", text2, f2);
    }

    public void compareFourthPanel() {
        WebElement element = driver.findElement(FAQItem3);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(FAQItem3).click();
        String f3 = driver.findElement(FAQAnswerText3).getText();
        Assert.assertEquals("Текст 4 не сходится", text3, f3);
    }

    public void compareFifthPanel() {
        WebElement element = driver.findElement(FAQItem4);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(FAQItem4).click();
        String f4 = driver.findElement(FAQAnswerText4).getText();
        Assert.assertEquals("Текст 5 не сходится", text4, f4);
    }

    public void compareSixthPanel() {
        WebElement element = driver.findElement(FAQItem5);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(FAQItem5).click();
        String f5 = driver.findElement(FAQAnswerText5).getText();
        Assert.assertEquals("Текст 6 не сходится", text5, f5);
    }

    public void compareSeventhPanel() {
        WebElement element = driver.findElement(FAQItem6);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(FAQItem6).click();
        String f6 = driver.findElement(FAQAnswerText6).getText();
        Assert.assertEquals("Текст 7 не сходится", text6, f6);
    }

    public void compareEighthPanel() {
        WebElement element = driver.findElement(FAQItem7);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(FAQItem7).click();
        String f7 = driver.findElement(FAQAnswerText7).getText();
        Assert.assertEquals("Текст 8 не сходится", text7, f7);
    }


}
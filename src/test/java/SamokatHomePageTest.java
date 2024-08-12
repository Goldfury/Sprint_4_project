import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class SamokatHomePageTest {

    private WebDriver driver;

    //Здесь будут находится заголовки выпадающего списка
    private By getAccordionItem = By.id("accordion__heading-0");
    private By getAccordionItem1 = By.id("accordion__heading-1");
    private By getAccordionItem2 = By.id("accordion__heading-2");
    private By getAccordionItem3 = By.id("accordion__heading-3");
    private By getAccordionItem4 = By.id("accordion__heading-4");
    private By getAccordionItem5 = By.id("accordion__heading-5");
    private By getAccordionItem6 = By.id("accordion__heading-6");
    private By getAccordionItem7 = By.id("accordion__heading-7");

    //Здесь будут находится ответы выпадающего списка
    private By getAccordionItemPanel = By.id("accordion__panel-0");
    private By getAccordionItemPanel1 = By.id("accordion__panel-1");
    private By getAccordionItemPanel2 = By.id("accordion__panel-2");
    private By getAccordionItemPanel3 = By.id("accordion__panel-3");
    private By getAccordionItemPanel4 = By.id("accordion__panel-4");
    private By getAccordionItemPanel5 = By.id("accordion__panel-5");
    private By getAccordionItemPanel6 = By.id("accordion__panel-6");
    private By getAccordionItemPanel7 = By.id("accordion__panel-7");

    //Тексты в выпадающем списке

    private String text = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    private String text1 = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    private String text2 = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    private String text3 = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    private String text4 = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    private String text5 = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    private String text6 = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    private String text7 = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";

    public SamokatHomePageTest(WebDriver driver) {
        this.driver = driver;
    }

    //проверяет каждый текст
    public void accordionTextComparison() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        compareFirstPanel();
        compareSecondPanel();
        compareThirdPanel();
        compareFourthPanel();
        compareFifthPanel();
        compareSixthPanel();
        compareSeventhPanel();
        compareEighthPanel();
    }

    private void compareFirstPanel() {
        WebElement element = driver.findElement(getAccordionItem);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(getAccordionItem).click();
        String f = driver.findElement(getAccordionItemPanel).getText();
        Assert.assertEquals("Текст 1 не сходится", text, f);
    }

    private void compareSecondPanel() {
        WebElement element = driver.findElement(getAccordionItem1);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(getAccordionItem1).click();
        String f1 = driver.findElement(getAccordionItemPanel1).getText();
        Assert.assertEquals("Текст 2 не сходится", text1, f1);
    }

    private void compareThirdPanel() {
        WebElement element = driver.findElement(getAccordionItem2);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(getAccordionItem2).click();
        String f2 = driver.findElement(getAccordionItemPanel2).getText();
        Assert.assertEquals("Текст 3 не сходится", text2, f2);
    }

    private void compareFourthPanel() {
        WebElement element = driver.findElement(getAccordionItem3);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(getAccordionItem3).click();
        String f3 = driver.findElement(getAccordionItemPanel3).getText();
        Assert.assertEquals("Текст 4 не сходится", text3, f3);
    }

    private void compareFifthPanel() {
        WebElement element = driver.findElement(getAccordionItem4);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(getAccordionItem4).click();
        String f4 = driver.findElement(getAccordionItemPanel4).getText();
        Assert.assertEquals("Текст 5 не сходится", text4, f4);
    }

    private void compareSixthPanel() {
        WebElement element = driver.findElement(getAccordionItem5);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(getAccordionItem5).click();
        String f5 = driver.findElement(getAccordionItemPanel5).getText();
        Assert.assertEquals("Текст 6 не сходится", text5, f5);
    }

    private void compareSeventhPanel() {
        WebElement element = driver.findElement(getAccordionItem6);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(getAccordionItem6).click();
        String f6 = driver.findElement(getAccordionItemPanel6).getText();
        Assert.assertEquals("Текст 7 не сходится", text6, f6);
    }

    private void compareEighthPanel() {
        WebElement element = driver.findElement(getAccordionItem7);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(getAccordionItem7).click();
        String f7 = driver.findElement(getAccordionItemPanel7).getText();
        Assert.assertEquals("Текст 8 не сходится", text7, f7);
    }


}
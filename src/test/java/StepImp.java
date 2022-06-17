import com.thoughtworks.gauge.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;


public class StepImp extends BaseTest {
    Methods methods = new Methods();

    public static List<WebElement> getElements(String key) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(key)));
        List<WebElement> l1 = BaseTest.driver.findElements(By.xpath(key));
        return l1;
    }

    public void randomElementClicker(List<WebElement> list) {
        Random rand = new Random();
        list.get(rand.nextInt(list.size())).click();
    }

    @Step("<second> saniye kadar bekle")
    public void waitForsecond(int second) throws InterruptedException {
        methods.waitBySeconds(second);

    }

    @Step("<xpath> Xpath verilen elementi bul ve tıkla")
    public void clickByxpath(String xpath) throws InterruptedException {
        //methods.click(By.xpath(xpath));
        if (!methods.isElementVisible(By.xpath(xpath))) {
            waitForsecond(5);
        }
        methods.click(By.xpath(xpath));
    }

    @Step("<id> 'li elemente <text> Degeri girilir")
    public void sendKeysByid(String key, String text) throws InterruptedException {
        if (!methods.isElementVisible(By.id(key))) {
            waitForsecond(2);
        }
        methods.sendKeys(By.id(key), text);
    }

    @Step("<id> id verilen elementi bul ve tıkla")
    public void clickByid(String id) {
        By by = By.id(id);
        methods.isElementVisible(by);
        methods.click(by);
    }

    @Step("<key> Rastgele elemente tiklar")
    public void randomTikla(String key) throws InterruptedException {
        randomElementClicker(getElements(key));
    }

    @Step("<xpath> Xpath verilen elementi bul ve <text> değerini yaz")
    public void sendKeysbyXpath(String xpath, String text) throws InterruptedException {
        methods.findElement(By.xpath(xpath)).sendKeys(text, Keys.ENTER);
    }
    @Step("<key> xpath ile element görünür değil ise <key> saniye kadar beklenir.")
    public void waitForElement(String xpath , int seconds) {
        if(!methods.isElementVisible(By.xpath(xpath)))
        {
            methods.waitBySeconds(5);
        }
    }

}

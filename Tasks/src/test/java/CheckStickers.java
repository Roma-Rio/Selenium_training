import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckStickers {
    private WebDriver driver;

    @Before
    public void start() {
        driver = new ChromeDriver();
    }

    @Test
    public void checkStickers() {
        driver.navigate().to("http://localhost/litecart/en/");
        driver.manage().window().maximize();
        List<WebElement> stickers = driver.findElements(By.cssSelector("li.product.column"));

        for (WebElement stick : stickers) {
            System.out.println("=====================");
                System.out.println("Item: " + stick.findElement(By.cssSelector(".name")).getText());
                System.out.println("Sticker text: " + stick.findElement(By.cssSelector(".sticker")).getText());
                System.out.println("Number of stickers: " + stick.findElements(By.cssSelector(".sticker")).size());
                System.out.println("isClass sticker: " +stick.findElement(By.cssSelector(".sticker")).toString().contains("sticker"));
        }
    }

    @After
    public void stop() {
        driver.close();
        driver = null;
    }
}


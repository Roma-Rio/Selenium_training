import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class OuterLinks {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void OpenOuterLinks(){
        driver.navigate().to("http://localhost/litecart/admin");
        driver.manage().window().maximize();
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();

        driver.navigate().to("http://localhost/litecart/admin/?app=countries&doc=countries");
        driver.findElement(By.cssSelector("[href$='code=CA']")).click();

        List<WebElement> links = driver.findElements(By.cssSelector("[class='fa fa-external-link']"));
        Set<String> existWindows;
        String curWindow;
        String newWindow;
        for (WebElement linx : links) {
            curWindow = driver.getWindowHandle();
            existWindows = driver.getWindowHandles();
            linx.click();
            newWindow = wait.until(anyWindowOtherThan(existWindows));
            driver.switchTo().window(newWindow);
            wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
            driver.close();
            driver.switchTo().window(curWindow);
            wait.until(titleIs("Edit Country | My Store"));
        }
    }

    private ExpectedCondition<String> anyWindowOtherThan(Set<String> existWindows) {
        return input -> {
            Set<String> handles = driver.getWindowHandles();
            handles.removeAll(existWindows);
            return handles.size() > 0 ? handles.iterator().next() : null;
        };
    }

    @After
    public void stop() {
        //driver.quit();
        driver = null;
    }
}
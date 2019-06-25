import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class Testclass {
    private WebDriver driver;
    private WebDriverWait wait;
    private String login = "testbox09876";
    private String pass = "062019Te";
    private String url = "https://mail.ru/";

    @Before
    public void start() {
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 5);
    }

    @Test
    public void login() {
        driver.navigate().to(url);
        driver.manage().window().maximize();
        //Log in into email
        driver.findElement(By.id("mailbox:login")).sendKeys(login);
        driver.findElement(By.id("mailbox:domain")).click();
        driver.findElement(By.id("mailbox:password")).sendKeys(pass);
        driver.findElement(By.name("saveauth")).click();
        driver.findElement(By.id("mailbox:submit")).click();
        wait.until(titleIs("Входящие - Почта Mail.ru"));
        //Sending a letter to yourself
        driver.findElement(By.className("compose-button__txt")).click();
        driver.findElement(By.xpath("//*[contains(@class,'container--zU301')]")).sendKeys(login + "@mail.ru");
        Actions act = new Actions(driver);
        act.sendKeys(Keys.SPACE).perform();
        act.sendKeys(Keys.TAB).perform();
        act.sendKeys("Test letter").perform();
        driver.findElement(By.cssSelector(".cke_show_borders")).
                sendKeys("The " + login + " is email sender.\n" +
                        "This is test task by Gilyazev Ramil. \n" +
                        "Let's write scripts to all the manual cases and project will be better.\n");
        driver.findElement(By.xpath("//*[.='Отправить']")).click();
        driver.findElement(By.cssSelector(".layer-sent-page"));
        act.sendKeys(Keys.ESCAPE).perform();
        //Email search in incoming
        driver.findElement(By.cssSelector(".search-panel-button__text")).click();
        driver.findElement(By.xpath("//*[contains(@class,'_1BEp2b6vqOez8I6Rw9SpK6')]")).sendKeys(login, Keys.ENTER);
        driver.findElement(By.cssSelector("[title=\"Входящие\"]")).click();
        //Email opening
        driver.findElement(By.xpath("//*[contains(@class,'_1BEp2b6vqOez8I6Rw9SpK6')]"));
        driver.findElement(By.xpath("//*[.='Ответить']")).click();
        //Answer to the letter  without sending
        driver.findElement(By.xpath("//*[contains(@tabindex,'505')]")).
                sendKeys("This is answer to the email received from " + login + ". \n" +
                        "In the near future, such tasks will be done faster and better. \n" +
                        "I would appreciate your comments.\n");
    }

    @After
    public void stop() {
        driver.close();
        driver = null;
    }
}
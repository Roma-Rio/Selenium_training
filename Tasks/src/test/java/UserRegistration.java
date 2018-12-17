import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.interactions.Actions;

public class UserRegistration {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void doRegister() {
        driver.navigate().to("http://localhost/litecart/en/");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("[href$='create_account']")).click();

        int random = (int) (Math.random() * 10);

        //Заполнение данных
        WebElement fn = driver.findElement(By.name("firstname"));
        fn.sendKeys("Bob");
        WebElement ln = driver.findElement(By.name("lastname"));
        ln.sendKeys("Dilan");
        WebElement addr = driver.findElement(By.name("address1"));
        addr.sendKeys("USA,Alabama");
        WebElement pc = driver.findElement(By.name("postcode"));
        String post = "3631" + random;
        pc.sendKeys(post);
        WebElement city = driver.findElement(By.name("city"));
        city.sendKeys("Houston");

        WebElement country = driver.findElement(By.cssSelector(".select2-selection__arrow"));
        country.click();
        WebElement countryone = driver.findElement(By.cssSelector(".select2-search__field"));
        countryone.sendKeys("United States");
        Actions act = new Actions(driver);
        act.sendKeys(Keys.ENTER).perform();

        String mail = "1" + random + "6" + random + "@gmail.com";
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys(mail);

        WebElement phone_el = driver.findElement(By.name("phone"));
        String phone = "+156434" + random;
        phone_el.sendKeys(phone);


        WebElement despass = driver.findElement(By.cssSelector("[name='password']"));
        String pas = "123";
        despass.sendKeys(pas);
        WebElement confpass = driver.findElement(By.cssSelector("[name='confirmed_password']"));
        confpass.sendKeys(pas);
        driver.findElement(By.name("create_account")).click();

        //Logout from registration page
        driver.findElement(By.cssSelector("[href$=logout]")).click();


        //Login into customer page
        driver.navigate().to("http://localhost/litecart/en/");
        driver.findElement(By.name("email")).sendKeys(mail);
        driver.findElement(By.name("password")).sendKeys(pas);
        driver.findElement(By.name("login")).click();

        //Logout from customer page
        driver.findElement(By.cssSelector("[href$=logout]")).click();

    }

    @After
    public void stop() {
        //driver.quit();
        //driver.close();
        driver = null;
    }

}

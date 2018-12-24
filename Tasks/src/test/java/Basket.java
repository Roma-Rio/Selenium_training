import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Basket {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void startDriver() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void addRemove() {
        driver.navigate().to("http://localhost/litecart/en/");
        driver.manage().window().maximize();

        driver.findElement(By.cssSelector("#box-most-popular li:nth-child(1)> a.link ")).click();
        driver.findElement(By.cssSelector("#box-product button")).click();

        //add first product
        wait.until(d -> d.findElement(By
                .cssSelector("#cart > a.content > span.quantity"))
                .getAttribute("innerText")
                .contains("1"));
        driver.findElement(By.cssSelector("[title='Home']")).click();

        //add second product
        driver.findElement(By.cssSelector("#box-most-popular li:nth-child(1)> a.link ")).click();
        driver.findElement(By.cssSelector("#box-product button")).click();
        wait.until(d -> d.findElement(By
                .cssSelector("#cart > a.content > span.quantity"))
                .getAttribute("innerText")
                .contains("2"));
        driver.findElement(By.cssSelector("[title='Home']")).click();

        //add third product
        driver.findElement(By.cssSelector("#box-most-popular li:nth-child(1)> a.link ")).click();
        driver.findElement(By.cssSelector("#box-product button")).click();
        wait.until(d -> d.findElement(By
                .cssSelector("#cart > a.content > span.quantity"))
                .getAttribute("innerText")
                .contains("3"));
        driver.findElement(By.cssSelector("[title='Home']")).click();


        //Navigate to basket
        driver.findElement(By.cssSelector("#cart a.link")).click();
        WebElement order_table = driver.findElement(By.cssSelector(".dataTable"));
        driver.findElement(By.cssSelector("[name='remove_cart_item']")).click();
        wait.until(ExpectedConditions.stalenessOf(order_table));

        driver.findElement(By.cssSelector("[name='remove_cart_item']")).click();
        wait.until(ExpectedConditions.stalenessOf(order_table));

        driver.findElement(By.cssSelector("[name='remove_cart_item']")).click();
        wait.until(ExpectedConditions.stalenessOf(order_table));


    }

    @After
    public void stopDriver() {
        //driver.close();
        driver = null;
    }
}



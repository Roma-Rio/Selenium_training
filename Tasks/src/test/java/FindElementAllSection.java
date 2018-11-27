import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class FindElementAllSection {
    private WebDriver chromedriver;


    @Before
    public void start() {
        chromedriver = new ChromeDriver();
    }

    @Test
    public void clickAll() {
        chromedriver.navigate().to("http://localhost/litecart/admin");
        chromedriver.manage().window().maximize();
        chromedriver.findElement(By.name("username")).sendKeys("admin");
        chromedriver.findElement(By.name("password")).sendKeys("admin");
        chromedriver.findElement(By.name("login")).click();

        chromedriver.findElement(By.linkText("Appearence")).click();
        chromedriver.findElement(By.tagName("h1"));
        chromedriver.findElement(By.linkText("Logotype")).click();
        chromedriver.findElement(By.tagName("h1"));

        chromedriver.findElement(By.linkText("Catalog")).click();
        chromedriver.findElement(By.tagName("h1"));
        chromedriver.findElement(By.linkText("Product Groups")).click();
        chromedriver.findElement(By.tagName("h1"));
        chromedriver.findElement(By.linkText("Option Groups")).click();
        chromedriver.findElement(By.tagName("h1"));
        chromedriver.findElement(By.linkText("Manufacturers")).click();
        chromedriver.findElement(By.tagName("h1"));
        chromedriver.findElement(By.linkText("Suppliers")).click();
        chromedriver.findElement(By.tagName("h1"));
        chromedriver.findElement(By.linkText("Delivery Statuses")).click();
        chromedriver.findElement(By.tagName("h1"));
        chromedriver.findElement(By.linkText("Sold Out Statuses")).click();
        chromedriver.findElement(By.tagName("h1"));
        chromedriver.findElement(By.linkText("Quantity Units")).click();
        chromedriver.findElement(By.tagName("h1"));
        chromedriver.findElement(By.linkText("CSV Import/Export")).click();
        chromedriver.findElement(By.tagName("h1"));

        chromedriver.findElement(By.linkText("Countries")).click();
        chromedriver.findElement(By.tagName("h1"));

        chromedriver.findElement(By.linkText("Currencies")).click();
        chromedriver.findElement(By.tagName("h1"));

        chromedriver.findElement(By.linkText("Customers")).click();
        chromedriver.findElement(By.tagName("h1"));
        chromedriver.findElement(By.linkText("CSV Import/Export")).click();
        chromedriver.findElement(By.tagName("h1"));
        chromedriver.findElement(By.linkText("Newsletter")).click();
        chromedriver.findElement(By.tagName("h1"));

        chromedriver.findElement(By.linkText("Geo Zones")).click();
        chromedriver.findElement(By.tagName("h1"));

        chromedriver.findElement(By.linkText("Languages")).click();
        chromedriver.findElement(By.tagName("h1"));
        chromedriver.findElement(By.linkText("Storage Encoding")).click();
        chromedriver.findElement(By.tagName("h1"));

        chromedriver.findElement(By.linkText("Modules")).click();
        chromedriver.findElement(By.tagName("h1"));
        chromedriver.findElement(By.linkText("Customer")).click();
        chromedriver.findElement(By.tagName("h1"));
        chromedriver.findElement(By.linkText("Shipping")).click();
        chromedriver.findElement(By.tagName("h1"));
        chromedriver.findElement(By.linkText("Payment")).click();
        chromedriver.findElement(By.tagName("h1"));
        chromedriver.findElement(By.linkText("Order Total")).click();
        chromedriver.findElement(By.tagName("h1"));

        chromedriver.findElement(By.linkText("Order Success")).click();
        chromedriver.findElement(By.tagName("h1"));
        chromedriver.findElement(By.linkText("Order Action")).click();
        chromedriver.findElement(By.tagName("h1"));

        chromedriver.findElement(By.linkText("Orders")).click();
        chromedriver.findElement(By.tagName("h1"));
        chromedriver.findElement(By.linkText("Order Statuses")).click();
        chromedriver.findElement(By.tagName("h1"));

        chromedriver.findElement(By.linkText("Pages")).click();
        chromedriver.findElement(By.tagName("h1"));

        chromedriver.findElement(By.linkText("Reports")).click();
        chromedriver.findElement(By.tagName("h1"));
        chromedriver.findElement(By.linkText("Most Sold Products")).click();
        chromedriver.findElement(By.tagName("h1"));
        chromedriver.findElement(By.linkText("Most Shopping Customers")).click();
        chromedriver.findElement(By.tagName("h1"));

        chromedriver.findElement(By.linkText("Settings")).click();
        chromedriver.findElement(By.tagName("h1"));
        chromedriver.findElement(By.linkText("Defaults")).click();
        chromedriver.findElement(By.tagName("h1"));
        chromedriver.findElement(By.linkText("General")).click();
        chromedriver.findElement(By.tagName("h1"));
        chromedriver.findElement(By.linkText("Listings")).click();
        chromedriver.findElement(By.tagName("h1"));
        chromedriver.findElement(By.linkText("Images")).click();
        chromedriver.findElement(By.tagName("h1"));
        chromedriver.findElement(By.linkText("Checkout")).click();
        chromedriver.findElement(By.tagName("h1"));
        chromedriver.findElement(By.linkText("Advanced")).click();
        chromedriver.findElement(By.tagName("h1"));
        chromedriver.findElement(By.linkText("Security")).click();
        chromedriver.findElement(By.tagName("h1"));

        chromedriver.findElement(By.linkText("Slides")).click();
        chromedriver.findElement(By.tagName("h1"));

        chromedriver.findElement(By.linkText("Tax")).click();
        chromedriver.findElement(By.tagName("h1"));
        chromedriver.findElement(By.linkText("Tax Rates")).click();
        chromedriver.findElement(By.tagName("h1"));

        chromedriver.findElement(By.linkText("Translations")).click();
        chromedriver.findElement(By.tagName("h1"));
        chromedriver.findElement(By.linkText("Scan Files")).click();
        chromedriver.findElement(By.tagName("h1"));
        chromedriver.findElement(By.linkText("CSV Import/Export")).click();
        chromedriver.findElement(By.tagName("h1"));

        chromedriver.findElement(By.linkText("Users")).click();
        chromedriver.findElement(By.tagName("h1"));

        chromedriver.findElement(By.linkText("vQmods")).click();
        chromedriver.findElement(By.tagName("h1"));
    }

    @After
    public void stop() {
        chromedriver.close();
        chromedriver = null;
    }
}

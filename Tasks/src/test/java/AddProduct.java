import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class AddProduct {
    private WebDriver driver;
    private WebDriverWait wait;


    @Before
    public void start() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void addProduct() {
        driver.navigate().to("http://localhost/litecart/admin");
        driver.manage().window().maximize();
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();


        driver.findElement(By.cssSelector("[href$='catalog']")).click();
        driver.findElement(By.linkText("Rubber Ducks")).click();
        int prod_before = driver.findElements(By.cssSelector(".row [name^='products']")).size();
        System.out.println("Product items before adding: " + prod_before);
        driver.findElement(By.cssSelector("[href$='catalog']")).click();
        driver.findElement(By.cssSelector("[href$='edit_product']")).click();

        //Select General tab
        driver.findElement(By.cssSelector("[href$='general']")).click();

        //Set enabled
        driver.findElement(By.cssSelector("[value='1']")).click();

        String newduck = "New Duck";
        driver.findElement(By.cssSelector("[name='name[en]']")).sendKeys(newduck);

        driver.findElement(By.cssSelector("[name='code']")).sendKeys("nd099");
        driver.findElement(By.cssSelector("[data-name='Root']")).click();
        driver.findElement(By.cssSelector("[data-name='Rubber Ducks']")).click();

        //set quantities
        WebElement quant = driver.findElement(By.cssSelector("[name='quantity']"));
        quant.clear();
        quant.sendKeys("20");
        WebElement soid = driver.findElement(By.cssSelector("[name='sold_out_status_id']"));
        soid.click();
        Actions soidact = new Actions(driver);
        soidact.sendKeys(Keys.DOWN).perform();
        soidact.sendKeys(Keys.ENTER).perform();

        //download image
        File f1 = new File("src\\test\\java\\brown_duck.png");
        String path = f1.getAbsolutePath();
        //System.out.println(path);
        driver.findElement(By.cssSelector("[name='new_images[]']")).sendKeys(path);

        //set from date
        WebElement fromdate = driver.findElement(By.cssSelector("[name='date_valid_from']"));
        fromdate.sendKeys("01");
        fromdate.sendKeys("12");
        fromdate.sendKeys("2018");

        //set to date
        WebElement setdate = driver.findElement(By.cssSelector("[name='date_valid_to']"));
        setdate.sendKeys("01");
        setdate.sendKeys("12");
        setdate.sendKeys("2019");
        //************************************************************//

        //Fill the Information
        WebElement info = driver.findElement(By.cssSelector("[href$='information']"));
        info.click();
        wait.until(visibilityOf(info));

        WebElement mfc = driver.findElement(By.cssSelector("[name='manufacturer_id']"));
        mfc.click();
        //Actions mfcact = new Actions(driver);
        soidact.sendKeys(Keys.DOWN).perform();
        soidact.sendKeys(Keys.ENTER).perform();

        driver.findElement(By.cssSelector("[name='short_description[en]']")).sendKeys(newduck + " in the Catalog");
        WebElement descr = driver.findElement(By.cssSelector("[class='trumbowyg-editor']"));
        descr.click();
        descr.sendKeys("The " + newduck + " is new item of Catalog.\n" +
                "Picture of new item must be downloaded from relative path converted from absolute.\n" +
                "Switching between tabs is not instantaneous, so after switching you can make a short pause.\n" +
                "A picture with the image of the goods must be placed in the repository along with the code.");
        //************************************************************//

        //Fill the Prices
        WebElement prices = driver.findElement(By.cssSelector("[href$='prices']"));
        prices.click();
        //wait.until(visibilityOf(price));
        WebElement price = driver.findElement(By.cssSelector("[name='purchase_price']"));
        price.clear();
        price.sendKeys("12");
        driver.findElement(By.cssSelector("[name='prices[USD]']")).sendKeys("24");

        //Save new product
        driver.findElement(By.cssSelector("[name='save']")).click();

        //Check new product
        int prod_after = driver.findElements(By.cssSelector("[name^='products']")).size();
        System.out.println("Product items after adding:  " + prod_after);
        if(prod_before < prod_after){
        System.out.println("New product successfully added");
        }else{
        System.out.println("Some error during process");
        }
}

    @After
    public void stop() {
        //driver.close();
        driver = null;
    }
}

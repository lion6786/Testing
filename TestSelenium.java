import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class TestSelenium {

    static FirefoxDriver driver = new FirefoxDriver();

    public static void sleep(int t) throws InterruptedException {
        Thread.sleep(t);
    }

    public static void quitChrome() {
        driver.quit();
    }
    public static void addDeleteElement() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com");
        driver.manage().window().maximize();
        driver.findElement(By.linkText("Add/Remove Elements")).click();
        sleep(1000);
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        sleep(2000);
        driver.findElement(By.xpath("//button[text()='Delete']")).click();
        sleep(2000);
    }

    public static void enterTextAndSearch() throws InterruptedException {
        driver.get("https://demo.opencart.com");
        driver.findElement(By.name("search")).sendKeys("Phones");
        sleep(1000);
        driver.findElement(By.cssSelector("div#search>button")).click();
        sleep(2000);
    }

    public static void checkboxAndRadio() throws InterruptedException {
        driver.get("https://leafground.com/checkbox.xhtml;jsessionid=node02t28ccmt6nmz14co7t85e5lbf161181.node0");
        driver.findElement(By.id("j_idt87:j_idt89")).click();
        sleep(1000);
        driver.get("https://leafground.com/radio.xhtml");
        driver.findElement(By.xpath("//table[@id='j_idt87:console1']/tbody[1]/tr[1]/td[1]")).click();
        sleep(2000);
    }

    public static void dropdownMenu() throws InterruptedException {
        driver.get("https://leafground.com/select.xhtml");
        WebElement dropDown = driver.findElement(By.cssSelector("html>body>div>div:nth-of-type(5)>div:nth-of-type(2)>form>div>div>div>div>div>select"));
        Select dd = new Select(dropDown);
        dd.selectByIndex(1);
        sleep(2000);
    }

    public static void dragDrop() throws InterruptedException {
        driver.get("https://demo.guru99.com/test/drag_drop.html");
        getTitleAndUrl();
        WebElement grab = driver.findElement(By.xpath("(//a[@class='button button-orange'])[2]"));
        WebElement drop = driver.findElement(By.id("amt7"));

        Actions gd = new Actions(driver);
        JavascriptExecutor js = driver;

        gd.clickAndHold(grab).moveToElement(drop).release(drop).build().perform();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        sleep(2000);

    }

    public static void getTitleAndUrl() {

        String currentTitle = driver.getTitle();
        String currentUrl = driver.getCurrentUrl();

        System.out.println("Current title is: " + currentTitle + '\n' + "And current URL is: " + currentUrl);

    }

    public static void listSizeDisplayElements() throws InterruptedException {
        driver.get("https://demo.opencart.com/");
        sleep(1000);

        List<WebElement> link = driver.findElements(By.tagName("a"));
        System.out.println(link.size());

        for (WebElement l : link) {
            System.out.println(l.getSize());
            System.out.println(l.getText());
        }
        sleep(100);
    }

    public static void main(String[] args) throws InterruptedException {
        addDeleteElement();
        enterTextAndSearch();
        checkboxAndRadio();
        dropdownMenu();
        dragDrop(); // Gets title and URL from this webpage
        listSizeDisplayElements();
        quitChrome();
    }
}

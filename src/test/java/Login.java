import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;

public class Login {
    WebDriver wd;

    @BeforeMethod
    public void preCondition(){
        //open browser
        wd = new ChromeDriver();
        //open site
        wd.get("https://telranedu.web.app/");
    }

    @Test
    public void findElementsOnPage(){
        //by tagName
        WebElement element = wd.findElement(By.tagName("div"));
        List<WebElement> divs = wd.findElements(By.tagName("div"));

        //by id
        WebElement el1 = wd.findElement(By.id("root"));
        
        //by class
        WebElement el2 = wd.findElement(By.className("container"));
        
        //by name
        //WebElement name = wd.findElement(By.name("name"));

        //by link text a href
        wd.findElement(By.linkText("HOME"));
        wd.findElement(By.linkText("ABOUT"));
        wd.findElement(By.partialLinkText("HO"));
    }

    @Test
    public void registrationSuccess(){
        WebElement itemLogin = wd.findElement(By.linkText("LOGIN"));
        itemLogin.click();

        WebElement email = wd.findElement(By.name("email"));
        email.clear();
        email.click();
        email.sendKeys("katya@gmail.com");

        WebElement password = wd.findElement(By.name("password"));
        password.clear();
        password.click();
        password.sendKeys("Kkate1234$");

        WebElement registrationButton = wd.findElement(By.name("registration"));
        registrationButton.click();

    }

    @Test
    public void loginSuccess(){
        //open form
        //wd find button + click
        WebElement itemLogin = wd.findElement(By.linkText("LOGIN"));
        itemLogin.click();

        //fill form
        //find email + click + type
        WebElement email = wd.findElement(By.name("email"));
        email.click();
        email.clear();
        email.sendKeys("noa@gmail.com");
        //find password + click + type
        WebElement password = wd.findElement(By.name("password"));
        password.click();
        password.clear();
        password.sendKeys("Nnoa12345$");

        //submit form
        //find button login + click
        List<WebElement> buttons = wd.findElements(By.tagName("button"));
        WebElement buttonLogin = buttons.get(0);
        buttonLogin.click();
        Assert.assertEquals("","");
    }

    @Test
    public void cssLocatorTest(){
        wd.findElement(By.linkText("LOGIN")).click();
        wd.findElement(By.tagName("div"));
        wd.findElement(By.cssSelector("div"));
        wd.findElement(By.cssSelector(".container"));
        wd.findElement(By.cssSelector(".active"));
        wd.findElement(By.cssSelector(".navbar-component_nav__1X_4m"));
        wd.findElement(By.cssSelector("[aria-current='page']"));
        wd.findElement(By.cssSelector("[placeholder='Email']"));
        wd.findElement(By.cssSelector("[placeholder='Password']"));
        wd.findElement(By.cssSelector("[placeholder^='Pass']"));
        wd.findElement(By.cssSelector("[placeholder*='ass']"));
        wd.findElement(By.cssSelector("[placeholder$='ord']"));
        wd.findElement(By.cssSelector("div.container[id=root]"));
        wd.findElement(By.cssSelector("[href='/login']"));
        wd.findElement(By.cssSelector("input[name=email]"));
        wd.findElement(By.cssSelector("button[name=login]"));
        wd.findElement(By.cssSelector("button:last-child")); //registration button search
        wd.findElement(By.cssSelector("form:last-child")); //form search
    }
    @AfterMethod
    public void postCondition(){
        //close browser
        //wd.quit();
    }

}

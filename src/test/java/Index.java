import org.checkerframework.checker.signature.qual.DotSeparatedIdentifiersOrPrimitiveType;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Index {
    WebDriver wd;
    @BeforeMethod
    public void start(){
       wd = new ChromeDriver();
       wd.get("file:///C:/Users/User/Downloads/index.html");
       wd.manage().window().maximize();
    }

    @Test
    public void itemsTest(){
        //find item1 & click ==> assert that div#alert contains message "Clicked by Item 1"
        //find item2 & click ==> assert that div#alert contains message "Clicked by Item 2"
        //find item3 & click ==> assert that div#alert contains message "Clicked by Item 3"
        //find item4 & click ==> assert that div#alert contains message "Clicked by Item 4"

    }

    @Test
    public void formTests(){
        //fill name&surname & click send
        //assert that div#alert contains message "name&surname"
    }
    @Test
    public void tableTest(){
        //check if table has 4 rows
        List<WebElement> rows = wd.findElements(By.cssSelector("tr"));
        Assert.assertEquals(rows.size(),4);
        //check that last row contains "Mexico"
        WebElement lastRow = wd.findElement(By.cssSelector("tr:last-child"));
        String text = lastRow.getText();
        System.out.println(text);
        //"Poland Chine Mexico" contains "Mexico"
        Assert.assertTrue(text.contains("Mexico"));
        //another variant
        WebElement lastCell = wd.findElement(By.cssSelector("tr:last-child:last-child"));
        String str = lastCell.getText();
        Assert.assertTrue(str.contains("Mexico"));
        wd.quit();
    }

}

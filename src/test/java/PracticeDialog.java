import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class PracticeDialog extends TestBase {

    public void fillInForm(){
        driver.findElement(By.id("create-user")).click();
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys("Marian Mariano");
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("Marian@Marianowski.pl");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("Marian123");
        driver.findElement(By.xpath(".//button[text()='Create an account']")).click();

    }

    @Test
    public void Test(){
        driver.get("http://seleniumui.tc-sii.com/modal-dialog.php");
        fillInForm();

    }

}

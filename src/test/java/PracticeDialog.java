import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class PracticeDialog extends TestBase {

    public void fillInForm(String name, String email, String password){
        driver.findElement(By.id("create-user")).click();
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(name);
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.xpath(".//button[text()='Create an account']")).click();

    }

    @Test
    public void Test(){
        driver.get("http://seleniumui.tc-sii.com/modal-dialog.php");
        fillInForm("Marian Mariano", "mariano@mariano.pl", "marian1");
        fillInForm("Wojtek woj", "wojtek@mariano.pl", "wojtek1");
        fillInForm("Wlodek Mariano", "wlodek@mariano.pl", "wlodek23");
        fillInForm("Agnes Mariano", "agnes@mariano.pl", "agnetysi1");
        
    }

}

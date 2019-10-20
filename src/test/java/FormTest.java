import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class FormTest {

    @Test
    public void testForm() {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\Tester\\Desktop\\shop\\shop\\Selenium\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        ChromeDriver driver = new ChromeDriver(options);

        driver.get("http://seleniumui.tc-sii.com/form.php");


    }

}

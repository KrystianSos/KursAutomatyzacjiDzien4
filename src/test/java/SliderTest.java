import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SliderTest extends TestBase {


    public void moveTo(int i) {
        Actions builder = new Actions(driver);
        driver.findElement(By.id("custom-handle")).click();
    }

    @Test
    public void TestSlider() {


    }

}

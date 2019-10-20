import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class SliderTest extends TestBase {

    public void moveLeft() {
        driver.findElement(By.id("custom-handle")).sendKeys(Keys.ARROW_LEFT);
    }

    public void moveRight() {
        driver.findElement(By.id("custom-handle")).sendKeys(Keys.ARROW_RIGHT);
    }

    public void moveTo(int number) {

        int actualValue = 0;

        while (number != actualValue) {

            actualValue = Integer.parseInt(driver.findElement(By.id("custom-handle")).getText());

            if (actualValue < number) {
                moveRight();
            } else if (actualValue > number) {
                moveLeft();
            }
        }

    }

    @Test
    public void TestSlider() {

        driver.get("http://seleniumui.tc-sii.com/slider.php");

        moveTo(50);
        moveTo(20);
        moveTo(20);
        moveTo(75);

    }

}

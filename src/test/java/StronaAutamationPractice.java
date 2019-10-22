import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class StronaAutamationPractice extends TestBase{

    public void addToCart(){

        driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[3]/a")).click();

    }

    @Test
    public void Test(){
        driver.get("http://automationpractice.com/index.php");
        Sleep();
        addToCart();
    }

}

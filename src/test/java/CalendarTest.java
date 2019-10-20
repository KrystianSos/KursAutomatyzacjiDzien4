import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class CalendarTest extends TestBase{

        public String getCurrentMonthNumber() {

            return driver.findElement(By.linkText("15")).getAttribute("data-month");
        }

        public void dateClick() {

            WebElement dataPicker = driver.findElement(By.id("datepicker"));
            dataPicker.click();

            List<WebElement> dayList = driver.findElements(By.cssSelector("td[data-month='" + 9 + "']"));


            for (WebElement day : dayList) {
                if(day.getText().equals("10")) {
                    day.click();
                    break;
                }
            }

        }

        @Test
        public void Test() {
            driver.get("http://seleniumui.tc-sii.com/datepicker.php");
            dateClick();

//            moveTo(21.10.2019);
//            moveTo(21.09.2019);
//            moveTo(1.12.2019);
//            moveTo(21.02.2020);
//            moveTo(21.12.2018);

        }
}


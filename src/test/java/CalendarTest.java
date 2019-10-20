import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class CalendarTest extends TestBase {
    List<String> allMonths = Arrays.asList("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");

    @Test
    public void Test1() {
        driver.get("http://seleniumui.tc-sii.com/datepicker.php");
        moveTo("4", "January", 2018);
        String selectdate = driver.findElement(By.id("datepicker")).getAttribute("value");
        Assert.assertEquals(selectdate, "01/04/2018");
    }

    @Test
    public void Test2() {
        driver.get("http://seleniumui.tc-sii.com/datepicker.php");
        moveTo("18", "March", 2019);
        String selectdate = driver.findElement(By.id("datepicker")).getAttribute("value");
        Assert.assertEquals(selectdate, "03/18/2019");
    }

    @Test
    public void Test3() {
        driver.get("http://seleniumui.tc-sii.com/datepicker.php");
        moveTo("22", "April", 2020);
        String selectdate = driver.findElement(By.id("datepicker")).getAttribute("value");
        Assert.assertEquals(selectdate, "04/22/2020");
    }

    @Test
    public void Test4() {
        driver.get("http://seleniumui.tc-sii.com/datepicker.php");
        moveTo("10", "January", 2019);
        String selectdate = driver.findElement(By.id("datepicker")).getAttribute("value");
        Assert.assertEquals(selectdate, "01/10/2019");
    }

    private void moveTo(String expectedDay, String expectedMonth, int expectedYear) {
        WebElement dataPicker = driver.findElement(By.id("datepicker"));
        dataPicker.click();
        Sleep();
        //TODO przełączenie na odpwiedni rok + miesiąc

        while((expectedYear != getYear()) || (getIndexOfMonth(expectedMonth) != getIndexOfMonth(getMonth()))) {
            //jeżeli (oczeRok<aktRok) => prev
            if (expectedYear < getYear()) {
                goPrev();
            }
            //jeżeli (oczeRok>aktRok) => next
            else if (expectedYear > getYear()) {
                goNext();
            }
            //jeżeli (oczeMsc<aktMsc)=> prev
            else if (getIndexOfMonth(expectedMonth) < getIndexOfMonth(getMonth())) {
                goPrev();
            }
            //jeżeli (oczeMsc>aktMsc)=> next
            else if (getIndexOfMonth(expectedMonth) > getIndexOfMonth(getMonth())) {
                goNext();
            }
        }


        // po wszystkim wybranie dnia
        selectDay(expectedDay);
    }

    private void selectDay(String dayToSelect) {
        List<WebElement> allDays =
                driver.findElements(By.cssSelector("td[data-month='" + getCurrentMonthNumber() + "']"));
        for (WebElement day : allDays) {
            if (day.getText().equals(dayToSelect)) {
                day.click();
                break;
            }
        }
    }

    private String getCurrentMonthNumber() {
        return driver.findElement(By.xpath("//td[.='15']")).getAttribute("data-month");
    }

    public void goNext() {
        driver.findElement(By.className("ui-datepicker-next")).click();
        Sleep();
    }

    public void goPrev() {
        driver.findElement(By.className("ui-datepicker-prev")).click();
        Sleep();
    }


    private String getMonth() {
        return driver.findElement(By.className("ui-datepicker-month")).getText();
    }

    private int getYear() {
        return Integer.parseInt(driver.findElement(By.className("ui-datepicker-year")).getText());
    }

    private int getIndexOfMonth(String monthName){
        return allMonths.indexOf(monthName);
    }
}
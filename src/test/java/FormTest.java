import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

public class FormTest {

    WebDriver driver;
    ChromeOptions options;

    public WebElement getRandomElement(List<WebElement> elements) {
        //Ta metoda przyjmuje listę, a zwraca jeden WebElement
        Random random = new Random();
        int randomNumber = random.nextInt(elements.size()-1); //losuje wartość z zadanego przedziału
        return elements.get(randomNumber); //zwraca element o losowym indeksie. Metoda get jest dostępna z selenium do obsługi list
    }

    @BeforeMethod
    public void setUp(){

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Tester\\Desktop\\shop\\shop\\Selenium\\chromedriver.exe");
        options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);

    }


    @Test
    public void testForm() {


        driver.get("http://seleniumui.tc-sii.com/form.php");
        driver.findElement(By.cssSelector("[id='inputFirstName3']")).sendKeys("Marian");
        driver.findElement(By.cssSelector("[id='inputLastName3']")).sendKeys("Marianowski");
        driver.findElement(By.cssSelector("[id='inputEmail3']")).sendKeys("marian@marian.pl");
        driver.findElement(By.cssSelector("[id='gridRadiosMale']")).click();
        driver.findElement(By.cssSelector("[id='inputAge3']")).sendKeys("18");

        //To poniżej klika w losowy element z listy
        List<WebElement> yearsList = driver.findElements(By.name("gridRadiosExperience"));
        WebElement randomList = getRandomElement(yearsList);
        randomList.click();

        //driver.findElement(By.cssSelector("[id='gridRadios3']")).click();

        driver.findElement(By.cssSelector("[id='gridCheckAutomationTester']")).click();




        driver.findElement(By.cssSelector("[id='selectContinents']")).click();
        WebElement continentsElement = driver.findElement(By.cssSelector("[id='selectContinents']"));
        Select continentsSelect = new Select(continentsElement);
        continentsSelect.selectByValue("europe");



        driver.findElement(By.cssSelector("[value='switch-commands']")).click();

        driver.findElement(By.cssSelector("[id='chooseFile']")).sendKeys("C:\\Users\\Tester\\pictures\\11.png");
        driver.findElement(By.cssSelector("[id='additionalInformations']")).sendKeys("Dodatkowe informacje");
        driver.findElement(By.cssSelector("[type='submit']")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("[id='validator-message']")).getText(), "Form send with success");

    }




    @AfterMethod
    public void tearDown(){
      //driver.close();
    }

}

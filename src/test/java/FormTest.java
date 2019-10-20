import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;
import java.util.Random;

public class FormTest extends TestBase {

    //https://github.com/mtadla-sii/selenium-basic-1019 - repo z ćwiczeń


    public WebElement getRandomElement(List<WebElement> elements) {
        //Ta metoda przyjmuje listę, a zwraca jeden WebElement
        Random random = new Random();
        int randomNumber = random.nextInt(elements.size() - 1); //losuje wartość z zadanego przedziału
        return elements.get(randomNumber); //zwraca element o losowym indeksie. Metoda get jest dostępna z selenium do obsługi list
    }

    public void Sleep() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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

        //Losowanie z listy rozwijanej (kontynenty)

        WebElement continentElement = driver.findElement(By.id("selectContinents"));
        Select continentSelect = new Select(continentElement);
        List<WebElement> allOptions = continentSelect.getOptions();
        WebElement randomOption = getRandomElement(allOptions);
        continentSelect.selectByVisibleText(randomOption.getText());

        //Wybór z listy rozwijanej (kontynenty)
/*
        driver.findElement(By.cssSelector("[id='selectContinents']")).click();
        WebElement continentsElement = driver.findElement(By.cssSelector("[id='selectContinents']"));
        Select continentsSelect = new Select(continentsElement);
        continentsSelect.selectByValue("europe");*/


        driver.findElement(By.cssSelector("[value='switch-commands']")).click();

        File file = new File("src\\main\\resources\\fail-TestSiiKoszyk-13.png");
        driver.findElement(By.cssSelector("[id='chooseFile']")).sendKeys(file.getAbsolutePath());
        driver.findElement(By.cssSelector("[id='additionalInformations']")).sendKeys("Dodatkowe informacje");
        driver.findElement(By.cssSelector("[type='submit']")).click();

        //Asercja wiadomości pod buttonem "Sign in"
        String messageText = driver.findElement(By.cssSelector("[id='validator-message']")).getText();
        Assert.assertEquals(messageText, "Form send with success");

    }

}

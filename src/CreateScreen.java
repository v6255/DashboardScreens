import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class CreateScreen {
    //создание скриншота
    public static File Create_screen() throws InterruptedException {
        String Site = "http://dashboard:7080/hqu/wmvisualizer/wmvisualizer/player.hqu?layout=Zvezda";
        String Login = "hqadmin";
        String Password = "hqadmin";
        String FileListJobs = "C:/Svodka";
        String PathChromeDriver = "C:/Svodka/chromedriver.exe";

        System.setProperty("webdriver.chrome.driver", PathChromeDriver);

        WebDriver driver = new ChromeDriver();

        driver.get(Site);
        WebElement login = driver.findElement(By.name("j_username"));
        login.sendKeys(Login);
        WebElement password = driver.findElement(By.name("j_password"));
        password.sendKeys(Password);
        password.sendKeys(Keys.ENTER);
        //WebDriverWait search_wait = new WebDriverWait(driver, 20);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom='80%'");
        Thread.sleep(10000);
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        driver.close();
        return scrFile;
    }
}

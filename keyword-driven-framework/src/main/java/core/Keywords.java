package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Keywords {
    private static WebDriver driver;

    public static boolean open(String browserName) {
        try {
            System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver");
            driver = new ChromeDriver();
            return true;
        } catch (Exception e){
            return false;
        }

    }

    public static boolean visit(String url) {
        try {
            driver.get(url);
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    public static boolean click(String locator) {
        try {
            driver.findElement(By.cssSelector(locator)).click();
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public static boolean fill(String locator, String withText) {
        try {
            driver.findElement(By.name(locator)).sendKeys(withText+"\n");
            return true;
        }catch (Exception e){
            return false;
        }


    }
}

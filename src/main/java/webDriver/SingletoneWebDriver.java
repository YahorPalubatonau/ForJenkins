package webDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SingletoneWebDriver {
    private static WebDriver singletoneWebDriver;
    private SingletoneWebDriver() {
    }

    public static WebDriver getSingletoneWebDriver() {
        if (singletoneWebDriver == null) {
            singletoneWebDriver = new ChromeDriver();
        }
        return singletoneWebDriver;
    }
}


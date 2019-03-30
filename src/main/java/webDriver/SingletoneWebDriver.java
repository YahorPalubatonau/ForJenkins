package webDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SingletoneWebDriver {
    private static WebDriver singletoneWebDriver;
    private SingletoneWebDriver() {
    }

    public static WebDriver getSingletoneWebDriver() {
        if (singletoneWebDriver == null) {
            // ChromeDriver is just AWFUL because every version or two it breaks unless you pass cryptic arguments
            //AGRESSIVE: options.setPageLoadStrategy(PageLoadStrategy.NONE); // https://www.skptricks.com/2018/08/timed-out-receiving-message-from-renderer-selenium.html
            ChromeOptions chromeOptions = new ChromeOptions();
            //chromeOptions.addArguments("start-maximized"); // https://stackoverflow.com/a/26283818/1689770
           // chromeOptions.addArguments("enable-automation"); // https://stackoverflow.com/a/43840128/1689770
           // chromeOptions.addArguments("--headless"); // only if you are ACTUALLY running headless
            chromeOptions.addArguments("--no-sandbox"); //https://stackoverflow.com/a/50725918/1689770
           // chromeOptions.addArguments("--disable-infobars"); //https://stackoverflow.com/a/43840128/1689770
           // chromeOptions.addArguments("--disable-dev-shm-usage"); //https://stackoverflow.com/a/50725918/1689770
            //chromeOptions.addArguments("--disable-browser-side-navigation"); //https://stackoverflow.com/a/49123152/1689770
            chromeOptions.addArguments("--disable-gpu"); //https://stackoverflow.com/questions/51959986/how-to-solve-selenium-chromedriver-timed-out-receiving-message-from-renderer-exc
           // chromeOptions = new ChromeDriver(options);
            singletoneWebDriver = new ChromeDriver(chromeOptions);
        }
        return singletoneWebDriver;
    }
}


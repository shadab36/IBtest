package com.intelligencebank.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class WebDriverManager {

    public WebDriver driver;

    private WebDriver createChromeDriver(Boolean headless) {
        ChromeOptions chromeoptions = new ChromeOptions();
        if (headless) {
            chromeoptions.addArguments("--headless");
            chromeoptions.addArguments("window-size=1200,1100");
        }
        chromeoptions.addArguments("disable-gpu");

        WebDriver chromedriver = new ChromeDriver(chromeoptions);
        return chromedriver;
    }

    private WebDriver createFirefoxDriver() {
        FirefoxOptions ffoptions = new FirefoxOptions();
        //ffoptions.addPreference("browser.download.folderList", 2);
        //ffoptions.addPreference("browser.download.dir", "C:\\Windows\\temp");
        //ffoptions.addPreference("browser.download.useDownloadDir", true);
        //ffoptions.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/vnd.ms-excel");

        WebDriver ffdriver = new FirefoxDriver(ffoptions);
        return ffdriver;
    }

    private WebDriver createIEDriver() {
        InternetExplorerOptions ieoptions = new InternetExplorerOptions();
        // DesiredCapabilities capabilities = new DesiredCapabilities();
        // capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        // capabilities.setCapability(CapabilityType.HAS_NATIVE_EVENTS, true);
        // capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        // capabilities.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
        // capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);        

        WebDriver iedriver = new InternetExplorerDriver(ieoptions);
        return iedriver;
    }

    public WebDriver createDriver(TestNGParameters parameters) throws Exception {

        if (driver != null) return driver;

        switch(parameters.Browser.toLowerCase()) {
            case "firefox":
                driver = createFirefoxDriver();
                break;
            case "chrome-mac":
                System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/mac/chromedriver_mac");
                driver = createChromeDriver(parameters.Headless);
                break;
            case "chrome-windows":
                System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/windows/chromedriver.exe");
                driver = createChromeDriver(parameters.Headless);
                break;
            case "ie":
                System.setProperty("webdriver.ie.driver", "src/test/resources/drivers/IEDriverServer.exe");
                driver = createIEDriver();
                break;
            default:
                throw new Exception("Unsupported selenium driver of type: " + parameters.Browser);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);

        return driver;
    }

    public WebDriver getDriver() throws Throwable {
        if (driver == null) throw new Exception("driver not initialised");
        return driver;
    }

    public void takeScreenshot(String contextPart, String descriptionPart) throws IOException {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String imageFileName = new SimpleDateFormat("yyyy-MM-dd_HH-ss").format(new GregorianCalendar().getTime());

        if (contextPart != null) {
            if (contextPart.isEmpty() == false) imageFileName += " " + contextPart;
        }

        if (descriptionPart != null) {
            if (descriptionPart.isEmpty() == false) imageFileName += " " + descriptionPart;
        }

        imageFileName += ".png";

        FileUtils.copyFile(src, new File("target/screenshots/" + imageFileName));
    }

    public void closeDriver() {
        if (driver == null) return;
        driver.close();
        driver.quit();
        driver = null;
    }
}

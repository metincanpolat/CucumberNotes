package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

//23.11.2022
public class GWDBasic {

    private static WebDriver driver;

    public static WebDriver getDriver()
    {
        // extend report türkçe bilg çalışmaması sebebiyle kondu
        Locale.setDefault(new Locale("EN"));
        System.setProperty("user.language", "EN");

        if (driver==null) {
            // driver ı start et doldur, başlat ve gönder

            Logger.getLogger("").setLevel(Level.SEVERE);
            System.setProperty(org.slf4j.simple.SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "Error"); //SLFJ4 uyarılarını kaldırmak için
            System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true"); // Chrome uyarılarılarını kaldırmak için

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();



        }


        return driver;
    }

    public static void quitDriver(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if(driver!=null){ // dolu ise. başlangıçta içerisini doldurmuştuk.
            driver.quit();
            driver=null; // uygulamayı kapatınca driver içerisini tekrar boşaltıyoruz.
        }
    }

}

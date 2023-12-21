import java.util.HashMap;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.Test;


public class hashmap
{

            static HashMap <String, String> login()
            {
                HashMap<String, String> hm = new HashMap<String, String>();
                hm.put("mohamed", "mohamed@28lightbulbs.com&mohamed@123");
                hm.put("notify-user1", "notify_user1@yopmail.com&mohamed321");
                return hm;
            }

           @Test
           public void x()
           {
               WebDriverManager.chromedriver().setup();
               ChromeOptions options= new ChromeOptions();
               options.addArguments("--disable-notifications");
               options.addArguments("--incognito");
               WebDriver driver=new ChromeDriver(options);
               driver.get("https://test-designer.lovethat.design/auth/login");
               driver.manage().window().maximize();
               String login1 = login().get("mohamed");
               String arr[] = login1.split("&");
               driver.findElement(By.name("username")).sendKeys(arr[0]);
               driver.findElement(By.name("pass")).sendKeys(arr[1]);
               driver.findElement(By.xpath("//button[.='Sign In']")).click();



           }

        }
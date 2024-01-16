import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.Test;


public class hashmap {

    /*        public static HashMap <String, String> login()
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

            for(String k: login().keySet()){
                System.out.println("For each key is :"+k+"  Value is :"+login().get(k));
            }

               System.out.println("Key set is : "+login().keySet());

               Iterator<String> itr = login().keySet().iterator(); {
                while(itr.hasNext()){
                    String k = itr.next();
                    System.out.println("Iterator Key is :"+k+" value is :"+login().get(k));
                   }
               }

               //loops
               int array[] = {10,20,30,40};
               int size = array.length;
               for(int i=0; i<size; i++){
                   System.out.println("printing array value: "+array[i]);

           }
           }*/
    public static void main(String args[]) {
        Map<String, Integer> hp = new HashMap<>();
        HashMap<String, Integer> hp1 = new HashMap<>();
        hp.put("Riyas", +524242211);
        hp.put("Muja",  +568691810);
        hp.put("Samiya", +123456789);


        System.out.println(hp.get("Riyas"));
        System.out.println(hp.containsKey("Muja"));
        System.out.println(hp.size());
        System.out.println(hp.containsValue(123456));
        System.out.println(hp1.isEmpty());
        System.out.println(hp.entrySet());
        System.out.println(((HashMap<String, Integer>) hp).clone());
        System.out.println(hp.keySet());

        for(String k : hp.keySet()){
            System.out.println(k+" mobile number is "+hp.get(k));
        }

    }
}
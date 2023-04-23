package BuildIt_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;

public class LogIn {

        WebDriver driver;
        String baseUrl;


        @BeforeTest
        public void setUp() {

            driver= new ChromeDriver();
            baseUrl="http://localhost:3000/";
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }


        @Test
        public void login() throws InterruptedException{
            driver.get(baseUrl);
            //get title of current page
            String title= driver.getTitle();
            String currentUrl= driver.getCurrentUrl();
            System.out.println(title);
            System.out.println(currentUrl);
            //define web element
            WebElement username_email= driver.findElement(By.id("userName-Email"));
            WebElement password= driver.findElement(By.id("password"));
            WebElement submit= driver.findElement(By.id("submit"));
            WebElement logOut= driver.findElement(By.xpath("//a[contains(text(),'Log out')]"));
            //actions
            username_email.sendKeys("Test");
            password.sendKeys("Automation");
            System.out.println("after signIn");
            submit.click();
            Thread.sleep(200);
            title= driver.getTitle();
            currentUrl= driver.getCurrentUrl();
            System.out.println(title);
            System.out.println(currentUrl);

            //fail or pass
            boolean notPresent=false;
            notPresent= logOut.isDisplayed();

            if(notPresent==true){
                System.out.println("Pass");
            }
            else{
                System.out.println("failed");
            }
        }

        @Test
        public void SignUp() throws InterruptedException{
            driver.get(baseUrl);
            //define web element
            WebElement signUp= driver.findElement(By.id("signUp"));
            //get title of current page
            String title= driver.getTitle();
            String currentUrl= driver.getCurrentUrl();
            System.out.println(title);
            System.out.println(currentUrl);
            System.out.println("After clicking signup");
            //click sign up
            signUp.click();
            Thread.sleep(200);
            title= driver.getTitle();
            currentUrl= driver.getCurrentUrl();
            System.out.println(title);
            System.out.println(currentUrl);

            //define web element
            WebElement firstName= driver.findElement(By.id("firstName"));
            WebElement lastName= driver.findElement(By.id("firstName"));
            WebElement userName= driver.findElement(By.id("userName"));
            WebElement email= driver.findElement(By.id("email"));
            WebElement password= driver.findElement(By.id("password"));
            WebElement confirmPassword= driver.findElement(By.id("confirmPassword"));
            WebElement submit= driver.findElement(By.id("submit"));
            WebElement logOut= driver.findElement(By.xpath("//a[contains(text(),'Log out')]"));

            //actions
            firstName.sendKeys("Test");
            lastName.sendKeys("Automation");
            userName.sendKeys("Test_Automation");
            email.sendKeys("testAutomation@oakland.edu");
            password.sendKeys("user1");
            confirmPassword.sendKeys("user1");


            System.out.println("after submit");
            submit.click();

            Thread.sleep(200);

            title= driver.getTitle();
            currentUrl= driver.getCurrentUrl();
            System.out.println(title);
            System.out.println(currentUrl);


            //fail or pass
            boolean notPresent=false;
            notPresent= logOut.isDisplayed();

            if(notPresent==true){
                System.out.println("Pass");
            }
            else{
                System.out.println("failed");
            }
        }
        @AfterTest
        public void tearDown() {
            driver.quit();
        }

        // TODO add test methods here.
        // The methods must be annotated with annotation @Test. For example:
        //
        // @Test
        // public void hello() {}
    }



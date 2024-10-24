package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {

    public static void main(String[] args) {
        

    	//chrome web driver path
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\STTU\\OneDrive\\Desktop\\chromedriver-win64\\Chromedriver.exe");
        
        //ინიციალიზაცია
        WebDriver driver = new ChromeDriver();
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //საიტის ლინკი
        driver.get("https://practicetestautomation.com/practice-test-login/");
        //იუზერის მოძებნვა აიდით და შეყვანა სახელის , პაროლის ფილდის მოძებნა სახელით და შეყვანა პაროლის , საბმით ღილაკის მოძებნვა აიდით და დაჭერა
        LoginActions loginActions = new LoginActions();
        
        loginActions.enterUsername(driver);
        loginActions.enterPassword(driver);
        driver.findElement(By.id("submit")).click();
      
        
        //ტექსტის მოძებნვა სადაც იქნება სიტყვა პაროლი
        try {
            WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[contains(text(),'Congratulations')]")));
            System.out.println("Success message is displayed: " + successMessage.getText());
            
            WebElement logoutButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Log out']")));
            if (logoutButton.isDisplayed()) {
                System.out.println("Log out button is displayed.");
            }

        } catch (NoSuchElementException e) {
            System.out.println("An element was not found: " + e.getMessage());
        }
        
    }
}


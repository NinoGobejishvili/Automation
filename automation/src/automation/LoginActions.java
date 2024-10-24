package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginActions {
    

    private String username = "student1";
    private String password = "Password123";
    
    public void enterUsername(WebDriver driver) {
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys(username); 
    }

    public void enterPassword(WebDriver driver) {
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys(password);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

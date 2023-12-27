package StepObject;

import PageObject.LoginObject;
import org.openqa.selenium.WebDriver;

public class LogInSteps extends LoginObject  {
        WebDriver driver;
        public LogInSteps(WebDriver driver1){
            driver=driver1;
        }
        public void userNameAction(String userName){
            driver.findElement(usernameField).sendKeys(userName);
        }

        public void passwordFieldAction(String password){
            driver.findElement(passwordField).sendKeys(password);
        }

        public void loginButton(){
            driver.findElement(loginButton).click();
        }
    }



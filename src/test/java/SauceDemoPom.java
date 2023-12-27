import StepObject.LogInSteps;
import Utils.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static DataObject.LogInData.*;


public class SauceDemoPom extends BrowserActions {

    @Test
    public void LogInWithCorrectData() throws InterruptedException {
        openBrowser();
        LogInSteps Steps = new LogInSteps(driver);
        Thread.sleep(2000);
        Steps.userNameAction(username);
        Thread.sleep(2000);
        Steps.passwordFieldAction(password);
        Thread.sleep(2000);
        Steps.loginButton();
        Thread.sleep(2000);

        String
                expectedResult = "Products",
                actualResult = driver.findElement(By.className("title")).getText();
        //Hard assert Assert.assertEquals(actualResult,expectedResult);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualResult, expectedResult);
        softAssert.assertAll();
    }

    @Test
    public void logInWithIncorrectData() throws InterruptedException {
        LogInSteps Steps = new LogInSteps(driver);
        Thread.sleep(2000);
        Steps.userNameAction(incorrectUsername);
        Thread.sleep(2000);
        Steps.passwordFieldAction(incorrectPassword);
        Thread.sleep(2000);
        Steps.loginButton();
        Thread.sleep(2000);
        WebElement errorMessage = driver.findElement(By.cssSelector("[class='error-message-container error']"));
        String backgroundColor = errorMessage.getCssValue("background-color");
        System.out.println("Background Color" + backgroundColor);

        Assert.assertEquals("rgba(226, 35, 26, 1)", backgroundColor, "Background color does not match.");


    }
}
        /*public class SauceDemoPom2 extends BrowserActions {
   @DataProvider
    public static
    Object[][] logInWithIncorrectData(){
        return new Object[][]{
                {"incorrect username","incorrect password"}
        };}

            @Test//(dataProvider="logInWithIncorrectData")
            public void logInWithIncorrectData() throws InterruptedException {
                openBrowser();
                LogInSteps Steps = new LogInSteps(driver);
                Thread.sleep(2000);
                Steps.userNameAction(incorrectUsername);
                Thread.sleep(2000);
                Steps.passwordFieldAction(incorrectPassword);
                Thread.sleep(2000);
                Steps.loginButton();
                Thread.sleep(2000);
                driver.close();

            }
        }
        }
*/






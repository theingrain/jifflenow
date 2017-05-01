package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Abc on 4/28/2017.
 */
public class LoginPage {

    WebDriver driver =null;

    @FindBy(xpath="//input[@type='email']")
    WebElement email;

    @FindBy(id="next")
    WebElement next;

    @FindBy(xpath="//input[@type='password']")
    WebElement password;

    @FindBy(id="signIn")
    WebElement login;

    public LoginPage(WebDriver driver) {
        this.driver=driver;
    }

    public LoginPage enterUsername(String username) {
        email.click();
        email.clear();
        email.sendKeys(username);
        return this;
    }

    public LoginPage clickNext() {
        new Actions(driver).sendKeys(Keys.ENTER).build().perform();
        return this;
    }
    public LoginPage enterPassword(String password) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='password']")));

        this.password.clear();
        this.password.click();
        this.password.sendKeys(password);
        return this;
    }

    public void submit() {
        new Actions(driver).sendKeys(Keys.ENTER).build().perform();
    }

}

package tests;

import base.BaseTest;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.Settingspage;

/**
 * Created by Abc on 4/28/2017.
 */
public class JifflenowTests extends BaseTest {

    @Test
    public void loginTest() throws InterruptedException {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.enterUsername("kulkarni.karthik@gmail.com");
        loginPage.clickNext();
        loginPage.enterPassword("G00gle3087");
        loginPage.submit();
        Thread.sleep(5000);
    }

    @Test(dependsOnMethods = "loginTest")
    public void clickOnSettingsTest() {
        String url = driver.getCurrentUrl();
        String splirUrl[] = url.split("#");
        StringBuffer appendedUrl = new StringBuffer(splirUrl[0]);
        StringBuffer newUrl = appendedUrl.append(appendedUrl + "#settings-general_11");
        String settingsUrl = new String(newUrl);
        driver.get(settingsUrl);
        System.out.println(driver.getCurrentUrl());
    }

    @Test(dependsOnMethods = "clickOnSettingsTest")
    public void changeTimeZoneTest() {
        Settingspage settingsPage = PageFactory.initElements(driver, Settingspage.class);
        settingsPage.selectTimeZone();
    }

    @Test(dependsOnMethods = "clickOnSettingsTest")
    public void changeTimeFormatTest() {
        Settingspage settingsPage = PageFactory.initElements(driver, Settingspage.class);
        settingsPage.selectTimeFormat();
    }

    @Test(dependsOnMethods = "clickOnSettingsTest")
    public void changeDayTest() {
        Settingspage settingsPage = PageFactory.initElements(driver, Settingspage.class);
        settingsPage.selectDay();
    }

    @Test(dependsOnMethods = "clickOnSettingsTest")
    public void changeEventDurationTest() {
        Settingspage settingsPage = PageFactory.initElements(driver, Settingspage.class);
        settingsPage.selectEventDuration();
    }

    @Test(dependsOnMethods = "clickOnSettingsTest")
    public void enableSpeedyMeetingsTest() {
        Settingspage settingsPage = PageFactory.initElements(driver, Settingspage.class);
        settingsPage.clickSpeedyMeeting();
    }
}

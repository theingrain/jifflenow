package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Abc on 4/28/2017.
 */
public class Settingspage {
    WebDriver driver = null;

    @FindBy(xpath = "//p[@class=\"speedy-main\"]")
    WebElement speedyMeetingCheckbox;

    @FindBy(id = "preftz")
    WebElement changeTimeZone;

    @FindBy(xpath = "//*[text()='Week starts on:']/following-sibling::td[1]/select")
    WebElement changeDay;//the locator is not correct

    @FindBy(id = "format24HourTime")
    WebElement changeTimeFormat;

    @FindBy(xpath = "//*[text()='Default event duration:']/following-sibling::td[1]/div/select")
    WebElement changeEventDuration;// the locator is not correct

    public Settingspage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSpeedyMeeting() {
        speedyMeetingCheckbox.click();
    }

    public void selectTimeZone() {
        Select changeTimeZoneDropDown = new Select(changeTimeZone);
        changeTimeZoneDropDown.selectByIndex(2);
    }


    public void selectDay() {
        Select changeDayDropDown = new Select(changeTimeZone);
        changeDayDropDown.selectByIndex(2);
    }

    public void selectTimeFormat() {
        Select changeTimeDropDown = new Select(changeTimeFormat);
        changeTimeDropDown.selectByIndex(1);
    }

    public void selectEventDuration() {
        Select eventDurationDropDown = new Select(changeEventDuration);
        eventDurationDropDown.selectByIndex(1);
    }
}

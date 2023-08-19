package org.example.RahulShettyCourse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class StaticDropdown {
    public static void main(String[] args) throws InterruptedException {
        WebDriver webDriver = new ChromeDriver();
        String websiteUrl = "https://rahulshettyacademy.com/dropdownsPractise/";
        browserSetup(webDriver, websiteUrl);
//      staticDropdownOperations(webDriver);
        passengersDropdownOption(webDriver);
    }
    public static void browserSetup(WebDriver webDriver, String websiteUrl) {
        webDriver.get(websiteUrl);
        webDriver.manage().window().maximize();
    }

    public static void staticDropdownOperations(WebDriver webDriver) throws InterruptedException {
        By currencyDropdown = By.cssSelector("#ctl00_mainContent_DropDownListCurrency");

        WebElement currencyDropDownOption = webDriver.findElement(currencyDropdown);
        Select select = new Select(currencyDropDownOption);
        List<WebElement>availableOptions = select.getOptions();

        //Prints all available options in the static class
        for (int i = 0; i<availableOptions.size();i++ ) {
            System.out.println(availableOptions.get(i).getText());
        }

        //To select all options from start to end, one by one
//        if (!availableOptions.isEmpty()) {
//            for (int j =0; j< availableOptions.size(); j++) {
//                select.selectByIndex(j);
//                Thread.sleep(1000);
//            }
//
//        }


        // Selecting option with visible text command
        if (!availableOptions.isEmpty()) {
            select.selectByVisibleText("INR");
            System.out.println("Now you have selected: "
                    +select.getFirstSelectedOption().getText());
        } else System.out.println("Unable to grab options from the dropdown");
    }

    public static void passengersDropdownOption(WebDriver webDriver) throws InterruptedException {
        By passengerDropdownOption = By.xpath("//div[@id='divpaxinfo']");

        //Adult option in the dropdown
        By adultOptionIncreaseButton = By.xpath("//span[@id='hrefIncAdt']");
        By adultOptionDecreaseButton = By.xpath("//span[@id='hrefDecAdt']"); //Decrease button is only available when number of adult is available more than 1

        //Child option in the dropdown
        By childOptionIncreaseButton = By.xpath("//span[@id='hrefIncChd']");
        By childOptionDecreaseButton = By.xpath("//span[@id='hrefDecChd']"); //Decrease button is only available when number of adult is available more than 1

        //Infant option in the dropdown
        By infantOptionIncreaseButton = By.xpath("//span[@id='hrefIncInf']");
        By infantOptionDecreaseButton = By.xpath("//span[@id='hrefDecInf']"); //Decrease button is only available when number of adult is available more than 1

        //Done button
        By doneButtonForDropdown = By.xpath("//input[@id='btnclosepaxoption']");

        //Opening passenger drop don and selecting add from all options
        webDriver.findElement(passengerDropdownOption).click();

        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        try {

            Thread.sleep(1000);
            webDriver.findElement(adultOptionIncreaseButton).click();
            webDriver.findElement(childOptionIncreaseButton).click();
            webDriver.findElement(infantOptionIncreaseButton).click();

        } catch (Exception e) {

        }

        //Clicking done button after operation
        webDriver.findElement(doneButtonForDropdown).click();

        //Getting text of total number of selected options in the passenger dropdown
        System.out.println(webDriver.findElement(passengerDropdownOption).getText());

    }
}

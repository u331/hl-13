package com.automationpractice;

import com.automationpractice.WebDriverFactory.engine.DriverTypes;
import com.automationpractice.WebDriverFactory.engine.WebDriverFactory;
import com.automationpractice.pages.MainPage;
import com.automationpractice.pages.OrderPage;
import com.automationpractice.pages.SearchPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.Properties;
import java.util.concurrent.TimeUnit;
//import io.cucumber.java.en.Given;

public class Stepdefs {
    public WebDriver driver;
    private final Properties config = Config.loadProperties("src/main/resources/test.properties");
    private MainPage mainPage;
    private SearchPage searchPage;
    private OrderPage orderPage;

    @Given("^open browser$")
    public void openBrowser() {
        System.out.println("opbr_opbr_opbr_opbr_opbr_opbr_opbr_11111111111");
        driver = WebDriverFactory.getDriver(DriverTypes.CHROME);
        driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        System.out.println("opbr_opbr_opbr_opbr_opbr_opbr_opbr_11222111111");
    }

    @Given("^open main page$")
    public void openMainPage() {
        driver.get(config.getProperty("baseurl"));
        mainPage = new MainPage(driver);
    }

    @Then("^close the browser$")
    public void closeTheBrowser() {
        System.out.println("clbr_clbr_clbr_clbr_1111");
    }

    @When("input the Blouse text into the search Input")
    public void inputTheBlouseTextIntoTheSearchInput() {
        mainPage.inputTextToSearchInput("Blouse");
    }

    @When("click the search Submit button")
    public void clickTheSearchSubmitButton() {
        searchPage = mainPage.clickSearchSubmit();
    }

    @When("click the View List link")
    public void clickTheViewListLink() {
        searchPage.clickViewListA();
    }

    @When("click the Add To Cart link of the first product")
    public void clickTheAddToCartLinkOfTheFirstProduct() {
        searchPage.clickAddToCartA();
    }

    @When("click the Proceed to Checkout link")
    public void clickTheProceedToCheckoutLink() {
        orderPage = searchPage.clickProceedToCheckoutA();
    }

    @When("click the increase quantity link of the first item")
    public void clickTheIncreaseQuantityLinkOfTheFirstItem() {
        orderPage.clickFirstItemAddA();
    }


//
//    @cucumber.api.java.en.Given("open browser{int}")
//    public void openBrowser(int arg0) {
//    }
}

package com.automationpractice;

import com.automationpractice.WebDriverFactory.engine.DriverTypes;
import com.automationpractice.WebDriverFactory.engine.WebDriverFactory;
import com.automationpractice.pages.MainPage;
import com.automationpractice.pages.OrderPage;
import com.automationpractice.pages.SearchPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Stepdefs {
    public WebDriver driver;
    private final Properties config = Config.loadProperties("src/main/resources/test.properties");
    private MainPage mainPage;
    private SearchPage searchPage;
    private OrderPage orderPage;
    private SoftAssertions sa = new SoftAssertions();

    @Given("^open browser$")
    public void openBrowser() {
        driver = WebDriverFactory.getDriver(DriverTypes.CHROME);
        driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Given("^open main page$")
    public void openMainPage() {
        driver.get(config.getProperty("baseurl"));
        mainPage = new MainPage(driver);
    }

    //@When("input the Blouse text into the search Input")
    @When("input the {string} text into the search Input")
    public void inputTheBlouseTextIntoTheSearchInput(String searchInput) {
        mainPage.inputTextToSearchInput(searchInput);
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

    @Then("the Total Product Price value of the first item is {string}")
    public void theTotalProductPriceValueOfTheFirstItemIs(String firstItemTotalProductPriceExpected) {
        sa.assertThat(orderPage
                .getFirstItemTotalProductPrice(firstItemTotalProductPriceExpected))
                .isEqualTo(firstItemTotalProductPriceExpected);
    }

    @Then("the Total Product value is {string}")
    public void theTotalProductValueIs(String TotalProductExpected) {
        sa.assertThat(orderPage
                .getTotalProduct(TotalProductExpected))
                .isEqualTo(TotalProductExpected);
    }

    @Then("the Total Shipping value is {string}")
    public void theTotalShippingValueIs(String TotalShippingExpected) {
        sa.assertThat(orderPage
                .getTotalShipping(TotalShippingExpected))
                .isEqualTo(TotalShippingExpected);
    }

    @Then("the Total Price without tax value is {string}")
    public void theTotalPriceWithoutTaxValueIs(String TotalPriceWithoutTaxExpected) {
        sa.assertThat(orderPage
                .getTotalPriceWithoutTax(TotalPriceWithoutTaxExpected))
                .isEqualTo(TotalPriceWithoutTaxExpected);
    }

    @Then("the Total Price value is {string}")
    public void theTotalPriceValueIs(String TotalPriceExpected) {
        sa.assertThat(orderPage
                .getTotalPrice(TotalPriceExpected))
                .isEqualTo(TotalPriceExpected);
    }

    @When("click the Delete product from Cart link of first item")
    public void clickTheDeleteProductFromCartLinkOfFirstItem() {
        orderPage.clickFirstItemCartDeleteA();
    }

    @Then("the {string} text is displayed")
    public void theTextIsDisplayed(String arg0) {
        sa.assertThat(orderPage.isAlertWarning()).isEqualTo(true);
    }

    @Then("^close the browser$")
    public void closeTheBrowser() {
        driver.manage().deleteAllCookies();
        try {Thread.sleep(5000);} catch (InterruptedException e) {e.printStackTrace();}
        driver.close();
        System.out.println("clbr_clbr_clbr_clbr_1111");
    }
}

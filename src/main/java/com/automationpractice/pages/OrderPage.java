package com.automationpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPage {

    private WebDriver driver;
//    private Wait<WebDriver> wait = new WebDriverWait(driver, 5, 5000);
    private String sss = "sss";
    private Wait<WebDriver> wait;

    @FindBy(css = "#cart_summary tr.first_item *[title='Add']")
//    @FindBy(css = "#cart_summary tr.first_item a.cart_quantity_up")
    private WebElement firstItemAddA;

    @FindBy(xpath = "//*[@id='cart_summary']//tr[contains(@class,'first_item')]//*[contains(@id,'total_product_price')]")
    private WebElement firstItemTotalProductPrice;

    @FindBy(id = "total_product")
    private WebElement totalProduct;

    @FindBy(id = "total_shipping")
    private WebElement totalShipping;

    @FindBy(id = "total_price_without_tax")
    private WebElement totalPriceWithoutTax;

    @FindBy(id = "total_price")
    private WebElement totalPrice;

        //chromeDriver.findElement(By.cssSelector("#cart_summary tr.first_item td.cart_delete a")).click();
    @FindBy(css = "#cart_summary tr.first_item td.cart_delete a")
    private WebElement firstItemCartDeleteA;

    @FindBy(css = "#center_column .alert-warning")
    private WebElement alertWarning;


    //    Constructor
    public OrderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 5, 5000);
    }

    public OrderPage clickFirstItemAddA(){
        firstItemAddA.click();
        return this;
    }

    public String getFirstItemTotalProductPrice(String expected) {
        wait.until(ExpectedConditions.textToBePresentInElement( firstItemTotalProductPrice ,  expected)); //need to replace condition
        //try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}
        return firstItemTotalProductPrice.getText();
    }

    public Boolean isFirstItemTotalProductPriceEqualsExpected(String expected) {
        //wait.until(ExpectedConditions.textToBePresentInElement( firstItemTotalProductPrice ,  expected)); //need to replace condition
        //return firstItemTotalProductPrice.getText().equalsIgnoreCase(expected);
        return getFirstItemTotalProductPrice(expected).equalsIgnoreCase(expected);
    }

    public String getTotalProduct(String expected) {
        wait.until(ExpectedConditions.textToBePresentInElement( totalProduct ,  expected)); //need to replace condition
        return totalProduct.getText();
    }

    public Boolean isTotalProductEqualsExpected(String expected) {
        return getTotalProduct(expected).equalsIgnoreCase(expected);
    }

    public String getTotalShipping(String expected) {
        wait.until(ExpectedConditions.textToBePresentInElement( totalShipping ,  expected)); //need to replace condition
        return totalShipping.getText();
    }

    public Boolean isTotalShippingEqualsExpected(String expected) {
        return getTotalShipping(expected).equalsIgnoreCase(expected);
    }

    public String getTotalPriceWithoutTax(String expected) {
        wait.until(ExpectedConditions.textToBePresentInElement( totalPriceWithoutTax ,  expected)); //need to replace condition
        return totalPriceWithoutTax.getText();
    }

    public Boolean isTotalPriceWithoutTaxEqualsExpected(String expected) {
        return getTotalPriceWithoutTax(expected).equalsIgnoreCase(expected);
    }

    public String getTotalPrice(String expected) {
        wait.until(ExpectedConditions.textToBePresentInElement( totalPrice ,  expected)); //need to replace condition
        return totalPrice.getText();
    }

    public Boolean isTotalPriceEqualsExpected(String expected){
        return getTotalPrice(expected).equalsIgnoreCase(expected);
    }

    public OrderPage clickFirstItemCartDeleteA(){
        firstItemCartDeleteA.click();
        return this;
    }

    public Boolean isAlertWarning(){
        wait.until(ExpectedConditions.visibilityOf(alertWarning));
        return alertWarning.getText().equalsIgnoreCase("Your shopping cart is empty.");
    }

}

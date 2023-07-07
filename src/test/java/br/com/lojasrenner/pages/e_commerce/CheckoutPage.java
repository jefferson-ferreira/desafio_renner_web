package br.com.lojasrenner.pages.e_commerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

    private WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public PaymentPage pressPlaceOrder() {
        driver.findElement(By.xpath("//a[contains(@class,'btn btn-default check_out')]")).click();

        return new PaymentPage(driver);
    }
}

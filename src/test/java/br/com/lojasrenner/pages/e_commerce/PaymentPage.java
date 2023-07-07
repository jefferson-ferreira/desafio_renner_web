package br.com.lojasrenner.pages.e_commerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage {

    private WebDriver driver;

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
    }

    public PaymentPage informNameCardField(String nameCard) {
        driver.findElement(By.name("name_on_card")).sendKeys(nameCard);

        return this;
    }

    public PaymentPage informCardNumberField(String cardNumber) {
        driver.findElement(By.name("card_number")).sendKeys(cardNumber);

        return this;
    }

    public PaymentPage informCvvField(String cvv) {
        driver.findElement(By.name("cvv")).sendKeys(cvv);

        return this;
    }

    public PaymentPage informExpiryMonthField(String expiryMonth) {
        driver.findElement(By.name("expiry_month")).sendKeys(expiryMonth);

        return this;
    }

    public PaymentPage informExpiryYearField(String expiryYear) {
        driver.findElement(By.name("expiry_year")).sendKeys(expiryYear);

        return this;
    }

    public OrderPlacedPage pressPayAndConfirmOrder() {
        driver.findElement(By.id("submit")).click();

        return new OrderPlacedPage(driver);
    }
}

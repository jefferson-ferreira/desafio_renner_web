package br.com.lojasrenner.pages.customer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage pressButtonSignupLogin() {
        driver.findElement(By.xpath("//a[contains(.,'Signup / Login')]")).click();

        return new LoginPage(driver);
    }
}

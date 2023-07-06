package br.com.lojasrenner.pages.e_commerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage informUserField(String user) {
        driver.findElement(By.name("email")).sendKeys(user);

        return this;
    }

    public LoginPage informPasswordField(String password) {
        driver.findElement(By.name("password")).sendKeys(password);

        return this;
    }

    public HomePage clickButtonLogin() {
        driver.findElement(By.cssSelector("[data-qa='login-button']")).click();

        return new HomePage(driver);
    }
}

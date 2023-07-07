package br.com.lojasrenner.pages.e_commerce;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage pressButtonSignupLogin() {
        driver.findElement(By.xpath("//a[contains(.,'Signup / Login')]")).click();

        return new LoginPage(driver);
    }

    public ProductDetailsPage viewProduct(String product) {
        WebElement locatorProduct = driver.findElement(By.xpath("//div[@class='productinfo text-center']/p[contains(.,'" + product
                + "')]/../../../div[@class='choose']/ul/li/a"));
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block: \"center\", behavior: \"auto\"});", locatorProduct);
        locatorProduct.click();

        return new ProductDetailsPage(driver);
    }
}
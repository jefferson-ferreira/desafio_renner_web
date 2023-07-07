package br.com.lojasrenner.pages.e_commerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import br.com.lojasrenner.driver.GenericPage;

public class ProductDetailsPage extends GenericPage {

    private WebDriver driver;

    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    public ProductDetailsPage addProductCart(Integer qtd) {
        WebElement quanlity = driver.findElement(By.id("quantity"));
        awaitElementBePresent(quanlity, 100);
        quanlity.sendKeys(Integer.toString(qtd));
        driver.findElement(By.xpath("button[type='button']")).click();

        return this;
    }

        public ProductDetailsPage popupContinueShopping() {
        driver.findElement(By.cssSelector("#cartModal > div > div > div.modal-footer > button")).click();

        return this;
    }

      public HomePage pressButtonHome() {
        driver.findElement(By.xpath("//a[contains(.,'Home')]")).click();

        return new HomePage(driver);
    }

      public CartPage pressButtonCart() {
        driver.findElement(By.xpath("//a[contains(.,'Cart')]")).click();

        return new CartPage(driver);
    }
}
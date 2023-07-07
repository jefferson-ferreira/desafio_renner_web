package br.com.lojasrenner.pages.e_commerce;

import java.util.List;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {

    private WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public CartPage checkCartItems(String product, Integer qtd) throws Exception {
        try {
            boolean achou = false;
            for (int i = 0; i < 20; i++) {
                List<WebElement> gridItens = driver.findElement(By.id("//*[@id='cart_info_table']/tbody"))
                        .findElements(By.tagName("tr"));
                for (WebElement itemGrid : gridItens) {
                    if (achou)
                        break;
                    List<WebElement> linhaGrid = itemGrid.findElements(By.tagName("td"));
                    for (int k = 0; k < (linhaGrid.size()); k++) {
                        if (product.equals(linhaGrid.get(k).getText())) {
                            driver.findElement(By.xpath("//button[@class='disabled'][contains(.,'" + qtd + "')]"))
                                    .getText();
                            achou = true;
                            break;
                        }
                    }
                }
                if (achou)
                    break;
            }
            if (!achou) {
                throw new Exception("O registro -> " + product + " <- não foi encontrado na lista.");
            }
        } catch (NoSuchElementException nsee) {
            throw new NoSuchElementException("Mapeamento incorreto do elemento");
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

        return this;
    }

    public CheckoutPage pressButtonProceedCheckout() {
        driver.findElement(By.cssSelector("btn btn-default check_out")).click();

        return new CheckoutPage(driver);
    }
}

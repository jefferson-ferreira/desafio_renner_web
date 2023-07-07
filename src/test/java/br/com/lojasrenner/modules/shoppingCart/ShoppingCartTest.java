package br.com.lojasrenner.modules.shoppingCart;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import br.com.lojasrenner.driver.GenericPage;
import br.com.lojasrenner.pages.e_commerce.HomePage;


@DisplayName("Purchasing Module Web Tests")
public class ShoppingCartTest extends GenericPage {

    @DisplayName("Successfully make purchases")
    @Test
    public void testSuccessfullyMakePurchases() throws Exception {

        String displayedMessage = new HomePage(driver)

            .pressButtonSignupLogin()

            .informUserField("jefferson@gmail.com")
            .informPasswordField("renner123456")
            .clickButtonLogin()

            .viewProduct("Stylish Dress")
            .addProductCart(3)
            .popupContinueShopping()
            .pressButtonHome()

            .viewProduct("Beautiful Peacock Blue Cotton Linen Saree")
            .addProductCart(2)
            .popupContinueShopping()
            .pressButtonHome()

            .viewProduct("Men Tshirt")
            .addProductCart(1)
            .popupContinueShopping()
            .pressButtonCart()

            .checkCartItems("Stylish Dress", 3)
            .checkCartItems("Beautiful Peacock Blue Cotton Linen Saree", 2)
            .checkCartItems("Men Tshirt", 1)

            .pressButtonProceedCheckout()
            .pressPlaceOrder()
            .informNameCardField("Jefferson F Faria")
            .informCardNumberField("4831598723007465")
            .informCvvField("367")
            .informExpiryMonthField("07")
            .informExpiryYearField("2027")
            .pressPayAndConfirmOrder()
            .captureDisplayedMessage();

            Assertions.assertEquals("Congratulations! Your order has been confirmed!", displayedMessage);
    }
}
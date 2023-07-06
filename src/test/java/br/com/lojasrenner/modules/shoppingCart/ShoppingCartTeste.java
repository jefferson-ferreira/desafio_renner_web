package br.com.lojasrenner.modules.shoppingCart;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import br.com.lojasrenner.driver.GenericPage;
import br.com.lojasrenner.pages.customer.HomePage;


@DisplayName("Purchasing Module Web Tests")
public class ShoppingCartTeste extends GenericPage {

    @DisplayName("Successfully make purchases")
    @Test
    public void testSuccessfullyMakePurchases() {

        new HomePage(driver)
        //Click Signup/Login Button
            .pressButtonSignupLogin()
        //Inform User for Login
            .informUserField("jefferson@gmail.com")
        //Inform Password for Login
            .informPasswordField("renner123456")
        //Press Login Button to send credentials
            .clickButtonLogin();
    }
}

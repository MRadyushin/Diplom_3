import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TransferConstructorFromAccountTest extends  BaseTest{

     @Test
     @DisplayName("Переход по клику на «Конструктор»")
     @Description("Ожидаем успешный переход в конструктор")
     public void checkOpenConstructorAfterClickToConstructor() {
        loginPage = mainPage.clickLogInToAccountButton();
        loginPage.setEmail(DEFAULT_EMAIL);
        loginPage.setPassword(DEFAULT_PASSWORD);
        mainPage = loginPage.clickLogin();
        profilePage = mainPage.clickPersonalAccountButton();
        mainPage = profilePage.clickConstructor();
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals(URL, currentUrl);
     }

     @Test
     @DisplayName("Переход по клику на логотип Stellar Burgers")
     @Description("Ожидаем успешный переход в конструктор")
     public void checkOpenConstructorAfterClickToLogo() {
        loginPage = mainPage.clickLogInToAccountButton();
        loginPage.setEmail(DEFAULT_EMAIL);
        loginPage.setPassword(DEFAULT_PASSWORD);
        mainPage = loginPage.clickLogin();
        profilePage = mainPage.clickPersonalAccountButton();
        mainPage = profilePage.clickStellarBurgersLogo();
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals(URL, currentUrl);
     }

    @After
    public void logOut() {
        profilePage = mainPage.clickPersonalAccountButton();
        profilePage.clickLogOut();
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals(LOGIN_URL, currentUrl);
    }

}
import com.codeborne.selenide.WebDriverRunner;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;

import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LoginTest extends BaseTest{

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    @Description("Ожидаем вход в аккаунт")
    public void checkLogInThroughLogInToAccountButton() {
        loginPage = mainPage.clickLogInToAccountButton();
        loginPage.setEmail(DEFAULT_EMAIL);
        loginPage.setPassword(DEFAULT_PASSWORD);
        mainPage = loginPage.clickLogin();
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals(URL, currentUrl);
    }

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет")
    @Description("Ожидаем вход в аккаунт")
    public void checkLogInThroughProfileButton() {
        loginPage = mainPage.clickProfileButton();
        loginPage.setEmail(DEFAULT_EMAIL);
        loginPage.setPassword(DEFAULT_PASSWORD);
        mainPage = loginPage.clickLogin();
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals(URL, currentUrl);
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    @Description("Ожидаем вход в аккаунт")
    public void checkLogInThroughButtonInRegistrationForm() {
        loginPage = mainPage.clickLogInToAccountButton();
        registerPage = loginPage.clickRegister();
        loginPage = registerPage.clickLogin();
        loginPage.setEmail(DEFAULT_EMAIL);
        loginPage.setPassword(DEFAULT_PASSWORD);
        mainPage = loginPage.clickLogin();
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals(URL, currentUrl);
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    @Description("Ожидаем вход в аккаунт")
    public void checkLogInThroughButtonInForgotPasswordForm() {
        loginPage = mainPage.clickLogInToAccountButton();
        recoveryPasswordPage = loginPage.clickForgotPassword();
        loginPage = recoveryPasswordPage.clickLogin();
        loginPage.setEmail(DEFAULT_EMAIL);
        loginPage.setPassword(DEFAULT_PASSWORD);
        mainPage = loginPage.clickLogin();
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
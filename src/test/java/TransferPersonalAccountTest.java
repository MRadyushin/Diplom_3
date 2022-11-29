import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TransferPersonalAccountTest extends BaseTest {

    @Test
    @DisplayName("Переход по клику на «Личный кабинет")
    @Description("Ожидаем вход в личный кабинет")
    public void checkLogInThroughLogInToAccountButton() {
        loginPage = mainPage.clickLogInToAccountButton();
        loginPage.setEmail(DEFAULT_EMAIL);
        loginPage.setPassword(DEFAULT_PASSWORD);
        mainPage = loginPage.clickLogin();
        mainPage.clickPersonalAccountButton();
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals(ACCOUNT_PROFILE_URL, currentUrl);
    }

    @After
    public void logOut() {
        profilePage = mainPage.clickPersonalAccountButton();
        profilePage.clickLogOut();
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals(LOGIN_URL, currentUrl);
    }
}
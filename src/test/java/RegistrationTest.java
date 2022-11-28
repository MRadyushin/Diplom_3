import client.LoginClient;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import model.Login;
import model.LoginResponse;
import org.junit.After;
import org.junit.Test;
import java.util.Objects;

import static org.apache.http.HttpStatus.*;
import static org.junit.Assert.assertEquals;

public class RegistrationTest extends BaseTest{

     @Test
    @DisplayName("Успешая регистрация")
    @Description("Ожидаем успешную регистрацию")
    public void verificationSuccessfulRegistration() {
        loginPage = mainPage.clickLogInToAccountButton();
        registerPage = loginPage.clickRegister();
        registerPage.setName(name);
        registerPage.setEmail(email);
        registerPage.setPassword(password);
        registerPage.clickRegisterButtonForLogin();
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals(LOGIN_URL, currentUrl);
    }

    @Test
    @DisplayName("Ошибка для некорректного пароля. Минимальный пароль — шесть символов")
    @Description("Ожидаем ошибку для некорректного пароля")
    public void verificationFailedRegistration() {
        loginPage = mainPage.clickLogInToAccountButton();
        registerPage = loginPage.clickRegister();
        registerPage.setPassword(shortPassword);
        registerPage.clickRegisterButton();
        registerPage.compareText(INVALID_PASSWORD);
    }

    @After
    public void clear() {
        if (Objects.equals(WebDriverRunner.getWebDriver().getCurrentUrl(), LOGIN_URL)) {
            Login loginObject = LoginClient.createObjectLogin(email, password);
            Response responseLoginCourier = LoginClient.sendPostRequestAuthLogin(loginObject);
            LoginResponse loginResponse = LoginClient.deserialization(responseLoginCourier);
            String accessToken = loginResponse.getAccessToken();

            Response responseDeleteCourier = LoginClient.sendDeleteRequestAuthUser(accessToken);
            LoginClient.checkExpectedResult(responseDeleteCourier, SC_ACCEPTED, EXPECTED_RESULT_TRUE);
        }
    }

}
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import pageobject.*;
import com.codeborne.selenide.Configuration;
import java.util.Random;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    //Общие данные-----------------------------------------------------------------//
    final String URL = "https://stellarburgers.nomoreparties.site/";
    final String LOGIN_URL = "https://stellarburgers.nomoreparties.site/login";
    //-----------------------------------------------------------------------------//

    //Данные для теста RegistrationTest--------------------------------------------//
    protected String randomString = RandomStringUtils.randomAlphanumeric(5);
    protected String password = RandomStringUtils.randomNumeric(7);
    protected String shortPassword = RandomStringUtils.randomNumeric(3);
    protected String name = RandomStringUtils.randomAlphabetic(6);

    protected String[] mailCompanies = new String[]{"yandex", "mail", "rambler"};
    protected int randomMailCompany = new Random().nextInt(mailCompanies.length);
    protected String email = randomString + "@" + mailCompanies[randomMailCompany] + ".ru";

    protected final static String INVALID_PASSWORD = "Некорректный пароль";
    protected final static boolean EXPECTED_RESULT_TRUE = true;
    //--------------------------------------------------------------------------//

    //Данные для теста LoginTest------------------------------------------------//
    final String DEFAULT_EMAIL = "m.radyushin@yandex.ru";
    final String DEFAULT_PASSWORD = "PraktikumAPI";
    //--------------------------------------------------------------------------//


    MainPage mainPage;
    LoginPage loginPage;
    ProfilePage profilePage;
    RegisterPage registerPage;
    RecoveryPasswordPage recoveryPasswordPage;

    @Before
    public void openMainPage() {
        Configuration.startMaximized = true;
        mainPage = open(URL, MainPage.class);
    }
}

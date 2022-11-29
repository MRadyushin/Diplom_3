import com.codeborne.selenide.Configuration;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import pageobject.*;

import java.util.Random;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    //Общие данные-----------------------------------------------------------------//
    protected final String URL = "https://stellarburgers.nomoreparties.site/";
    protected final String LOGIN_URL = "https://stellarburgers.nomoreparties.site/login";
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

    //Данные для теста LoginTest and TransferConstructorFromAccountTest and LogoutTest//
    protected final String DEFAULT_EMAIL = "m.radyushin@yandex.ru";
    protected final String DEFAULT_PASSWORD = "PraktikumAPI";
    //--------------------------------------------------------------------------//

    //Данные для теста TransferPersonalAccountTest------------------------------//
    protected final String ACCOUNT_PROFILE_URL = "https://stellarburgers.nomoreparties.site/account/profile";
    //--------------------------------------------------------------------------//

    //Данные для ConstructorSectionTest-----------------------------------------//
    protected final static String BUNS = "Булки";
    protected final static String SAUCES = "Соусы";
    protected final static String FILLINGS = "Начинки";
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

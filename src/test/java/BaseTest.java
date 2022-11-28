import org.junit.Before;
import com.codeborne.selenide.Configuration;
import pageobject.*;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    final String DEFAULT_EMAIL = "m.radyushin@yandex.ru";
    final String DEFAULT_PASSWORD = "PraktikumAPI";
    final String URL = "https://stellarburgers.nomoreparties.site/";
    final String LOGIN_URL = "https://stellarburgers.nomoreparties.site/login";

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

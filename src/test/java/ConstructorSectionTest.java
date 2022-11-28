import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

public class ConstructorSectionTest extends BaseTest{

    @Test
    @DisplayName("Переход к разделу 'Булки'")
    @Description("Ожидаем открытие раздела 'Булки'")
    public void checkOpenBunsTab() {
        mainPage.clickSaucesTab();
        mainPage.clickBunsTab();
        mainPage.compareText(BUNS);
    }

    @Test
    @DisplayName("Переход к разделу 'Соусы'")
    @Description("Ожидаем открытие раздела 'Соусы'")
    public void checkOpenSaucesTab() {
        mainPage.clickSaucesTab();
        mainPage.compareText(SAUCES);
    }

    @Test
    @DisplayName("Переход к разделу 'Начинки'")
    @Description("Ожидаем открытие раздела 'Начинки'")
    public void checkOpenFillingsTab() {
        mainPage.clickFillingsTab();
        mainPage.compareText(FILLINGS);
    }
}
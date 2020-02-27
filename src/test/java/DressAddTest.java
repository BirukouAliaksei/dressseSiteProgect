import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class DressAddTest extends Fixture{
    MainPage mainPage;
    ProductPage productPage;

    @BeforeEach
    public void preCondition(){
        mainPage = new MainPage();
        productPage = new ProductPage();
    }

    @Test
    public void testProductInCart(){
        mainPage.sighIn();
        mainPage.addToCart();
        productPage.plusQtc();
        productPage.minusQtc();
    }

    @Test
    public void createAndDeleteProduct(){
        mainPage.sighIn();
        mainPage.addToCart();
        productPage.removeProduct();
    }

}

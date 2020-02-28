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
//        mainPage.sighIn();
        mainPage.addToCart();
        productPage.plusQtc();
        productPage.minusQtc();
        $(byId("summary_products_quantity"))
                .shouldHave(Condition.text("1 Product"));
    }

    @Test
    public void createAndDeleteProduct(){
//        mainPage.sighIn();
        mainPage.addToCart();
        productPage.removeProduct();
        $(byXpath("//*[@class='alert alert-warning']"))
                .shouldHave(Condition.text("Your shopping cart is empty."));
    }

}

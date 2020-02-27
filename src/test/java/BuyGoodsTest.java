import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class BuyGoodsTest extends Fixture{
    MainPage mainPage;
    ProductPage productPage;

    @BeforeEach
    public void preCondition(){
        mainPage = new MainPage();
        productPage = new ProductPage();
    }

    @Test
    public void buyGoodsTest(){
        mainPage.sighIn();
        mainPage.addToCart();
        productPage.aderessField();
        productPage.selectShipping();
        productPage.orderConfirmation();
        $(byXpath("//*[@class='cheque-indent']")).shouldHave(Condition.text("Your order on My Store is complete."));
    }
}

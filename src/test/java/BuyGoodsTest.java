import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.api.parallel.ResourceLock;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.clearBrowserCookies;

@Execution(ExecutionMode.CONCURRENT)
public class BuyGoodsTest extends Fixture{
    MainPage mainPage;
    ProductPage productPage;

    @BeforeEach
    public void preCondition(){
        mainPage = new MainPage();
        productPage = new ProductPage();
        mainPage.sighIn();
    }

    @Test
    public void buyGoodsTest(){
        mainPage.addToCart();
        productPage.aderessField();
        productPage.selectShipping();
        productPage.orderConfirmation();
        $(byXpath("//*[@class='cheque-indent']"))
                .shouldHave(Condition.text("Your order on My Store is complete."));
    }

    @AfterEach
    public void afterCondition() {
        mainPage.signOutBtn();
        clearBrowserCookies();
    }

}

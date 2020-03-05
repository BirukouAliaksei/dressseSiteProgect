import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Description;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

@Execution(ExecutionMode.CONCURRENT)
public class DressAddTest extends Fixture{
    MainPage mainPage;
    ProductPage productPage;

    @BeforeEach
    public void preCondition(){
        mainPage = new MainPage();
        productPage = new ProductPage();
    }

//    @Description(value = "Quantity change products In Cart")
    @Test
    public void testProductInCart(){
        mainPage.addToCart();
        productPage.plusQtc();
        $(byId("summary_products_quantity"))
                .shouldHave(Condition.text("2 Product"));
        productPage.minusQtc();
        $(byId("summary_products_quantity"))
                .shouldHave(Condition.text("1 Product"));
    }

    @Description(value = "Create And Delete Product in Cart")
    @Test
    public void createAndDeleteProduct(){
        mainPage.addToCart();
        productPage.removeProduct();
        $(byXpath("//*[@class='alert alert-warning']"))
                .shouldHave(Condition.text("Your shopping cart is empty."));
    }


}

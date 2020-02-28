import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

public class ProductPage {
    public SelenideElement confirmPayment = $(byXpath("//*[@class='button btn btn-default button-medium']"));

    public ProductPage aderessField(){
        $(byXpath("//*[@class='cart_navigation clearfix']//*[@title='Proceed to checkout']")).click();
        $(byName("message")).setValue("Continue with standart adress");
        $(byName("processAddress")).click();
        $(byXpath("//*[@class='step_current four']")).shouldHave(Condition.text("Shipping"));
        return this;
    }

    public ProductPage selectShipping(){
        $(byId("cgv")).click();
        $(byName("processCarrier")).click();
        $(byId("step_end")).shouldHave(Condition.text("Payment"));
        return this;
    }

    public ProductPage orderConfirmation(){
        $(byXpath("//*[@title='Pay by bank wire']")).click();
        confirmPayment.click();
        return this;
    }

    public ProductPage minusQtc(){
        $(byXpath("//*[@class='cart_quantity text-center']//*[@class='icon-minus']")).click();
        return this;
    }

    public ProductPage plusQtc(){
        $(byXpath("//*[@class='cart_quantity text-center']//*[@class='icon-plus']")).click();
        return this;
    }

    public ProductPage removeProduct(){
        $(byXpath("//*[@title='Delete']")).click();
        return this;
    }
}

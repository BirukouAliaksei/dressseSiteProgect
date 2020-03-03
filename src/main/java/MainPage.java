import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.util.Random;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    public SelenideElement dressesBtn = $(byXpath("//*[@id='block_top_menu']/ul/li[2]/a"));
    public SelenideElement addToCard = $(byXpath("//*[@id='center_column']/ul/li[1]/div/div[2]/div[2]/a[1]/span"));
    public SelenideElement hoverOnElement = $(byXpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li[1]/div/div[1]/div/a[1]/img"));


    public MainPage searchForm(String value){
        $(byId("search_query_top")).setValue(value).pressEnter();
        return this;
    }

    public void newsletter(String email){
        $(byId("newsletter-input")).setValue(email).pressEnter();
    }

    public MainPage clickLogoButon(){
        return this;
    }

    public MainPage sighIn(){
        $(byXpath("//*[@class='login']")).click();
        $(byId("email")).setValue("seleniums@gmail.com");
        $(byId("passwd")).setValue("y@7cAsezZEjgTjL");
        $(byId("SubmitLogin")).click();
        $(byId("header_logo")).click();
        return this;
    }

    public MainPage addToCart(){
        $("#block_top_menu > ul > li:nth-child(2) > a").click();
        dressesBtn.click();
        hoverOnElement.hover();
        addToCard.click();
        $(byXpath("//*[@title='Proceed to checkout']")).click();
//        $(byId("summary_products_quantity")).shouldHave(Condition.text("1 Product"));
        return this;
    }

    public MainPage contactUs(String email, String message){
        $(byXpath("//*[@title='Contact Us']")).click();
        $(byId("id_contact")).click();
        $(byXpath("//*[@id='id_contact']/option[2]")).click(); // не нажимается
        $(byId("email")).setValue(email);
        $(byId("message")).setValue(message);
        $(byId("submitMessage")).click();
        return this;
    }

    protected String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }

    public MainPage signOutBtn(){
        $(byXpath("//*[@class='logout']")).click();
        return this;
    }


}

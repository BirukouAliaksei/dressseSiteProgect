import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class MainPageTest extends Fixture {
    MainPage mainPage;

    @BeforeEach
    public void preCondition(){
        mainPage = new MainPage();
    }

    @Test
    public void sighInOnSite(){
        mainPage.sighIn();
    }

    @Test
    public void search(){
        mainPage.searchForm("Dresses");
        $("h1.page-heading.product-listing").shouldHave(Condition.text("Dresses"));
    }

    @Test
    public void sentNewsletter(){
       mainPage.newsletter("aleeksss@gmail.com");
       $(byXpath("//*[@class='alert alert-success']"))
               .shouldHave(Condition.text("You have successfully subscribed to this newsletter"));
    }

    @Test
    public void contactUsTest(){
        mainPage.contactUs("asdddd@gadf.com", "smt message");
        $(byXpath("//*[@class='alert alert-success']")).shouldHave(Condition.text("Your message has been successfully sent to our team."));
    }

}

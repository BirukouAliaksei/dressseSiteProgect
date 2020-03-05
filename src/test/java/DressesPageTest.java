import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

@Execution(ExecutionMode.CONCURRENT)
public class DressesPageTest extends Fixture{

    DressesPage dressesPage;

    @BeforeEach
    public void preCondition() {
        dressesPage = new DressesPage();
    }

    @Test
    public void chooseCasualDress() {
       dressesPage.selectCasualDress();
       $(byXpath("//*[@class='cat-name']"))
               .shouldHave(Condition.text("Casual Dresses"));
    }

    @Test
    public void  chooseEveninglDress() {
        dressesPage.selectEveninglDress();
        $(byXpath("//*[@class='cat-name']"))
                .shouldHave(Condition.text("Evening Dresses"));
    }

    @Test
    public void  chooseSummerDress() {
       dressesPage.selectSummerDress();
        $(byXpath("//*[@class='cat-name']"))
                .shouldHave(Condition.text("Summer Dresses"));
    }
}
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class DressesPage {


    public DressesPage selectCasualDress(){
        $("#block_top_menu > ul > li:nth-child(2) > a").click();
        $(byXpath("//*[@id='subcategories']/ul/li[1]/div[1]")).click();
        return this;
    }

    public DressesPage selectEveninglDress(){
        $("#block_top_menu > ul > li:nth-child(2) > a").click();
        $(byXpath("//*[@id='subcategories']/ul/li[2]/div[1]")).click();
        return this;
    }

    public DressesPage selectSummerDress(){
        $("#block_top_menu > ul > li:nth-child(2) > a").click();
        $(byXpath("//*[@id='subcategories']/ul/li[3]/div[1]")).click();
        return this;
    }

    public DressesPage addToCaompare(String value){
        $(value).click();
        return this;
    }



}

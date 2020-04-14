package PageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class HomePage {

    private SelenideElement top250Button = $(By.xpath("//a[@href='/top/' and @class='_23NhxxXRQISbMcHJkDhY5B']"));
    private SelenideElement advanceSearchButton = $(By.xpath("//a[@href='/s/']"));
    private List<SelenideElement> pngImages = $$(By.xpath("//img[contains(@src, '.jpg')]"));

    public HomePage open()
    {
        Selenide.open(Configuration.baseUrl);
        return this;
    }

    public Top250Page goToTop250()
    {
        top250Button.shouldBe(Condition.visible);
        top250Button.click();

        return new Top250Page();
    }

    public AdvanceSearch goToAdvanceSearch()
    {
        advanceSearchButton.click();

        return new AdvanceSearch();
    }

    public List<SelenideElement> getJpgImages()
    {
        return pngImages;
    }
}

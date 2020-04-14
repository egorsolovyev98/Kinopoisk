package PageObjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;

public class AdvanceSearch {

    private SelenideElement countryDropDown = $(By.xpath("//*[@id='country']"));
    private SelenideElement searchButton = $(By.xpath("//input[@class='el_18 submit nice_button']"));
    private String genreMask = "//*[@id='m_act[genre]']/option[text()='%s']";
    private SelenideElement mostWantedFilm = $(By.xpath("//div[@class='element most_wanted']//div[@class='info']/p/a"));

    public AdvanceSearch selectCountry(String country)
    {
        countryDropDown.click();
        $(By.xpath(String.format("//*[@id='country']/option[text()='%s']", country))).scrollTo().click();
        return this;
    }

    public AdvanceSearch performSearch()
    {
        // Selenid scroll bug workaround
        $(By.xpath("//a[@href='/level/20/']")).scrollTo();

        searchButton.click();
        return this;
    }

    public AdvanceSearch selectManyGenres(List<String> genres)
    {
        for (String genre: genres) {
            actions().keyDown(Keys.CONTROL);
            $(By.xpath(String.format(genreMask, genre))).scrollTo().click();
            actions().keyUp(Keys.CONTROL);
        }

        return this;
    }

    public SelenideElement getMostWantedFilm()
    {
        return mostWantedFilm;
    }
}

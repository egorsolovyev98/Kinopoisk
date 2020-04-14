package PageObjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Top250Page {

    private List<SelenideElement> numberOfVotes = $$(By.xpath("//a[@class='continue']/../span[1]"));
    private SelenideElement filmYearDropDown = $(By.xpath("//select[@name='y']"));
    private List<SelenideElement> filmsRating = $$(By.xpath("//a[@class='continue']"));

    public Top250Page selectFilmYear(int year)
    {
        filmYearDropDown.click();
        $(By.xpath(String.format("//select[@name='y']//option[@value='/top/y/%2d/']", year))).click();

        return this;
    }

    public List<SelenideElement> getNumberOfVotes()
    {
        return numberOfVotes;
    }

    public List<SelenideElement> getFilmsRating()
    {
        return filmsRating;
    }
}

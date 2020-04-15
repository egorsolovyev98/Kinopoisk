package Steps;

import PageObjects.AdvanceSearch;
import PageObjects.HomePage;
import Utils.Converter;
import com.codeborne.selenide.SelenideElement;

import java.util.List;
import java.util.stream.Collectors;

public class Steps {

    HomePage homePage = new HomePage();
    AdvanceSearch advanceSearch = new AdvanceSearch();

    public List<Integer> getVotesList()
    {
        List<String> votes = homePage.open().goToTop250().getNumberOfVotes().stream()
                .map(SelenideElement::getText).collect(Collectors.toList());

        return votes.stream().map(s -> Converter.parseInt(s)).collect(Collectors.toList());
    }

    public int getNumberOf100kVotedFilms()
    {
        return getVotesList().stream().filter(s -> s > 100000).collect(Collectors.toList()).size();
    }

    public int getNumberOfJpgImages()
    {
        return homePage.open().getJpgImages().size();
    }

    public double getMedianRatingByYear(int year)
    {
        List<Double> ratings = homePage.open().goToTop250().selectFilmYear(year).getFilmsRating().stream()
                .map(s -> Double.parseDouble(s.getText())).collect(Collectors.toList());
        return ratings.stream().mapToDouble(s -> s).average().getAsDouble();
    }

    public void performAdvanceSearch(String country, List<String> genres)
    {
        homePage.open().goToAdvanceSearch().selectCountry(country).selectManyGenres(genres).performSearch();
    }

    public String getMostWantedFilm()
    {
        return advanceSearch.getMostWantedFilm().getText();
    }
}

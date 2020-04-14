package kinopoiskSearchTests;

import Steps.Steps;
import com.codeborne.selenide.testng.ScreenShooter;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

@Listeners({ScreenShooter.class})
public class SearchTests extends BaseTest{

    Steps steps = new Steps();

    @Test
    public void countNumberOfJpg()
    {
        final int expectedNumberOfImages = 5;
        Assert.assertTrue(steps.getNumberOfJpgImages() >= expectedNumberOfImages);
    }

    @Test
    public void countNumberOf100kVotesFilms()
    {
        final int expectedNumberOf100kVotesFilms = 30;
        int actualNumberOf100kVotedFilms = steps.getNumberOf100kVotedFilms();
        Assert.assertEquals(actualNumberOf100kVotedFilms, expectedNumberOf100kVotesFilms);
    }

    @Test
    public void compareFilmRating()
    {
        double average2010Rating = steps.getMedianRatingByYear(2010);
        double average2019Rating = steps.getMedianRatingByYear(2019);
        Assert.assertTrue(average2010Rating > average2019Rating);
    }

    @Test
    public void performAdvancedSearch()
    {
        final String country = "СССР";
        final List<String> genres = Arrays.asList("документальный", "история", "семейный");
        final String expectedFilm = "Винни Пух";

        steps.performAdvanceSearch(country, genres);
        String actualFilm = steps.getMostWantedFilm();

        Assert.assertEquals(actualFilm, expectedFilm);
    }
}

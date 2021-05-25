package stepsDefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.XkcdModel;
import net.thucydides.core.annotations.Steps;
import response.GeneralResponse;
import stepsImplementation.StepsImplementation;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static utils.Constants.COMIC_ID_AND_INFO;
import static utils.Constants.INFO;

public class StepsDefinition {

    @Steps
    private StepsImplementation stepsImplementation;

    @When("the user calls for current comic")
    public void setCurrentComicResponse() {
        GeneralResponse.setResponse(stepsImplementation.getCurrentComic(INFO).orElse(null));
    }

    @When("the user calls for comic number by comicId using current comic id")
    public void setComicNumberResponseFromFile() {
        GeneralResponse.setModelResponse(GeneralResponse.getResponse().as(XkcdModel.class));
        String comicNumberParam = String.valueOf(GeneralResponse.getModelResponse().getNUM());
        GeneralResponse.setResponse(stepsImplementation.getCurrentComicById(COMIC_ID_AND_INFO, comicNumberParam).orElse(null));
    }

    @When("the user calls for {} comic number endpoint")
    public void setComicNumberResponse(String comicId) {
        GeneralResponse.setResponse(stepsImplementation.getCurrentComicById(COMIC_ID_AND_INFO, comicId).orElse(null));
    }

    @Then("the status code is {}")
    public void assertStatusCode(int statusCode) {
        assertThat(GeneralResponse.getResponse().getStatusCode(), is(statusCode));
    }

    @Then("the response contains same data as current comic")
    public void theResponseIsEqualToObjectFromFile() {
        XkcdModel expectedResponse = GeneralResponse.getModelResponse();
        XkcdModel actualResponse = GeneralResponse.getResponse().as(XkcdModel.class);
        assertEquals(actualResponse, expectedResponse);
    }

    @Then("the response matches comic data type")
    public void theResponseMatchesComicDataType() {
        assertTrue("Response doesn't match data type",
                stepsImplementation.responseMatchesComicDataType());

    }
}

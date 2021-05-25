package stepsImplementation;

import io.restassured.response.Response;
import model.XkcdModel;
import response.GeneralResponse;
import utils.Utils;

import java.util.Optional;

public class StepsImplementation {

    public Optional<Response> getCurrentComic(String url) {

        return Utils.getCurrentComicResponse(url);
    }

    public Optional<Response> getCurrentComicById(String url, String paramValue) {
        return Utils.getCurrentComicResponseById(url, paramValue);
    }

    public boolean responseMatchesComicDataType() {
        try {
            GeneralResponse.getResponse().as(XkcdModel.class);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

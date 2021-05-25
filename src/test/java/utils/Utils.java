package utils;

import io.restassured.response.Response;

import java.util.Optional;

import static rest.CommonSpec.spec;
import static utils.Constants.COMIC_ID;


public class Utils {

    private Utils() {
    }

    public static Optional<Response> getCurrentComicResponse(String url) {
        return Optional.of(spec().get(url));
    }

    public static Optional<Response> getCurrentComicResponseById(String url, String paramValue) {
        return Optional.of(spec().pathParam(COMIC_ID, paramValue).get(url));
    }

}
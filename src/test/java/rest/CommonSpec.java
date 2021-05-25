package rest;

import config.Configuration;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static net.serenitybdd.rest.SerenityRest.rest;

public final class CommonSpec {
    private CommonSpec() {
    }

    public static RequestSpecification spec() {
        return rest()
                .baseUri(Configuration.URI)
                .contentType(ContentType.JSON)
                .when();
    }
}

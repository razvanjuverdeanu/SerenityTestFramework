package response;

import io.restassured.response.Response;
import lombok.Getter;
import lombok.Setter;
import model.XkcdModel;


public final class GeneralResponse {

    @Getter
    @Setter
    private static Response response;

    @Getter
    @Setter
    private static XkcdModel modelResponse;

}
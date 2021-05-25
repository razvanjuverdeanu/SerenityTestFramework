package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class XkcdModel {

    private String ALT;

    private String DAY;

    private String IMG;

    private String LINK;

    private String MONTH;

    private String NEWS;

    private Integer NUM;

    @JsonProperty("safe_title")
    private String SAFE_TITLE;

    private String TITLE;

    private String TRANSCRIPT;

    private String YEAR;

}

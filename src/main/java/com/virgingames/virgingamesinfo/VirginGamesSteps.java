package com.virgingames.virgingamesinfo;

import com.virgingames.constants.EndPoints;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class VirginGamesSteps {
    @Step("Get all the Jackpot records ")
    public ValidatableResponse getJackpotInfo()
    {
        return SerenityRest.given()
                .when()
                .get(EndPoints.GET_ALL_JACKPOT)
                .then();
    }

    @Step("Get all the jackpots whose currency is EUR")
    public ValidatableResponse getEURJackpotInfo()
    {
        return SerenityRest.given()
                .queryParam("currency","EUR")
                .when()
                .get(EndPoints.GET_ALL_JACKPOT)
                .then();
    }
}

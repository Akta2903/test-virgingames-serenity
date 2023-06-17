package com.virgingames.virgninfo;

import com.virgingames.testbase.TestBase;
import com.virgingames.virgingamesinfo.VirginGamesSteps;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;

import static org.hamcrest.Matchers.hasEntry;

@RunWith(SerenityRunner.class)
public class VirginGamesGetRequestTest extends TestBase {
    static ValidatableResponse response;
    @Steps
    VirginGamesSteps virginGamesSteps;




    @WithTag("virgingames:SMOKE")
    @Title("Get all the Jackpot info whose currency is Euro")
    @Test
    public void test001()
    {
        response = virginGamesSteps.getEURJackpotInfo();
       response.statusCode(200).log().all();

    }

    @WithTag("virgingames:REGRESSION")
    @Title("Verify id: 194 has currency:EUR and name:Adventure")
    @Test
    public void test002()
    {
        response = virginGamesSteps.getEURJackpotInfo();
        response.statusCode(200).log().all();
        HashMap<String,?> jackpotMap = response.extract().path("data.pots[0]");
        Assert.assertThat(jackpotMap,hasEntry("currency","EUR"));
        Assert.assertThat(jackpotMap,hasEntry("name","Adventure"));

    }
}

package tests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class RestCountriesAPITest extends BaseRestCountriesTest {

    @Test
    public void getAllCountriesTest() {
        // Get all countries
        given().log().all().
                when().
                get("/all").
                then().
                statusCode(200).
                contentType("application/json");
    }


    @DataProvider
    public Object[][] countryDataProvider() {
        return new Object[][]{
                {"Romania", "RON", "lei"},
                {"France", "EUR", "€"},
                {"South Africa", "ZAR", "R"}
        };
    }

    @Test(dataProvider = "countryDataProvider")
    public void getCountryByNameTest(String countryName, String currencyCode, String currencySymbol) {
        // Get country by name
        Response reponse = given().
                when().
                queryParam("fullText", true).
                get("name/{name}", countryName).
                then().
                statusCode(200).
                contentType("application/json").
                body("currencies[0]." + currencyCode + ".symbol", equalTo(currencySymbol)).
                extract().response();

//        System.out.println("Headers:" + reponse.getHeaders().toString());
        System.out.println("Verify that 'Connection' has value of keep-alive in headers");
        Assert.assertEquals(reponse.getHeaders().get("Connection").getValue(), "keep-alive");

        System.out.println("Verify that return country name is " + countryName);
        JsonPath responseJson = reponse.getBody().jsonPath();
        Assert.assertEquals(responseJson.get("name.common[0]"), countryName);
    }

    @Test
    public void verifyRomaniaBorders() {
        String countryName = "Romania";
        List<String> expectedBorders = Arrays.asList("HUN", "MDA", "SRB", "UKR", "BGR");
        List<String> borders = new ArrayList<>(given().
                when().
                queryParam("fullText", true).
                get("name/{name}", countryName).
                then().
                statusCode(200).
                contentType("application/json").extract().response().getBody().jsonPath().getList("borders[0]", String.class));

        borders.sort(Comparator.naturalOrder());
        expectedBorders.sort(Comparator.naturalOrder());
        Assert.assertEquals(borders, expectedBorders);
    }

}

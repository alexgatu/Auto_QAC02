package tests;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import utils.APIServicesNames;

public class BaseRestCountriesTest extends BaseControllerTest {

    @BeforeClass
    public void setUp() {
      super.getBaseURL(APIServicesNames.RESTCOUNTRIES);
      System.out.println("Use this baseurl for rest countries:" + baseURL);
    //set baseURI for restassured
      setRestAssuredBaseURI();
    }
}

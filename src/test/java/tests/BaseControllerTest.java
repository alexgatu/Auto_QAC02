package tests;

import io.restassured.RestAssured;
import utils.APIServicesNames;
import utils.ConfigUtils;
import utils.ConstantUtils;

public class BaseControllerTest {
    String baseURL;

    public void getBaseURL(APIServicesNames service) {
        getBaseURL(ConstantUtils.DEFAULT_CONFIG_FILE, service);
    }

    public void getBaseURL(String configFileName, APIServicesNames service) {
        if(service == APIServicesNames.RESTCOUNTRIES) {
            baseURL = ConfigUtils.readGenericElementFromConfig(configFileName, "restcountries.base.url");
        } else if(service == APIServicesNames.PETSTORE) {
            baseURL = ConfigUtils.readGenericElementFromConfig(configFileName, "petstore.base.url");
        }
    }

    public void setRestAssuredBaseURI() {
        RestAssured.baseURI = baseURL;
        RestAssured.useRelaxedHTTPSValidation();
    }
}

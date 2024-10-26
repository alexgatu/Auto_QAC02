package tests;

import org.testng.annotations.BeforeClass;
import utils.APIServicesNames;

public class BasePetStoreTest extends BaseControllerTest {
    @BeforeClass
    public void setUp() {
        super.getBaseURL(APIServicesNames.PETSTORE);
        System.out.println("Use this baseurl for rest countries:" + baseURL);
        setRestAssuredBaseURI();
    }
}

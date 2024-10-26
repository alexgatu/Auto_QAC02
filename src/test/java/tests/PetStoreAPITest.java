package tests;

import ObjectModels.Category;
import ObjectModels.Pet;
import ObjectModels.Tag;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class PetStoreAPITest extends BasePetStoreTest {
    Pet pet;

    @BeforeTest
    public void prepareTest() {
        pet = new Pet(11, new Category(1, "dog"), "Zorro", List.of("https://www.google.com"),
                List.of(new Tag(1, "tag1")), "available");
    }

    @Test
    public void addNewPetOnStore() {
        Pet addedPet = given().log().all().
                header("Content-Type", "application/json").
                header("Accept", "application/json").
                when().
                body(pet).
                post("/pet").
                then().
                statusCode(200).extract().body().jsonPath().getObject("", Pet.class);

        System.out.println("Added pet:" + addedPet);
        Assert.assertEquals(addedPet.toString(), pet.toString());
    }

    @Test(dependsOnMethods = "addNewPetOnStore")
    public void getPetById() {
        Pet extractPet = given().
                header("Accept", "application/json").
                when().
                get("/pet/{petId}", 11).
                then().
                statusCode(200).extract().body().jsonPath().getObject("", Pet.class);

        System.out.println("Pet by id:" + pet);
        Assert.assertEquals(pet.toString(), extractPet.toString());
    }

    @Test(dependsOnMethods = "addNewPetOnStore")
    public void findPetByStatus() {
        List<Pet> extractPetList = given().log().all().
                header("Accept", "application/json").
                queryParam("status", "available").
                when().
                get("/pet/findByStatus").
                then().
                statusCode(200).extract().body().jsonPath().getList("", Pet.class);

        Assert.assertTrue(isPetInList(extractPetList, pet));
    }

    private boolean isPetInList(List<Pet> petList, Pet pet) {
        for (Pet p : petList) {
            if (p.getId() == pet.getId()) {
                return true;
            }
        }
        return false;
    }

}

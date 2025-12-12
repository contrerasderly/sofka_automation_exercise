package com.automationexercise.stepdefinitions;

import com.automationexercise.api.models.Pet;
import com.automationexercise.api.questions.LastResponse;
import com.automationexercise.api.tasks.ConsultAndValidatePet;
import com.automationexercise.api.tasks.CreatePet;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

public class PetStoreApiStepDefinitions {

    private Actor derly = Actor.named("Derly");
    private long createdPetId;

    @Before
    public void setup() {
        derly.whoCan(CallAnApi.at("https://petstore.swagger.io/v2"));
    }

    @Given("Derly is an API user")
    public void derly_is_api_user() {
        // SetUp already done
    }

    @When("she creates a new pet")
    public void she_creates_new_pet() {
        Pet newPet = Pet.getPetData();

        derly.attemptsTo(
                CreatePet.withDetails(newPet)
        );

        Response response = LastResponse.received().answeredBy(derly);
        createdPetId = response.jsonPath().getLong("id");
    }

    @Then("the response status should be {int}")
    public void validate_status_code(int expectedStatus) {
        derly.attemptsTo(
                Ensure.that(LastResponse.received().answeredBy(derly)
                        .statusCode()).isEqualTo(expectedStatus)
        );
    }

    @When("she retrieves the pet by id")
    public void she_retrieves_pet_by_id() {
        derly.attemptsTo(
                ConsultAndValidatePet.byId(createdPetId)
        );
    }

    @Then("the pet should be returned successfully")
    public void validate_pet_returned() {
        derly.attemptsTo(
                Ensure.that(LastResponse.received().answeredBy(derly)
                        .jsonPath().getLong("id")).isEqualTo(createdPetId)
        );
    }
}
package com.automationexercise.stepdefinitions;

import com.automationexercise.web.questions.SuccessMessage;
import com.automationexercise.web.tasks.NavigateToHome;
import com.automationexercise.web.tasks.SubmitContactForm;
import com.automationexercise.web.ui.MenuPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class ContactUsStepDefinitions {

    private Actor derly = Actor.named("Derly");
    private WebDriver driver;

    @Before
    public void setup() {
        driver = Serenity.getDriver();
        derly.can(BrowseTheWeb.with(driver));
    }

    @Given("Derly opens the AutomationExercise homepage")
    public void openAutomationExerciseHome() {
        derly.attemptsTo(Open.browserOn().the(MenuPage.class));
    }

    @When("he navigates to the Contact Us section")
    public void navigateToContactUs() {
        derly.attemptsTo(
                Click.on(MenuPage.CONTACT_US_MENU)
        );
    }

    @When("he submits the contact form with:")
    public void submitContactForm(Map<String, String> data) {
        derly.attemptsTo(
                SubmitContactForm.withDetails(
                        data.get("name"),
                        data.get("email"),
                        data.get("subject"),
                        data.get("message"),
                        new File(data.get("file"))
                )
        );
    }

    @Then("the success message should be displayed")
    public void successMessageShouldBeDisplayed() {
        assertTrue("Success message was not visible",
                SuccessMessage.isVisible().answeredBy(derly)
        );
    }

    @Then("he navigates back to the home page")
    public void navigateBackHome() {
        derly.attemptsTo(NavigateToHome.page());
    }
}
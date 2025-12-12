package com.automationexercise.web.questions;

import com.automationexercise.web.ui.ContactUsPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class SuccessMessage implements Question<Boolean> {

    public static SuccessMessage isVisible() {
        return new SuccessMessage();
    }

    @Step("Verify that the success message is visible")
    public Boolean answeredBy(Actor actor) {
        return ContactUsPage.SUCCESS_MESSAGE
                .resolveFor(actor)
                .waitUntilVisible()
                .isVisible();
    }
}
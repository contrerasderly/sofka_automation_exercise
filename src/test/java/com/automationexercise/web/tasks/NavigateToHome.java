package com.automationexercise.web.tasks;

import com.automationexercise.web.ui.ContactUsPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class NavigateToHome implements Task {

    @Step("{0} returns to the home page")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(ContactUsPage.HOME_BACK)
        );
    }

    public static NavigateToHome page() {
        return instrumented(NavigateToHome.class);
    }
}
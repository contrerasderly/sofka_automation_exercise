package com.automationexercise.api.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ConsultAndValidatePet implements Task {

    private final long petId;

    public ConsultAndValidatePet(long petId) {
        this.petId = petId;
    }

    public static ConsultAndValidatePet byId(long petId) {
        return instrumented(ConsultAndValidatePet.class, petId);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource("/pet/" + petId)
        );
    }
}
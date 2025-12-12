package com.automationexercise.api.tasks;

import com.automationexercise.api.models.Pet;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CreatePet implements Task {

    private final Pet pet;

    public CreatePet(Pet pet) {
        this.pet = pet;
    }

    public static CreatePet withDetails(Pet pet) {
        return instrumented(CreatePet.class, pet);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to("/pet")
                        .with(request -> request
                                .header("Content-Type", "application/json")
                                .body(pet)
                        )
        );
    }
}
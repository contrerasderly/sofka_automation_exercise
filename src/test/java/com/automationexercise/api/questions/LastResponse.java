package com.automationexercise.api.questions;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class LastResponse implements Question<Response> {

    public static LastResponse received() {
        return new LastResponse();
    }

    @Override
    public Response answeredBy(Actor actor) {
        return SerenityRest.lastResponse();
    }
}
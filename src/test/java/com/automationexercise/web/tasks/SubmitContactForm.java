package com.automationexercise.web.tasks;

import com.automationexercise.web.ui.ContactUsPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.actions.Upload;

import java.io.File;

public class SubmitContactForm implements Task {

    private final String name;
    private final String email;
    private final String subject;
    private final String message;
    private final File file;

    public SubmitContactForm(String name, String email, String subject, String message, File file) {
        this.name = name;
        this.email = email;
        this.subject = subject;
        this.message = message;
        this.file = file;
    }

    public static SubmitContactForm withDetails(String name, String email, String subject, String message, File file) {
        return Tasks.instrumented(SubmitContactForm.class, name, email, subject, message, file);
    }

    @Step("{0} submits the contact form")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(name).into(ContactUsPage.NAME),
                Enter.theValue(email).into(ContactUsPage.EMAIL),
                Enter.theValue(subject).into(ContactUsPage.SUBJECT),
                Enter.theValue(message).into(ContactUsPage.MESSAGE),
                Upload.theFile(file.toPath()).to(ContactUsPage.UPLOAD),
                Click.on(ContactUsPage.SUBMIT),
                Switch.toAlert().andAccept()
        );
    }
}
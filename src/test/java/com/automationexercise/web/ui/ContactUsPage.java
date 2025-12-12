package com.automationexercise.web.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class ContactUsPage extends PageObject {

    public static final Target NAME = Target.the("name field")
            .locatedBy("//input[@data-qa='name']");

    public static final Target EMAIL = Target.the("email field")
            .locatedBy("//input[@data-qa='email']");

    public static final Target SUBJECT = Target.the("subject field")
            .locatedBy("//input[@data-qa='subject']");

    public static final Target MESSAGE = Target.the("message field")
            .locatedBy("//textarea[@data-qa='message']");

    public static final Target UPLOAD = Target.the("upload file")
            .locatedBy("//input[@name='upload_file']");

    public static final Target SUBMIT = Target.the("submit button")
            .locatedBy("//input[@data-qa='submit-button']");

    public static final Target HOME_BACK = Target.the("Home button")
            .locatedBy("//a[@href='/']");

    public static final Target SUCCESS_MESSAGE = Target.the("success message")
            .locatedBy("//div[contains(text(),'Success!')]");
}
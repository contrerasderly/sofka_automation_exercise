package com.automationexercise.web.ui;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

@DefaultUrl("https://automationexercise.com/")
public class MenuPage extends PageObject {

    public static final Target HOME_MENU = Target.the("Home link")
            .locatedBy("//a[contains(text(), 'Home')]");

    public static final Target CONTACT_US_MENU = Target.the("Contact Us link")
            .locatedBy("//a[contains(text(), 'Contact us')]");
}
package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class DemoqaTextBoxPage {

    private final SelenideElement fullName = $("#userName");
    private final SelenideElement email = $("#userEmail");
    private final SelenideElement currentAddress = $("#currentAddress");
    private final SelenideElement permanentAddress = $("#permanentAddress");
    private final SelenideElement submitButton = $("#submit");
    private final SelenideElement outputName = $("#output #name");
    private final SelenideElement outputEmail = $("#output #email");
    private final SelenideElement outputCurrentAddress = $("#output #currentAddress");
    private final SelenideElement outputPermanentAddress = $("#output #permanentAddress");

    public DemoqaTextBoxPage openPage() {
        open("/text-box");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public DemoqaTextBoxPage setFullName(String value) {
        fullName.setValue(value);

        return this;
    }

    public DemoqaTextBoxPage setEmail(String value) {
        email.setValue(value);

        return this;
    }

    public DemoqaTextBoxPage setCurrentAddress(String value) {
        currentAddress.setValue(value);

        return this;
    }

    public DemoqaTextBoxPage setPermanentAddress(String value) {
        permanentAddress.setValue(value);

        return this;
    }

    public DemoqaTextBoxPage submitForm() {
        submitButton.click();

        return this;
    }

    public DemoqaTextBoxPage checkOutputName(String value) {
        outputName.shouldHave(text(value));

        return this;
    }

    public DemoqaTextBoxPage checkOutputEmail(String value) {
        outputEmail.shouldHave(text(value));

        return this;
    }

    public DemoqaTextBoxPage checkOutputCurrentAddress(String value) {
        outputCurrentAddress.shouldHave(text(value));

        return this;
    }

    public DemoqaTextBoxPage checkOutputPermanentAddress(String value) {
        outputPermanentAddress.shouldHave(text(value));

        return this;
    }
}
package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultsWindowComponent {

    private final SelenideElement window = $(".modal-content");
    private final SelenideElement windowHeader = $(".modal-header");
    private final SelenideElement table = $(".table");
    private final SelenideElement tableHeader = $(".table>thead>tr>th");

    public boolean isVisible() {
        return window.isDisplayed();
    }

    public void checkWindowHeader(String value) {
        windowHeader.shouldHave(text(value));
    }

    public void checkTableHeader(String key, String value) {
        tableHeader.shouldHave(text(key));
        tableHeader.parent().shouldHave(text(value));
    }

    public void checkTableContent(String key, String value) {
        table.$(byText(key)).parent().shouldHave(text(value));
    }
}
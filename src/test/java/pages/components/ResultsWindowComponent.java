package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultsWindowComponent {

    public final SelenideElement window = $(".modal-content");
    public final SelenideElement windowHeader = $(".modal-header");
    public final SelenideElement table = $(".table");
    public final SelenideElement tableHeader = $(".table>thead>tr>th");

    public void isVisible() {
        window.shouldBe(visible);
    }

    public void isHidden() {
        window.shouldBe(hidden);
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
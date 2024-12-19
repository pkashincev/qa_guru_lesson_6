package tests;

import org.junit.jupiter.api.Test;
import pages.DemoqaTextBoxPage;

public class DemoqaTextBoxWithPageObjectsTests extends DemoqaFormBase {

    private final DemoqaTextBoxPage page = new DemoqaTextBoxPage();

    @Test
    void fillFormTest() {
        page.openPage()
                .removeBanners()
                .setFullName("Pavel Kashintsev")
                .setEmail("test@email.com")
                .setCurrentAddress("...some current address...")
                .setPermanentAddress("...some permanent address...")
                .submitForm();

        page.checkOutputName("Pavel Kashintsev")
                .checkOutputEmail("test@email.com")
                .checkOutputCurrentAddress("...some current address...")
                .checkOutputPermanentAddress("...some permanent address...");
    }
}
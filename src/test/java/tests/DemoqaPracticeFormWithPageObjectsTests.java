package tests;

import org.junit.jupiter.api.Test;
import pages.DemoqaPracticeFormPage;

public class DemoqaPracticeFormWithPageObjectsTests extends DemoqaFormBase {

    private final DemoqaPracticeFormPage page = new DemoqaPracticeFormPage();

    @Test
    void fullCompletionFormTest() {
        page.openPage()
                .setFirstName("Pavel")
                .setLastName("Kashintsev")
                .setEmail("adress@test.com")
                .setGender("Male")
                .setMobileNumber("0123456789")
                .setDateOfBirth("29", "May", "1990")
                .setSubjects("Chemistry", "Math")
                .setHobbies("Reading", "Music")
                .uploadFileFromClasspath("picture.jpg")
                .setCurrentAddress("...some address...")
                .setState("Haryana")
                .setCity("Karnal")
                .submitForm();

        page.checkVisibilityOfResultsWindow(true)
                .checkHeaderOfResultsWindow("Thanks for submitting the form")
                .checkHeaderOfResultsTable("Label", "Values")
                .checkContentOfResultsTable("Student Name", "Pavel Kashintsev")
                .checkContentOfResultsTable("Student Email", "adress@test.com")
                .checkContentOfResultsTable("Gender", "Male")
                .checkContentOfResultsTable("Mobile", "0123456789")
                .checkContentOfResultsTable("Date of Birth", "29 May,1990")
                .checkContentOfResultsTable("Subjects", "Chemistry, Maths")
                .checkContentOfResultsTable("Hobbies", "Reading, Music")
                .checkContentOfResultsTable("Picture", "picture.jpg")
                .checkContentOfResultsTable("Address", "...some address...")
                .checkContentOfResultsTable("State and City", "Haryana Karnal");
    }

    @Test
    void minimumCompletionFormTest() {
        page.openPage()
                .setFirstName("Pavel")
                .setLastName("Kashintsev")
                .setGender("Male")
                .setMobileNumber("0123456789")
                .submitForm();

        page.checkVisibilityOfResultsWindow(true)
                .checkHeaderOfResultsWindow("Thanks for submitting the form")
                .checkHeaderOfResultsTable("Label", "Values")
                .checkContentOfResultsTable("Student Name", "Pavel Kashintsev")
                .checkContentOfResultsTable("Gender", "Male")
                .checkContentOfResultsTable("Mobile", "0123456789");
    }

    @Test
    void invalidEmailTest() {
        page.openPage()
                .setFirstName("Pavel")
                .setLastName("Kashintsev")
                .setEmail("...some email...")
                .setGender("Male")
                .setMobileNumber("0123456789")
                .setDateOfBirth("29", "May", "1990")
                .setSubjects("Chemistry", "Math")
                .setHobbies("Reading", "Music")
                .uploadFileFromClasspath("picture.jpg")
                .setCurrentAddress("...some address...")
                .setState("Haryana")
                .setCity("Karnal")
                .submitForm();

        page.checkVisibilityOfResultsWindow(false);
    }

    @Test
    void invalidMobileNumberTest() {
        page.openPage()
                .setFirstName("Pavel")
                .setLastName("Kashintsev")
                .setEmail("adress@test.com")
                .setGender("Male")
                .setMobileNumber("123456789")
                .setDateOfBirth("29", "May", "1990")
                .setSubjects("Chemistry", "Math")
                .setHobbies("Reading", "Music")
                .uploadFileFromClasspath("picture.jpg")
                .setCurrentAddress("...some address...")
                .setState("Haryana")
                .setCity("Karnal")
                .submitForm();

        page.checkVisibilityOfResultsWindow(false);
    }
}
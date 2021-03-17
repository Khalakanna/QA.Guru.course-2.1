package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;

public class FormFillerTests {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }


    @Test
    void successfulFillerTest() {
        open("https://demoqa.com/automation-practice-form");

        $("#firstName").setValue("Anna");
        $("#lastName").setValue("Khalak");
        $("#userEmail").setValue("Anna@anna.an");
        $("[for='gender-radio-2']").click();
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("7");
        $(".react-datepicker__year-select").selectOptionByValue("1991");
        $("[aria-label='Choose Friday, August 30th, 1991']").click();
        $("#subjectsInput").setValue("Math").pressEnter();
        $("[for='hobbies-checkbox-3']").click();
        $("#uploadPicture").uploadFromClasspath("testing.gif");
        $("#currentAddress").setValue("World");
        $("#react-select-3-input").setValue("Haryana").pressEnter();
        $("#react-select-4-input").setValue("Panipat").pressEnter();
        $("#submit").click();

        $(".table").shouldHave(text("Anna"),
                text("Khalak"),
                text("Anna@anna.an"),
                text("Female"),
                text("1234567890"),
                text("30 August,1991"),
                text("Music"),
                text("testing.gif"),
                text("World"),
                text("Haryana Panipat"));
    }
}

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class NegativeTests {

    @Test
    void lockedUserTest(){
        open("https://www.saucedemo.com/");
        $("#user-name").setValue("locked_out_user");
        $("[data-test=password]").setValue("secret_sauce");
        $(".submit-button").click();
        $("[data-test=error]").shouldHave(text("Epic sadface: Sorry, this user has been locked out."));
        sleep(2000);
    }

    @Test
    void blockedShippingTest(){
        open("https://www.saucedemo.com/");
        $("#user-name").setValue("error_user");
        $("[data-test=password]").setValue("secret_sauce");
        $(".submit-button").click();
        $("[data-test=shopping-cart-link]").click();
        $("#checkout").click();
        $("#first-name").setValue("Nikita");
        $("#last-name").setValue("Starkov");
        $("#postal-code").setValue("200600");
        $("#continue").click();
        $("#last-name").shouldHave(attribute("[placeholder=Last Name]"));
        sleep(2000);
    }
}